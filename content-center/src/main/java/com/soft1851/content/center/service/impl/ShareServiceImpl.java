package com.soft1851.content.center.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.soft1851.content.center.domain.dto.*;
import com.soft1851.content.center.domain.entity.AuditStatusEnum;
import com.soft1851.content.center.domain.entity.MidUserShare;
import com.soft1851.content.center.domain.entity.Share;
import com.soft1851.content.center.feignclient.UserCenterFeignClient;
import com.soft1851.content.center.mapper.MidUserShareMapper;
import com.soft1851.content.center.mapper.ShareMapper;
import com.soft1851.content.center.service.ShareService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author zeng
 * @Date 2020/9/29 15:43
 * @Description
 * @Version 1.0
 */
@Service
public class ShareServiceImpl implements ShareService {

    @Resource
    private ShareMapper shareMapper;

    @Resource
    private MidUserShareMapper midUserShareMapper;

    @Resource
    private UserCenterFeignClient userCenterFeignClient;

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public ShareDto findById(Integer id) {
        Share share = shareMapper.selectByPrimaryKey(id);
        Integer userId = share.getUserId();
        UserDto userDto = userCenterFeignClient.findById(userId);
        assert userDto != null;
        ShareDto shareDto = new ShareDto();
//        BeanUtils.copyProperties(share, shareDto);
        shareDto.setShare(share);
        shareDto.setWxNickname(userDto.getWxNickname());

        return shareDto;
    }

    @Override
    public PageInfo<Share> query(String title, Integer pageNo, Integer pageSize, Integer userId) {

        //启动分页
        PageHelper.startPage(pageNo, pageSize);
        //构造查询实例
        Example example = new Example(Share.class);
        Example.Criteria criteria = example.createCriteria();
        //如标题关键字不空，则加上模糊查询条件，否则结果即所有数据
        if (StringUtil.isNotEmpty(title)) {
            criteria.andLike("title", "%" + title + "%");
        }
        //执行按条件查询
        List<Share> shares = this.shareMapper.selectByExample(example);
        //处理后的Share数据列表
        List<Share> sharesDeal;
        //1.如果用户未登录，那么downloadUrL全部设为null
        if (userId == null) {
            sharesDeal = shares.stream()
                    .peek(share -> {
                        share.setDownloadUrl(null);
                    })
                    .collect(Collectors.toList());
        }
        //2.如果用户登录了，那么查询一下mid_user_share,如果没有数据，那么这条share的downloadUrl也设为null
        //只有自己分享的资源才能直接看到下载链接，否则显示"兑换"
        else {
            sharesDeal = shares.stream()
                    .peek(share -> {
                        MidUserShare midUserShare = this.midUserShareMapper.selectOne(
                                MidUserShare.builder()
                                        .userId(userId)
                                        .shareId(share.getId())
                                        .build()
                        );
                        if (midUserShare == null) {
                            share.setDownloadUrl(null);
                        }
                    }).collect(Collectors.toList());
        }
        return new PageInfo<>(sharesDeal);
    }

    @Override
    public Share contribute(ShareRequestDto shareRequestDto) {
        Share share = new Share();
        BeanUtils.copyProperties(shareRequestDto, share);
        share.setUserId(1);
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setCover("cover");
        share.setBuyCount(0);
        share.setShowFlag(true);
        share.setAuditStatus("NOT_YET");
        share.setReason("");
        shareMapper.insert(share);
        return share;
    }

    @Override
    public Share redactShare(Integer id, ShareRequestDto shareRequestDto) {
        Share share = shareMapper.selectByPrimaryKey(id);
        share.setAuthor(shareRequestDto.getAuthor());
        share.setDownloadUrl(shareRequestDto.getDownloadUrl());
        share.setIsOriginal(shareRequestDto.getIsOriginal());
        share.setPrice(shareRequestDto.getPrice());
        share.setSummary(shareRequestDto.getSummary());
        share.setTitle(shareRequestDto.getTitle());
        shareMapper.updateByPrimaryKey(share);
        return share;
    }

    @Override
    public Share auditById(Integer id, ShareAuditDto shareAuditDto) {
        Share share = shareMapper.selectByPrimaryKey(id);
        if (share == null) {
            throw new IllegalArgumentException("参数非法！该分享不存在！");
        }
        if (!Objects.equals("NOT_YET", share.getAuditStatus())) {
            System.out.println(share);
            throw new IllegalArgumentException("参数非法！该分享已经审核通过或被拒绝!");
        }
        share.setAuditStatus(shareAuditDto.getAuditStatusEnum().toString());
        share.setReason(shareAuditDto.getReason());
        shareMapper.updateByPrimaryKey(share);

        if (AuditStatusEnum.PASSED.equals(shareAuditDto.getAuditStatusEnum())) {
            // 给rocket发消息 异步
//            this.rocketMQTemplate.convertAndSend(
//                    "add-bonus",
//                    UserAddBonusMsgDto.builder()
//                    .userId(share.getUserId())
//                    .bonus(50)
//                    .build());

            // 通过feign调用用户中心来修改积分 同步
            this.userCenterFeignClient.addBonus(UserAddBonusMsgDto.builder()
                    .userId(share.getUserId())
                    .bonus(50)
                    .build());
        }
        return share;
    }
}

package com.soft1851.content.center.service.impl;

import com.soft1851.content.center.common.ResponseResult;
import com.soft1851.content.center.dto.ShareDto;
import com.soft1851.content.center.dto.UserDto;
import com.soft1851.content.center.entity.Share;
import com.soft1851.content.center.entity.User;
import com.soft1851.content.center.feignclient.UserCenterFeignClient;
import com.soft1851.content.center.mapper.ShareMapper;
import com.soft1851.content.center.service.ShareService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
    private UserCenterFeignClient userCenterFeignClient;

    @Override
    public ShareDto findById(Integer id) {
        Share share = shareMapper.selectByPrimaryKey(id);
        Integer userId  = share.getUserId();
        UserDto userDto = userCenterFeignClient.findById(userId);
        assert userDto != null;
        ShareDto shareDto = new ShareDto();
        BeanUtils.copyProperties(share, shareDto);
        shareDto.setWxNickname(userDto.getWxNickname());
        return shareDto;
    }
}

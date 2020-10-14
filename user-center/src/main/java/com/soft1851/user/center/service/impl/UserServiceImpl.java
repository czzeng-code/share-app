package com.soft1851.user.center.service.impl;

import com.soft1851.user.center.domain.dto.LoginDto;
import com.soft1851.user.center.domain.dto.UserAddBonusMsgDto;
import com.soft1851.user.center.domain.dto.UserDto;
import com.soft1851.user.center.domain.entity.BonusEventLog;
import com.soft1851.user.center.mapper.BonusEventLogMapper;
import com.soft1851.user.center.mapper.UserMapper;
import com.soft1851.user.center.domain.entity.User;
import com.soft1851.user.center.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 分享(User)表服务实现类
 *
 * @author zeng
 * @since 2020-09-29 16:27:09
 */
@Service("userService")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final BonusEventLogMapper bonusEventLogMapper;

    @Override
    public UserDto findById(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return UserDto.builder()
                .id(user.getId())
                .wxNickname(user.getWxNickname())
                .build();
    }

    @Override
    public void addBonus(UserAddBonusMsgDto userAddBonusMsgDto) {
        // 1. 加积分
        Integer userId = userAddBonusMsgDto.getUserId();
        User user = userMapper.selectByPrimaryKey(userId);
        // 所加积分数
        Integer bonus = userAddBonusMsgDto.getBonus();
        user.setBonus(user.getBonus() + bonus);
        userMapper.updateByPrimaryKeySelective(user);
        // 2.写积分日志
        bonusEventLogMapper.insert(BonusEventLog.builder()
                .userId(userId)
                .value(bonus)
                .event("CONTRIBUTE")
                .createTime(new Date())
                .description("投稿加积分")
                .build()
        );
    }

    @Override
    public User login(LoginDto loginDto, String openId) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wxId", openId);
        List<User> users = userMapper.selectByExample(example);
        // 新用户直接注册
        if (users.size() == 0) {
            User saveUser = User.builder()
                    .wxId(openId)
                    .avatarUrl(loginDto.getAvatarUrl())
                    .wxNickname(loginDto.getWxNickname())
                    .roles("user")
                    .bonus(100)
                    .createTime(new Date())
                    .updateTime(new Date())
                    .build();
            this.userMapper.insertSelective(saveUser);
            return saveUser;
        }
        return users.get(0);
    }
}
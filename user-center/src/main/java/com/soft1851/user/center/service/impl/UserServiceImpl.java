package com.soft1851.user.center.service.impl;

import com.soft1851.user.center.dto.UserDto;
import com.soft1851.user.center.mapper.UserMapper;
import com.soft1851.user.center.entity.User;
import com.soft1851.user.center.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分享(User)表服务实现类
 *
 * @author zeng
 * @since 2020-09-29 16:27:09
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDto findById(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return UserDto.builder()
                .id(user.getId())
                .wxNickname(user.getWxNickname())
                .build();
    }
}
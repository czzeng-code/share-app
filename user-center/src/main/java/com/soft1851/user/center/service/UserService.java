package com.soft1851.user.center.service;

import com.soft1851.user.center.dto.UserDto;
import com.soft1851.user.center.entity.User;

import java.util.List;

/**
 * 分享(User)表服务接口
 *
 * @author zeng
 * @since 2020-09-29 16:27:09
 */
public interface UserService {

    UserDto findById(Integer userId);

}
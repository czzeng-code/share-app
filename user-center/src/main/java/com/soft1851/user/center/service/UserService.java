package com.soft1851.user.center.service;

import com.soft1851.user.center.domain.dto.LoginDto;
import com.soft1851.user.center.domain.dto.UserAddBonusMsgDto;
import com.soft1851.user.center.domain.dto.UserDto;
import com.soft1851.user.center.domain.entity.User;

/**
 * 分享(User)表服务接口
 *
 * @author zeng
 * @since 2020-09-29 16:27:09
 */
public interface UserService {

    UserDto findById(Integer userId);

    /**
     * 加积分
     * @param userAddBonusMsgDto
     */
    void addBonus(UserAddBonusMsgDto userAddBonusMsgDto);

    /**
     * 登录
     * @param loginDto
     * @return
     */
    User login(LoginDto loginDto, String openId);

}
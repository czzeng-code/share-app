package com.soft1851.user.center.controller;

import com.soft1851.user.center.common.ResponseResult;
import com.soft1851.user.center.dto.UserDto;
import com.soft1851.user.center.entity.User;
import com.soft1851.user.center.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 分享(User)表控制层
 *
 * @author zeng
 * @since 2020-09-29 16:27:10
 */
@RestController
@RequestMapping("/users")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

}
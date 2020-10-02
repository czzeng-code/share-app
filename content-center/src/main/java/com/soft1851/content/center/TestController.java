package com.soft1851.content.center;

import com.soft1851.content.center.dto.UserDto;
import com.soft1851.content.center.feignclient.BaiduFeignClient;
import com.soft1851.content.center.feignclient.TestUserCenterFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zeng
 * @Date 2020/9/30 11:05
 * @Description
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @Resource
    private TestUserCenterFeignClient testUserCenterFeignClient;

    @Resource
    private BaiduFeignClient baiduFeignClient;

    @GetMapping("/test-q")
    public UserDto query(UserDto userDto) {
        return testUserCenterFeignClient.query(userDto);
    }

    @GetMapping(value = "/baidu")
    public String baiduIndex() {
        return this.baiduFeignClient.index();
    }
}

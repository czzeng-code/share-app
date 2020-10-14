package com.soft1851.content.center.feignclient;

import com.soft1851.content.center.domain.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author zeng
 * @Date 2020/9/30 11:04
 * @Description
 * @Version 1.0
 */
@FeignClient(name = "user-center")
public interface TestUserCenterFeignClient {

    @GetMapping("/users/q")
    UserDto query(@SpringQueryMap UserDto userDto);
}

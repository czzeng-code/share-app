package com.soft1851.content.center.feignclient;

import com.soft1851.content.center.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zeng
 * @Date 2020/9/29 19:25
 * @Description
 * @Version 1.0
 */
@FeignClient(name = "user-center")
public interface UserCenterFeignClient {

    /**
     * user-center
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    UserDto findById(@PathVariable Integer id);


}

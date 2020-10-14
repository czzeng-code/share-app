package com.soft1851.content.center.feignclient;

import com.soft1851.content.center.configuration.UserCenterFeignConfiguration;
import com.soft1851.content.center.domain.dto.UserAddBonusMsgDto;
import com.soft1851.content.center.domain.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author zeng
 * @Date 2020/9/29 19:25
 * @Description
 * @Version 1.0
 */
@FeignClient(name = "user-center", configuration = UserCenterFeignConfiguration.class)
public interface UserCenterFeignClient {

    /**
     * user-center
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    UserDto findById(@PathVariable Integer id);

    @PutMapping("/users/bonus")
    void addBonus(@RequestBody UserAddBonusMsgDto userAddBonusMsgDto);

}

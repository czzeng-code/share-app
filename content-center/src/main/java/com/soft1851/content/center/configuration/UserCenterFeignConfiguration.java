package com.soft1851.content.center.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Author zeng
 * @Date 2020/9/30 10:17
 * @Description
 * @Version 1.0
 */
public class UserCenterFeignConfiguration {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}

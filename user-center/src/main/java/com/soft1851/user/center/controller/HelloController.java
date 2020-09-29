package com.soft1851.user.center.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebListener;

/**
 * @Author zeng
 * @Date 2020/9/22 17:14
 * @Description
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/nacos")
    public String getHello() {
        log.info("我被调用了嘿嘿");
        return "Hello ,this is user-center";
    }
}

package com.soft1851.content.center.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zeng
 * @Date 2020/9/22 17:14
 * @Description
 * @Version 1.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/nacos")
    public String getHello() {
        return "Hello Nacos";
    }
}

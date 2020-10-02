package com.soft1851.content.center.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author zeng
 * @Date 2020/9/30 11:34
 * @Description
 * @Version 1.0
 */
@FeignClient(name = "baidu", url = "http://baidu.com")
public interface BaiduFeignClient {

    @GetMapping("")
    String index();

}

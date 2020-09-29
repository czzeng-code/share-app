package com.soft1851.content.center.controler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zeng
 * @Date 2020/9/23 8:36
 * @Description
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/discovery")
    public List<ServiceInstance> getInstance() {
        return this.discoveryClient.getInstances("user-center");

    }

    @GetMapping("/call/hello")
    public String callUserCenter() {
        //用户中心所有的实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
        //stream编程、Lambda表达式、函数式编程
//        String targetUrl = instances.stream()
//                .map(instance -> instance.getUri().toString() + "/hello/nacos")
//                .findAny()
//                .orElseThrow(() -> new IllegalArgumentException("当前没有实例！"));
        int i = RandomUtils.nextInt(instances.size());
        log.info(i+"");
        String targetUrl = instances.get(i).getUri().toString() + "/hello/nacos";
        log.info("url, {}", targetUrl);
        return restTemplate.getForObject(targetUrl, String.class);
        }

        @GetMapping("/call/ribbon")
        public String callByRibbon() {
            return restTemplate.getForObject("http://user-center/hello/nacos", String.class);
        }
    }

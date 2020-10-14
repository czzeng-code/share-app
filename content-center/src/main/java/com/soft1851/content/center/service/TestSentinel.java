package com.soft1851.content.center.service;

import org.springframework.web.client.RestTemplate;

/**
 * @Author zeng
 * @Date 2020/10/6 15:47
 * @Description
 * @Version 1.0
 */
public class TestSentinel {
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 100; i++) {
            String object = restTemplate.getForObject("http://localhost:8050/test/byResource", String.class);
            System.out.println("okk");
            Thread.sleep(1000);
        }
    }
}

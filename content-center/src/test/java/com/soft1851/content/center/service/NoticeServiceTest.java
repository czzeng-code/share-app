package com.soft1851.content.center.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author zeng
 * @Date 2020/10/4 21:19
 * @Description
 * @Version 1.0
 */
@SpringBootTest
class NoticeServiceTest {
    @Autowired
    private NoticeService noticeService;

    @Test
    void getLatest() {
        System.out.println(noticeService.getLatest());
    }
}
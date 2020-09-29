package com.soft1851.content.center.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author zeng
 * @Date 2020/9/29 15:51
 * @Description
 * @Version 1.0
 */
@SpringBootTest
class ShareMapperTest {

    @Resource
    private ShareMapper shareMapper;

    @Test
    void name() {
        System.out.println(shareMapper.selectAll());
    }
}
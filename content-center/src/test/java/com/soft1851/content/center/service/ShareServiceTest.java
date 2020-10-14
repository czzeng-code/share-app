package com.soft1851.content.center.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.content.center.domain.dto.ShareAuditDto;
import com.soft1851.content.center.domain.entity.AuditStatusEnum;
import com.soft1851.content.center.domain.entity.Share;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author zeng
 * @Date 2020/10/4 21:57
 * @Description
 * @Version 1.0
 */
@SpringBootTest
class ShareServiceTest {
    @Autowired
    private ShareService shareService;

    @Test
    void query() {
        PageInfo<Share> query = shareService.query(null, 1, 10, 3);
        List<Share> list = query.getList();
        list.forEach(System.out::println);
    }

    @Test
    void auditById() {
        shareService.auditById(12, ShareAuditDto.builder()
                .auditStatusEnum(AuditStatusEnum.PASSED)
                .reason("ok")
                .build());

    }
}
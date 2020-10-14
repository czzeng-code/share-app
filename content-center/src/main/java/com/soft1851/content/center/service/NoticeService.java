package com.soft1851.content.center.service;

import com.soft1851.content.center.domain.entity.Notice;

/**
 * @Author zeng
 * @Date 2020/10/4 21:10
 * @Description
 * @Version 1.0
 */
public interface NoticeService {
    /**
     * 查最新公告
     * @return
     */
    Notice getLatest();
}

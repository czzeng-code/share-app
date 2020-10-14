package com.soft1851.content.center.service;

import com.github.pagehelper.PageInfo;
import com.soft1851.content.center.domain.dto.ShareAuditDto;
import com.soft1851.content.center.domain.dto.ShareRequestDto;
import com.soft1851.content.center.domain.dto.ShareDto;
import com.soft1851.content.center.domain.entity.Share;

/**
 * @Author zeng
 * @Date 2020/9/29 15:42
 * @Description
 * @Version 1.0
 */
public interface ShareService {

    /**
     * 通过share id查询
     * @param id id
     * @return ShareDto
     */
    ShareDto findById(Integer id);

    /**
     * 根据标题查
     * @param title
     * @param pageNo
     * @param pageSize
     * @param userId
     * @return
     */
    PageInfo<Share> query(String title, Integer pageNo, Integer pageSize, Integer userId);

    /**
     * 投稿
     * @param shareRequestDto
     * @return
     */
    Share contribute(ShareRequestDto shareRequestDto);

    /**
     * 编辑投稿
     * @param id
     * @param shareRequestDto
     * @return
     */
    Share redactShare(Integer id, ShareRequestDto shareRequestDto);

    /**
     * 审核
     * @param id
     * @param shareAuditDto
     * @return
     */
    Share auditById(Integer id, ShareAuditDto shareAuditDto);

}

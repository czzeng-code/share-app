package com.soft1851.content.center.service;

import com.soft1851.content.center.dto.ShareDto;

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

}

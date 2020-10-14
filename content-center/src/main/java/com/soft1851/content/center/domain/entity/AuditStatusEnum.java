package com.soft1851.content.center.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author zeng
 * @Date 2020/10/8 9:47
 * @Description
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum  AuditStatusEnum {
    /**
     * 待审核
     */
    NOT_YET,
    /**
     * 审核通过
     */
    PASSED,
    /**
     * 审核不通过
     */
    REJECTED
}

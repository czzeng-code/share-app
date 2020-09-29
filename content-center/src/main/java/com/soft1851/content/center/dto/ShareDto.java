package com.soft1851.content.center.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.Date;

/**
 * @Author zeng
 * @Date 2020/9/29 16:16
 * @Description
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShareDto {

    private Integer id;
    /**
     * 发布人id
     */
    private Integer userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 是否原创 0:否 1:是
     */
    private Boolean isOriginal;
    /**
     * 作者
     */
    private String author;
    /**
     * 封面
     */
    private String cover;
    /**
     * 概要信息
     */
    private String summary;
    /**
     * 价格（需要的积分）
     */
    private Integer price;
    /**
     * 下载地址
     */
    private String downloadUrl;
    /**
     * 下载数
     */
    private Integer buyCount;
    /**
     * 是否显示 0:否 1:是
     */
    private Boolean showFlag;
    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    private String auditStatus;
    /**
     * 审核不通过原因
     */
    private String reason;

    /**
     * 微信昵称
     */
    private String wxNickname;
}

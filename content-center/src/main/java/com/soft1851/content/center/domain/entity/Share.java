package com.soft1851.content.center.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 分享表(Share)实体类
 *
 * @author zeng
 * @since 2020-09-29 15:31:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("分享")
@Table(name = "share")
public class Share implements Serializable {
    private static final long serialVersionUID = 911347182512241086L;
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(name = "id", value = "分享id")
    private Integer id;
    /**
     * 发布人id
     */
    @ApiModelProperty(name = "userId", value = "发布人id")
    private Integer userId;
    /**
     * 标题
     */
    @ApiModelProperty(name = "title", value = "标题")
    private String title;
    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(name = "updateTime", value = "修改时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否原创 0:否 1:是
     */
    @Column(name = "is_original")
    @ApiModelProperty(name = "isOriginal", value = "是否原创")
    private Boolean isOriginal;
    /**
     * 作者
     */
    @ApiModelProperty(name = "author", value = "作者")
    private String author;
    /**
     * 封面
     */
    @ApiModelProperty(name = "cover", value = "封面")
    private String cover;
    /**
     * 概要信息
     */
    @ApiModelProperty(name = "summary", value = "概要信息")
    private String summary;
    /**
     * 价格（需要的积分）
     */
    @ApiModelProperty(name = "price", value = "价格")
    private Integer price;
    /**
     * 下载地址
     */
    @ApiModelProperty(name = "downloadUrl", value = "分享id")
    private String downloadUrl;
    /**
     * 下载数
     */
    @ApiModelProperty(name = "buyCount", value = "下载数")
    private Integer buyCount;
    /**
     * 是否显示 0:否 1:是
     */
    @ApiModelProperty(name = "showFlag", value = "是否显示")
    private Boolean showFlag;
    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    private String auditStatus;
    /**
     * 审核不通过原因
     */
    @ApiModelProperty(name = "reason", value = "审核不通过原因")
    private String reason;



}
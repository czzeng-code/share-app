package com.soft1851.content.center.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * (Notice)实体类
 *
 * @author zeng
 * @since 2020-10-04 20:09:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "notice")
@ApiModel("公告")
public class Notice implements Serializable {
    private static final long serialVersionUID = 394480647788972425L;
    /**
     * id
     */
    @ApiModelProperty(name = "id", value = "公告id")
    private Integer id;
    /**
     * 内容
     */
    @ApiModelProperty(name = "content", value = "公告内容")
    private String content;
    /**
     * 是否显示 0:否 1:是
     */
    @ApiModelProperty(name = "showFlag", value = "是否显示 0：否 1：是")
    private Boolean showFlag;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;



}
package com.soft1851.content.center.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

/**
 * @Author zeng
 * @Date 2020/10/7 9:06
 * @Description
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("投稿详情")
public class ShareRequestDto {
    /**
     * 发布人id
     */
    @ApiModelProperty(name = "author",value = "资源作者")
    private  String author;

    @ApiModelProperty(name = "downloadUrl",value = "下载地址")
    private  String downloadUrl;

    @ApiModelProperty(name = "isOriginal",value = "是否原创 0：否 1：是")
    private Boolean isOriginal;


    @ApiModelProperty(name = "price",value = "下载所需积分")
    private  Integer price;

    @ApiModelProperty(name = "summary",value = "资源摘要")
    private  String summary;

    @ApiModelProperty(name="title",value = "分享内容标题")
    private  String title;

}
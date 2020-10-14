package com.soft1851.content.center.domain.dto;

import com.soft1851.content.center.domain.entity.Share;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
@ApiModel("分享详情")
public class ShareDto {

    /**
     * 分享信息
     */
    @ApiModelProperty(name = "share", value = "分享资源信息")
    private Share share;

    /**
     * 微信昵称
     */
    @ApiModelProperty(name = "wxNickname", value = "发布人昵称")
    private String wxNickname;
}

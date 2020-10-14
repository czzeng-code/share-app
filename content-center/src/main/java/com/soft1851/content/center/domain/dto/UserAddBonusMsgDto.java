package com.soft1851.content.center.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zeng
 * @Date 2020/10/8 10:59
 * @Description
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户加积分Dto")
public class UserAddBonusMsgDto {

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;


    /**
     * 加积分数
     */
    @ApiModelProperty("加积分数")
    private Integer bonus;

}

package com.soft1851.content.center.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * @Author zeng
 * @Date 2020/9/29 16:32
 * @Description
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;

    /**
     * 微信昵称
     */
    private String wxNickname;
}

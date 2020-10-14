package com.soft1851.user.center.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zeng
 * @Date 2020/10/12 12:29
 * @Description
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDto {
    private String openId;
    private String loginCode;
    private String wxNickname;
    private String avatarUrl;
}

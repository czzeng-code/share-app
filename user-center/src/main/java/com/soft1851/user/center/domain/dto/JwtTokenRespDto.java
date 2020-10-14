package com.soft1851.user.center.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zeng
 * @Date 2020/10/13 15:38
 * @Description
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtTokenRespDto {
    private String token;
    private Long expirationTime;
}

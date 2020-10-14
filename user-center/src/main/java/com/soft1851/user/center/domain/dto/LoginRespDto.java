package com.soft1851.user.center.domain.dto;

import com.soft1851.user.center.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zeng
 * @Date 2020/10/12 12:40
 * @Description
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRespDto {
    private UserRespDto user;
    private JwtTokenRespDto token;
}

package com.soft1851.user.center.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.persistence.Id;

/**
 * @Author zeng
 * @Date 2020/9/29 16:32
 * @Description
 * @Version 1.0
 */
@Data
@Builder
public class UserDto {

    @Id
    private Integer id;

    /**
     * 微信昵称
     */
    private String wxNickname;
}

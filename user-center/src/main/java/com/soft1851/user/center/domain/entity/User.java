package com.soft1851.user.center.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 分享(User)实体类
 *
 * @author zeng
 * @since 2020-09-29 16:27:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -95057739721797378L;
    /**
     * Id
     */
    @Id
    private Integer id;
    /**
     * 微信id
     */
    private String wxId;
    /**
     * 微信昵称
     */
    private String wxNickname;
    /**
     * 角色
     */
    private String roles;
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 积分
     */
    private Integer bonus;


}
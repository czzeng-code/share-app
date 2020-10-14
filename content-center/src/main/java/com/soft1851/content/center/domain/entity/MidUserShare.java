package com.soft1851.content.center.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户-分享中间表【描述用户购买的分享】(MidUserShare)实体类
 *
 * @author zeng
 * @since 2020-10-04 21:44:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "mid_user_share")
public class MidUserShare implements Serializable {
    private static final long serialVersionUID = -36042025312514473L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    /**
     * share.id
     */
    @Column(name = "share_id")
    private Integer shareId;
    /**
     * user.id
     */
    @Column(name = "user_id")
    private Integer userId;



}
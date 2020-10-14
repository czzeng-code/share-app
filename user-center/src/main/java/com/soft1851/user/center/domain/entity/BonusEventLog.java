package com.soft1851.user.center.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 积分变更记录表(BonusEventLog)实体类
 *
 * @author zeng
 * @since 2020-10-08 13:34:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bonus_event_log")
public class BonusEventLog implements Serializable {
    private static final long serialVersionUID = 941614619010393087L;
    /**
     * Id
     */
    private Integer id;
    /**
     * user.id
     */
    private Integer userId;
    /**
     * 积分操作值
     */
    private Integer value;
    /**
     * 发生的事件
     */
    private String event;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 描述
     */
    private String description;



}
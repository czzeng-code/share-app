package com.soft1851.content.center.domain.dto;

import com.soft1851.content.center.domain.entity.AuditStatusEnum;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zeng
 * @Date 2020/10/7 23:18
 * @Description
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("分享审核DTO")
public class ShareAuditDto {
    private AuditStatusEnum auditStatusEnum;

    private String reason;

}

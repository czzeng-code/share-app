package com.soft1851.content.center.controler;

import com.soft1851.content.center.domain.dto.ShareAuditDto;
import com.soft1851.content.center.domain.entity.Share;
import com.soft1851.content.center.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zeng
 * @Date 2020/10/8 12:34
 * @Description
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "分享管理")
public class ShareAdminController {
    private final ShareService shareService;

    @PutMapping(value = "/audit/{id}")
    @ApiOperation(notes = "审核分享", value = "审核分享")
    public Share auditById(@PathVariable Integer id, @RequestBody ShareAuditDto auditDto) {
        // 在此处认证授权
        return shareService.auditById(id, auditDto);
    }
}

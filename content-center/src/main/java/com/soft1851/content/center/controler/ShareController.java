package com.soft1851.content.center.controler;

import com.soft1851.content.center.domain.dto.ShareDto;
import com.soft1851.content.center.domain.dto.ShareRequestDto;
import com.soft1851.content.center.domain.entity.Share;
import com.soft1851.content.center.service.ShareService;
import com.soft1851.content.center.util.JwtOperator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @Author zeng
 * @Date 2020/9/29 15:43
 * @Description
 * @Version 1.0
 */
@RestController
@RequestMapping("/shares")
@Api(tags = "分享接口", value = "提供分享相关API")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ShareController {

    private final ShareService shareService;
    private final JwtOperator jwtOperator;

    @GetMapping("/{id}")
    @ApiOperation(value = "查询指定id的分享详情", notes = "查询指定id的分享详情")
    public ShareDto findById(@PathVariable Integer id) {
        return shareService.findById(id);
    }

    @GetMapping("/query")
    @ApiOperation(value = "分享列表", notes = "分享列表")
    public List<Share> query(
            @RequestParam(required = false) String title,
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestHeader(required = false, value = "X-Token") String token) throws Exception {
        if (pageSize > 100) {
            pageSize = 100;
        }
        Integer userId = null;
        if (StringUtils.isNotBlank(token)) {
            Claims claims = this.jwtOperator.getClaimsFromToken(token);
            log.info(claims.toString());
            userId = (Integer) claims.get("id");
        } else {
            log.info("没有token");
        }
        return shareService.query(title, pageNo, pageSize, userId).getList();
    }

    @PostMapping("/contribute")
    @ApiOperation(value = "投稿", notes = "投稿")
    public Share shareRequest(@RequestBody ShareRequestDto shareRequestDto) {
        return shareService.contribute(shareRequestDto);
    }

    @PutMapping("/contribute/{id}")
    @ApiOperation(value = "编辑投稿", notes = "根据id编辑投稿")
    public Share contributeById(@PathVariable Integer id, ShareRequestDto shareRequestDto) {
        return shareService.redactShare(id, shareRequestDto);
    }
}

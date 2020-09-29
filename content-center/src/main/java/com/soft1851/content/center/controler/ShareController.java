package com.soft1851.content.center.controler;

import com.soft1851.content.center.common.ResponseResult;
import com.soft1851.content.center.service.ShareService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zeng
 * @Date 2020/9/29 15:43
 * @Description
 * @Version 1.0
 */
@RestController
@RequestMapping("/content")
public class ShareController {

    @Resource
    private ShareService shareService;

    @GetMapping("/{id}")
    public ResponseResult findById(@PathVariable Integer id) {
        return new ResponseResult(200, "请求成功", shareService.findById(id));
    }
}

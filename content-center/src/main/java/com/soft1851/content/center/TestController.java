package com.soft1851.content.center;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.soft1851.content.center.domain.dto.UserDto;
import com.soft1851.content.center.feignclient.BaiduFeignClient;
import com.soft1851.content.center.feignclient.TestUserCenterFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;

import javax.annotation.Resource;

/**
 * @Author zeng
 * @Date 2020/9/30 11:05
 * @Description
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class TestController {

    private final AsyncRestTemplate asyncRestTemplate;

    private final TestUserCenterFeignClient testUserCenterFeignClient;

    private final BaiduFeignClient baiduFeignClient;

    @GetMapping("/test-q")
    public UserDto query(UserDto userDto) {
        return testUserCenterFeignClient.query(userDto);
    }

//    @GetMapping(value = "/baidu")
    public String baiduIndex() {
        return this.baiduFeignClient.index();
    }

    @GetMapping("byResource")
    @SentinelResource(value = "hello", blockHandler = "handleException")
    public String byResource() {
        return "按名称限流";
    }

    public String handleException(BlockException blockException) {
        return "服务不可用";
    }


    /**
     * 测试AsyncTemplate
     * @return
     */
    @GetMapping("/testAsync")
    public String TestAsyncTemplate() {
        String url = "http://localhost:8014/users/1";
        log.info("Start");
        ListenableFuture<ResponseEntity<String>> entity = asyncRestTemplate.getForEntity(url, String.class);
        entity.addCallback(new SuccessCallback<ResponseEntity<String>>() {
            @Override
            public void onSuccess(ResponseEntity<String> result) {
                log.info("A");
            }
        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("B");
            }
        });
        log.info("C");
        return "End";
    }
}

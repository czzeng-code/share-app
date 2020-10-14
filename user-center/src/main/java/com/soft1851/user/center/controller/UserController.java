package com.soft1851.user.center.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.soft1851.user.center.domain.dto.*;
import com.soft1851.user.center.domain.entity.User;
import com.soft1851.user.center.service.UserService;
import com.soft1851.user.center.util.JwtOperator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 分享(User)表控制层
 *
 * @author zeng
 * @since 2020-09-29 16:27:10
 */
@RestController
@RequestMapping("/users")
@Slf4j
@Api(tags = "用户控制器")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    /**
     * 服务对象
     */
    private final UserService userService;
    private final WxMaService wxMaService;
    private final JwtOperator jwtOperator;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/q")
    public User query(User user) {
        return user;
    }

    @PutMapping("/bonus")
    public void addBonus(@RequestBody UserAddBonusMsgDto userAddBonusMsgDto) {
        userService.addBonus(userAddBonusMsgDto);
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录接口", tags = "登录接口")
    public LoginRespDto getToken(@RequestBody LoginDto loginDto) throws WxErrorException {
        String openId;
        //微信小程序登录，需要根据code请求openId
        if (loginDto.getLoginCode() != null) {
        //微信服务端校验是否已经登录的结果
            WxMaJscode2SessionResult result = this.wxMaService.getUserService()
                    .getSessionInfo(loginDto.getLoginCode());

            log.info(result.toString());
        //微信的openId,用户在微信这边的唯一标识
            openId = result.getOpenid();
        } else {
            openId = loginDto.getOpenId();
        //看用户是否注册，如果没有注册就（插入）,如果已经注册就返回其信息
        }
        User user = this.userService.login(loginDto, openId);
        //颁发token
        Map<String, Object> userInfo = new HashMap<>(3);
        userInfo.put("id", user.getId());
        userInfo.put("wxNickname", user.getWxNickname());
        userInfo.put("role", user.getRoles());
        String token = jwtOperator.generateToken(userInfo);
        log.info(
                "{}登录成功，生成的token={},有效期到：{}",
                user.getWxNickname(),
                token,
                jwtOperator.getExpirationTime());
        return LoginRespDto.builder()
                .user(UserRespDto.builder()
                        .id(user.getId())
                        .wxNickname(user.getWxNickname())
                        .avatarUrl(user.getAvatarUrl())
                        .bonus(user.getBonus())
                        .build())
                .token(JwtTokenRespDto
                        .builder()
                        .token(token)
                        .expirationTime(jwtOperator.getExpirationTime().getTime())
                        .build())
                .build();
    }
}
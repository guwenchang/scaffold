package com.smart.auth.center.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.smart.auth.center.config.AuthRequestFactory;
import com.smart.auth.center.request.AuthRequest;
import com.smart.starter.core.model.ApiResult;
import com.smart.starter.security.annotation.Action;
import com.smart.starter.security.annotation.Login;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author guwenchang
 * @date 2019-06-14 18:21
 */
@Api(tags = "第三方授权管理")
@RestController
@RequestMapping("/oauth")
public class RestAuthController {

    @Autowired
    private AuthRequestFactory authRequestFactory;

    @Login(action = Action.SKIP)
    @GetMapping("/render/{source}")
    public void renderAuth(@PathVariable("source") String source, HttpServletResponse response) throws IOException {
        AuthRequest authRequest = authRequestFactory.getAuthRequest(source.toUpperCase());
        response.sendRedirect(authRequest.authorize());
    }

    /**
     * oauth平台中配置的授权回调地址
     */
    @Login(action = Action.SKIP)
    @GetMapping("/callback/{source}")
    public ApiResult login(@PathVariable("source") String source, String code, String auth_code) {
        AuthRequest authRequest = authRequestFactory.getAuthRequest(source);
        // 支付宝登录时，返回auth_code
        return authRequest.login(StringUtils.isEmpty(code) ? auth_code : code);
    }



}


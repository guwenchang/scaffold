package com.smart.auth.center.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.collect.Maps;

import com.smart.auth.center.entity.SysUserEntity;
import com.smart.auth.center.param.LoginForm;
import com.smart.auth.center.result.SysMenuResult;
import com.smart.auth.center.service.ISysUserService;
import com.smart.starter.core.model.ApiResult;
import com.smart.starter.core.model.BaseController;
import com.smart.starter.log.annotation.OpLog;
import com.smart.starter.security.annotation.Action;
import com.smart.starter.security.annotation.Login;
import com.smart.starter.security.jwt.JwtOperator;
import com.smart.starter.security.jwt.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 账户管理
 *
 * @author guwenchang
 * @date 2019-05-23
 */
@Api(tags = "账户管理")
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AccountController extends BaseController {

    private final ISysUserService sysUserService;
    private final PasswordEncoder passwordEncoder;
    private final JwtOperator jwtOperator;


    @ApiOperation(value = "账户登录")
    @Login(action = Action.SKIP)
    @OpLog("用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ApiResult login(@Valid @RequestBody LoginForm loginForm) {
        SysUserEntity sysUserEntity = sysUserService.getOneByUserName(loginForm.getUsername());
        //账号不存在、密码错误
        if (sysUserEntity == null || !passwordEncoder.matches(loginForm.getPassword(), sysUserEntity.getPassword())) {
            return ApiResult.error("账号或密码错误");
        }
        if (sysUserEntity.getStatus() == 2) {
            return ApiResult.error("账户被冻结");
        }
        return login(sysUserEntity);
    }


    private ApiResult login(SysUserEntity sysUserEntity) {
        List<SysMenuResult> sysMenuResultList = sysUserService.listMenusByUserId(sysUserEntity.getId());
        List<String> permissions = sysMenuResultList.stream()
                .filter(menuResult -> StringUtils.isNotEmpty(menuResult.getPermission()))
                .map(SysMenuResult::getPermission)
                .collect(Collectors.toList());
        Map<String, Object> data = Maps.newHashMap();
        User user = User.builder()
                .userId(sysUserEntity.getId())
                .username(sysUserEntity.getUsername())
                .perms(permissions)
                .build();
        String token = jwtOperator.generateToken(user);
        data.put("token", token);
        data.put("user", user);
        return ApiResult.success(data);
    }
    public static void main(String[] args) {
        System.out.println(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"));
    }
}

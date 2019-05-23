package com.smart.admin.center.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import com.smart.admin.center.entity.SysUserEntity;
import com.smart.admin.center.param.LoginForm;
import com.smart.admin.center.service.SysUserService;
import com.smart.starter.core.model.ApiResult;
import com.smart.starter.core.model.BaseController;
import com.smart.starter.security.annotation.Action;
import com.smart.starter.security.annotation.Login;
import com.smart.starter.security.jwt.JwtOperator;
import com.smart.starter.security.jwt.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;
/**
 * 账户相关接口
 * @author guwenchang
 * @date 2019-05-23
 */
@Api(tags = "账户相关接口")
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AccountController extends BaseController {

    private final SysUserService sysUserService;
    private final PasswordEncoder passwordEncoder;
    private final JwtOperator jwtOperator;


    @ApiOperation(value = "账户登录")
    @Login(action = Action.SKIP)
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ApiResult login(@Valid @RequestBody LoginForm loginForm){
        SysUserEntity sysUserEntity = sysUserService.getOne(new QueryWrapper<SysUserEntity>().lambda()
                .eq(SysUserEntity::getUsername, loginForm.getUsername()));
        //账号不存在、密码错误
        if(sysUserEntity == null || !passwordEncoder.matches(loginForm.getPassword(),sysUserEntity.getPassword())){
            return ApiResult.error("账号或密码错误");
        }
        return login(sysUserEntity);
    }


    private ApiResult login(SysUserEntity sysUserEntity) {
        Map<String,Object> map = Maps.newHashMap();
        User user = User.builder()
                .userId(sysUserEntity.getId())
                .username(sysUserEntity.getUsername())
                .perms(Arrays.asList("user"))
                .build();
        String token = jwtOperator.generateToken(user);
        map.put("token",token);
        map.put("user",user);
        return ApiResult.success(map);
    }


}

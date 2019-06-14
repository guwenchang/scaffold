package com.smart.auth.center.model;

import lombok.Builder;
import lombok.Data;

/**
 * 用户信息
 * @author guwenchang
 * @date 2019-06-14
 */
@Builder
@Data
public class AuthUser {
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 用户网址
     */
    private String blog;
    /**
     * 所在公司
     */
    private String company;
    /**
     * 位置
     */
    private String location;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户备注（各平台中的用户个人介绍）
     */
    private String remark;
    /**
     * 性别
     */
    private AuthUserGender gender;
    /**
     * 用户来源
     */
    private AuthSource source;
    /**
     * 用户授权的token信息
     */
    private AuthToken token;
    /**
     * 用户第三方系统的唯一id。在调用方集成改组件时，可以用uuid + source唯一确定一个用户
     */
    private String uuid;
}

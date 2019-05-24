package com.smart.starter.security.constants;

/**
 * 常量
 * @author guwenchang
 * @date 2019-04-22 14:49
 */
public interface ConstantsSecurity {
    /**
     * token 在cookie中的值
     */
    String TOKEN_COOKIE_KEY = "auth_token";
    /**
     * token 在param中的值
     */
    String TOKEN_PARAM_KEY = "auth_token";

    /**
     * token header
     */
    String TOKEN_HEADER_KEY = "auth_token";
}

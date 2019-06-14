package com.smart.auth.center.utils;


import org.springframework.util.StringUtils;
import com.smart.auth.center.config.AuthConfig;

/**
 *
 * @author guwenchang
 * @date 2019-06-14
 */
public class AuthConfigChecker {

    /**
     * 是否支持第三方登录
     *
     * @param config config
     * @return true or false
     */
    public static boolean isSupportedAuth(AuthConfig config) {
        return !StringUtils.isEmpty(config.getClientId())
                && !StringUtils.isEmpty(config.getClientSecret())
                && !StringUtils.isEmpty(config.getRedirectUri());
    }
}

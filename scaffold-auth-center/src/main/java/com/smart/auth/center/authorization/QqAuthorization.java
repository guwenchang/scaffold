package com.smart.auth.center.authorization;


import com.smart.auth.center.config.AuthConfig;
import com.smart.auth.center.utils.UrlBuilder;

/**
 * QQ授权
 * @author guwenchang
 * @date 2019-06-14
 */
public class QqAuthorization implements Authorization {

    @Override
    public String getAuthorizeUrl(AuthConfig config) {
        return UrlBuilder.getQqAuthorizeUrl(config.getClientId(), config.getRedirectUri());
    }
}

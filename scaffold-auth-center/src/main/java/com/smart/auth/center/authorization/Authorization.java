package com.smart.auth.center.authorization;


import com.smart.auth.center.config.AuthConfig;

/**
 * 授权接口
 * @author guwenchang
 * @date 2019-06-14
 */
public interface Authorization {

    /**
     * 获取授权页面地址
     *
     * @param config 授权基础配置
     * @return 授权页面地址
     */
    String getAuthorizeUrl(AuthConfig config);
}

package com.smart.auth.center.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * 第三方授权中心配置
 *
 * @author guwenchang
 * @date 2019-05-16
 */
@Data
@ConfigurationProperties("auth.third")
public class ThirdAuthProperties {
    /**
     * 配置授权信息
     */
    private Map<String, AuthConfig> authConfigs = new HashMap<>();


}

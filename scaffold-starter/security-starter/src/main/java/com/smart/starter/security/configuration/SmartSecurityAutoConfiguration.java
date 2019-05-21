package com.smart.starter.security.configuration;


import com.smart.starter.security.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 启动配置
 * @author guwenchang
 * @date 2019-04-22 15:47
 */
@Configuration
@Import(SmartSecurityConfiguration.class)
public class SmartSecurityAutoConfiguration implements WebMvcConfigurer {

    @Autowired
    private SmartSecurityProperties smartSecurityProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).
                excludePathPatterns(smartSecurityProperties.getIgnoreUrls());
    }
}
package com.smart.doc.center.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * @author guwenchang
 * @date 2019-05-22
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //放行哪些原始域
        corsConfiguration.addAllowedOrigin("*");
        //是否发送Cookie信息
        corsConfiguration.setAllowCredentials(true);
        //放行哪些原始域(请求方式)
        corsConfiguration.addAllowedMethod("*");
        //放行哪些原始域(头部信息)
        corsConfiguration.addAllowedHeader("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}


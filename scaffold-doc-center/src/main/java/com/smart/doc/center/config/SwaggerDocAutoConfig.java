package com.smart.doc.center.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 文档中心自动配置
 *
 * @author guwenchang
 * @date 2019-05-16
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerDocProperties.class)
public class SwaggerDocAutoConfig {

    @Bean
    @Primary
    public SwaggerResourcesProcessor swaggerResourcesProcessor() {
        return new SwaggerResourcesProcessor();
    }

}

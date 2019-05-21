package com.smart.starter.swagger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 *
 * @author guwenchang
 * @date 2019-04-30
 */
@Configuration
@Import({
        Swagger2DocumentationConfiguration.class,
        BeanValidatorPluginsConfiguration.class
})
public class Swagger2Configuration {
}

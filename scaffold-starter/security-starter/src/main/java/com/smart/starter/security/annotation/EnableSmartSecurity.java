package com.smart.starter.security.annotation;

import com.smart.starter.security.configuration.SmartSecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启安全校验
 * @author guwenchang
 * @date 2019-04-22 15:59
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SmartSecurityAutoConfiguration.class})
public @interface EnableSmartSecurity {
}

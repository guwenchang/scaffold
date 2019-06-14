package com.smart.auth.center;

import com.smart.starter.log.annotation.EnableOpLog;
import com.smart.starter.security.annotation.EnableSmartSecurity;
import com.smart.starter.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证授权中心
 * @author guwenchang
 * @date 2019-06-14
 */
@EnableSmartSecurity
@EnableOpLog
@EnableSwagger2Doc
@SpringBootApplication
public class AuthCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthCenterApplication.class, args);
	}

}

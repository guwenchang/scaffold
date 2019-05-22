package com.smart.log.center;

import com.smart.starter.log.annotation.EnableOpLog;
import com.smart.starter.security.annotation.EnableSmartSecurity;
import com.smart.starter.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 日志中心
 * @author guwenchang
 * @date 2019-05-22
 */
@EnableSmartSecurity
@EnableOpLog
@EnableSwagger2Doc
@SpringBootApplication
public class ScaffoldLogCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaffoldLogCenterApplication.class, args);
    }

}

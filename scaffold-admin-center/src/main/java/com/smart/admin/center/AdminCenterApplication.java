package com.smart.admin.center;

import com.smart.starter.log.annotation.EnableOpLog;
import com.smart.starter.security.annotation.EnableSmartSecurity;
import com.smart.starter.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 管理中心
 * @author guwenchang
 * @date 2019-05-23
 */

@EnableSmartSecurity
@EnableOpLog
@EnableSwagger2Doc
@SpringBootApplication
public class AdminCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminCenterApplication.class, args);
    }

}

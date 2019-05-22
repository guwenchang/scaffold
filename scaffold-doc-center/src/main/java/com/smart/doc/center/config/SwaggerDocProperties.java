package com.smart.doc.center.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * 文档中心静态配置
 *
 * @author guwenchang
 * @date 2019-05-16
 */
@Data
@ConfigurationProperties("swagger.doc")
public class SwaggerDocProperties {

    /**
     * 配置静态文档地址
     */
    private Map<String, SwaggerResourceProperties> resources = new HashMap<>();

    /**
     * Swagger返回JSON文档的接口路径（全局配置）
     */
    private String apiDocsPath = "/v2/api-docs";

    /**
     * Swagger文档版本（全局配置）
     */
    private String swaggerVersion = "2.0";



}

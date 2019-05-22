package com.smart.doc.center.config;

import lombok.Data;

/**
 * 文档配置
 * @author guwenchang
 * @date 2019-05-16
 */
@Data
public class SwaggerResourceProperties {

    /**
     * 文档名称
     */
    private String name;

    /**
     * 配置api文档的获取路径，不配置的话采用全局默认配置：/v2/api-docs
     */
    private String apiDocsPath;

    /**
     * 站点的服务器地址
     */
    private String serverUrl = "localhost";

}
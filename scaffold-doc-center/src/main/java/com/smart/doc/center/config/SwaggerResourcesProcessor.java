package com.smart.doc.center.config;

import org.springframework.beans.factory.annotation.Autowired;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文档配置的处理
 * @author guwenchang
 * @date 2019-05-16
 */
public class SwaggerResourcesProcessor implements SwaggerResourcesProvider {

    @Autowired
    private SwaggerDocProperties swaggerDocProperties;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();

        for (Map.Entry<String, SwaggerResourceProperties> swaggerResourcePropertiesEntry : swaggerDocProperties.getResources().entrySet()) {
            // 处理swagger文档的名称
            String docName = swaggerResourcePropertiesEntry.getKey();
            SwaggerResourceProperties resourceProperties = swaggerResourcePropertiesEntry.getValue();
            // 处理获取swagger文档的路径
            String swaggerPath = swaggerDocProperties.getApiDocsPath();
            if (resourceProperties != null && resourceProperties.getApiDocsPath() != null) {
                swaggerPath = resourceProperties.getApiDocsPath();
            }
            String location = resourceProperties.getServerUrl()+swaggerPath;

            // 处理swagger的版本设置
            String swaggerVersion = swaggerDocProperties.getSwaggerVersion();
            resources.add(swaggerResource(docName, location, swaggerVersion));

        }
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
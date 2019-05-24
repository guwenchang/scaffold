package com.smart.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 代码生成器
 *
 * @author guxiaobai
 * @date 2018/11/27 21:00
 */
public class CodeGenerator {


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("/Users/guwenchang/code/codetmp/scaffold/");

		gc.setAuthor("guxiaobai");
        gc.setOpen(true);
        gc.setFileOverride(true);
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/scaffold?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("center");
        pc.setParent("com.smart.admin");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                HashMap<String, Object> data = Maps.newHashMap();
                data.put("ParamPackage", pc.getParent() + StringPool.DOT + "param");
                data.put("ResultPackage", pc.getParent() + StringPool.DOT + "result");
                this.setMap(data);
            }
        };
        final String parentPath = pc.getParent().replace(".", "/");
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/param.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return gc.getOutputDir() + "/" + parentPath + "/param/" + tableInfo.getEntityName() + "Param.java";

            }
        });
        focList.add(new FileOutConfig("/templates/queryparam.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return gc.getOutputDir() + "/" + parentPath + "/param/" + tableInfo.getEntityName() + "QueryParam.java";

            }
        });
        focList.add(new FileOutConfig("/templates/result.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return gc.getOutputDir() + "/" + parentPath + "/result/" + tableInfo.getEntityName() + "Result.java";
            }
        });
        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return gc.getOutputDir() + "/" + parentPath + "/entity/" + tableInfo.getEntityName() + "Entity.java";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(null);
        mpg.setTemplate(templateConfig);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setLogicDeleteFieldName("del_flag");
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}

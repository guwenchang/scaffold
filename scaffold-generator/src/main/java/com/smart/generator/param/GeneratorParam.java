package com.smart.generator.param;

import lombok.Data;

/**
 *
 * @author guwenchang
 * @date 2019-05-22
 */
@Data
public class GeneratorParam {
   /**
    * 包名
    */
   private String packageName;
   /**
    * 作者
    */
   private String author;
   /**
    * 模块名称
    */
   private String moduleName;
   /**
    * 表前缀
    */
   private String tablePrefix;

    /**
     * 表名称
     */
    private String[] includeTables;

    /**
     * 数据库连接配置
     */
    private DataSourceParam dataSourceParam;

    /**
     * 输出路径
     */
    private String outPath;
}

package com.smart.generator.config;

import lombok.Data;

import java.util.List;
/**
 *
 * @author guwenchang
 * @date 2019-05-22
 */
@Data
public class TableEntity {
   /**
    * 名称
    */
   private String tableName;
   /**
    * 备注
    */
   private String comments;
   /**
    * 主键
    */
   private ColumnEntity pk;
   /**
    * 列名
    */
   private List<ColumnEntity> columns;

    /**
     * 驼峰类型
     */
    private String caseClassName;
    /**
     * 普通类型
     */
    private String lowerClassName;

   /**
    * 驼峰类型(Entity)
    */
   private String caseEntityName;
   /**
    * 普通类型(Entity)
    */
   private String lowerEntityName;
    /**
     * 驼峰类型(Param)
     */
    private String caseParamName;
    /**
     * 普通类型(Param)
     */
    private String lowerParamName;
    /**
     * 驼峰类型(QueryParam)
     */
    private String caseQueryParamName;
    /**
     * 普通类型(QueryParam)
     */
    private String lowerQueryParamName;
    /**
     * 驼峰类型(Result)
     */
    private String caseResultName;
    /**
     * 普通类型(Result)
     */
    private String lowerResultName;


}

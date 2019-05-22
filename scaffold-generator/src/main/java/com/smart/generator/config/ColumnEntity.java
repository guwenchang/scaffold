package com.smart.generator.config;

import lombok.Data;

/**
 *
 * @author guwenchang
 * @date 2019-05-22
 */
@Data
public class ColumnEntity {
   /**
    * 列表
    */
   private String columnName;
   /**
    * 数据类型
    */
   private String dataType;
   /**
    * 备注
    */
   private String comments;

   /**
    * 驼峰属性
    */
   private String caseAttrName;
   /**
    * 驼峰属性首字母小写
    */
   private String lowerAttrName;
   /**
    * 属性类型
    */
   private String attrType;
    /**
     * 主键标志
     */
    private boolean idFlag;


    /**
     * 主键类型 1 auto 2,input
     */
    private int idType;
}

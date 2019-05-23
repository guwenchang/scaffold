package com.smart.admin.center.result;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;

/**
 * 部门结果集
 *
 * @author guwenchang
 * @date 2019-05-23 15:14:18
 */
@Data
public class SysDeptResult implements Serializable{
  private static final long serialVersionUID=1L;

    /**
     * 部门id
     */
    @ApiModelProperty("部门id")
    private Long id;
    /**
     * 部门编码
     */
    @ApiModelProperty("部门编码")
    private String code;
    /**
     * 父部门编码
     */
    @ApiModelProperty("父部门编码")
    private String parentCode;
    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String name;
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;
    /**
     * 是否删除 0 正常，1 删除
     */
    @ApiModelProperty("是否删除 0 正常，1 删除")
    private Boolean delFlag;

}

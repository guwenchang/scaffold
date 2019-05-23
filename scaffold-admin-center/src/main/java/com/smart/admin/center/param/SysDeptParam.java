package com.smart.admin.center.param;


import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

/**
 * 部门参数
 *
 * @author guwenchang
 * @date 2019-05-23 15:14:18
 */
@Data
public class SysDeptParam implements Serializable{
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
}

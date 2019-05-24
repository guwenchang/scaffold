package com.smart.admin.center.param;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.io.Serializable;
/**
 * 部门参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@ApiModel(value="部门参数", description="部门")
public class SysDeptParam implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Long id;
    /**
     * 部门编码
     */
    @ApiModelProperty(value = "部门编码")
    private String code;
    /**
     * 父部门编码
     */
    @ApiModelProperty(value = "父部门编码")
    private String parentCode;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String name;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer orderNum;

}

package com.smart.admin.center.param;

import com.smart.starter.core.model.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * 部门 查询参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
public class SysDeptQueryParam extends PageParam {


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


}

package com.smart.admin.center.param;

import java.time.LocalDateTime;
import com.smart.starter.core.model.PageParam;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 部门 查询参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@ApiModel(value="部门查询参数", description="部门")
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

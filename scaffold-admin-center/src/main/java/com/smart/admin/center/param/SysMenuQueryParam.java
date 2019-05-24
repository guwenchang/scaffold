package com.smart.admin.center.param;

import com.smart.starter.core.model.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * 菜单权限 查询参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
public class SysMenuQueryParam extends PageParam {

    /**
     * 菜单编码
     */
    @ApiModelProperty(value = "菜单编码")
    private String code;
    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    private String name;
    /**
     * 父菜单ID
     */
    @ApiModelProperty(value = "父菜单ID")
    private String parentCode;
}

package com.smart.admin.center.result;

import com.smart.starter.core.model.TreeNode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限树
 * @author guwenchang
 * @date 2019-05-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenuTreeResult extends TreeNode {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    private String name;
    /**
     * 菜单权限标识
     */
    @ApiModelProperty(value = "菜单权限标识")
    private String permission;
    /**
     * 前端URL
     */
    @ApiModelProperty(value = "前端URL")
    private String path;
    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;
    /**
     * 页面名称
     */
    @ApiModelProperty(value = "页面名称")
    private String component;
    /**
     * 排序值
     */
    @ApiModelProperty(value = "排序值")
    private Integer sort;
    /**
     * 菜单类型 1 菜单，2 功能
     */
    @ApiModelProperty(value = "菜单类型 1 菜单，2 功能")
    private Integer type;


}

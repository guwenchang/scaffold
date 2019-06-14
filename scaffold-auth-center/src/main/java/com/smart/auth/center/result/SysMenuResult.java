package com.smart.auth.center.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * 菜单权限 结果集
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
public class SysMenuResult implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单ID
     */
    @ApiModelProperty(value = "菜单ID")
    private Long id;
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
     * 父菜单ID
     */
    @ApiModelProperty(value = "父菜单ID")
    private String parentCode;
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
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}

package com.smart.admin.center.param;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单权限参数
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysMenuParam implements Serializable{
    private static final long serialVersionUID=1L;

    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    private Long id;
    /**
     * 
     */
    @ApiModelProperty("")
    private String code;
    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;
    /**
     * 菜单权限标识
     */
    @ApiModelProperty("菜单权限标识")
    private String permission;
    /**
     * 前端URL
     */
    @ApiModelProperty("前端URL")
    private String path;
    /**
     * 父菜单ID
     */
    @ApiModelProperty("父菜单ID")
    private String parentCode;
    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;
    /**
     * 页面名称
     */
    @ApiModelProperty("页面名称")
    private String component;
    /**
     * 排序值
     */
    @ApiModelProperty("排序值")
    private Integer sort;
    /**
     * 菜单类型 1 菜单，2 功能
     */
    @ApiModelProperty("菜单类型 1 菜单，2 功能")
    private Integer type;

}

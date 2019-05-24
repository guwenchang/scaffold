package com.smart.admin.center.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 菜单权限 实体
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@TableName("t_sys_menu")
public class SysMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    private Long id;

    private String code;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 前端URL
     */
    private String path;

    /**
     * 父菜单ID
     */
    private String parentCode;

    /**
     * 图标
     */
    private String icon;

    /**
     * 页面名称
     */
    private String component;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 菜单类型 1 菜单，2 功能
     */
    private Integer type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除 0 正常，1 删除
     */
    @TableLogic
    private Boolean delFlag;


}

package com.smart.admin.center.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色菜单表 实体
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@TableName("t_sys_role_menu")
public class SysRoleMenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;


}

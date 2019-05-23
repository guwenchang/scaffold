package com.smart.admin.center.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色菜单表
 *
 * @author guwenchang
 * @date 2019-05-23 16:46:55
 */
@Data
@TableName("t_sys_role_menu")
public class SysRoleMenuEntity implements Serializable{
    private static final long serialVersionUID=1L;

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;

}

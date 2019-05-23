package com.smart.admin.center.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户角色表
 *
 * @author guwenchang
 * @date 2019-05-23 16:46:55
 */
@Data
@TableName("t_sys_user_role")
public class SysUserRoleEntity implements Serializable{
    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 角色ID
     */
    private Integer roleId;

}

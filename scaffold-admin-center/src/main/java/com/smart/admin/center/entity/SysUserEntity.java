package com.smart.admin.center.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 系统用户
 *
 * @author guwenchang
 * @date 2019-05-23 16:46:55
 */
@Data
@TableName("t_sys_user")
public class SysUserEntity implements Serializable{
    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 是否删除 0 正常，1 删除
     */
    private Boolean delFlag;

}

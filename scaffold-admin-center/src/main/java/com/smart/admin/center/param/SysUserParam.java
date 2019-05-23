package com.smart.admin.center.param;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统用户参数
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysUserParam implements Serializable{
    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String realName;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;
    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private Long deptId;

}

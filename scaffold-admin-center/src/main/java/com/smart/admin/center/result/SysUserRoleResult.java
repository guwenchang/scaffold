package com.smart.admin.center.result;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户角色表结果集
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysUserRoleResult implements Serializable{
  private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Long userId;
    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Long roleId;

}

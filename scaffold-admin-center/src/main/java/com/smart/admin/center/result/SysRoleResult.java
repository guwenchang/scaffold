package com.smart.admin.center.result;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色结果集
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysRoleResult implements Serializable{
  private static final long serialVersionUID=1L;

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Long id;
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String roleName;
    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String roleCode;
    /**
     * 角色描述
     */
    @ApiModelProperty("角色描述")
    private String roleDesc;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

}

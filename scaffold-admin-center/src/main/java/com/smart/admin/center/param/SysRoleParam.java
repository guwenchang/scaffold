package com.smart.admin.center.param;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色参数
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysRoleParam implements Serializable{
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
}

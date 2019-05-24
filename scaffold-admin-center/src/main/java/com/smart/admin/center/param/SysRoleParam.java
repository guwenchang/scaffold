package com.smart.admin.center.param;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.io.Serializable;
/**
 * 角色参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@ApiModel(value="角色参数", description="角色")
public class SysRoleParam implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long id;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;
    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

}

package com.smart.admin.center.result;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
/**
 *
 * 角色 结果集
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
public class SysRoleResult implements Serializable {

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
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}

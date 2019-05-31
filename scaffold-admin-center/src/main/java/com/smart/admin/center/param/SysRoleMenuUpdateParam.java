package com.smart.admin.center.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author guwenchang
 * @date 2019-05-31
 */
@Data
public class SysRoleMenuUpdateParam implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long id;
    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;
    /**
     * 权限id集合
     */
    @ApiModelProperty(value = "权限id集合")
    private List<Long> menuIds;


}

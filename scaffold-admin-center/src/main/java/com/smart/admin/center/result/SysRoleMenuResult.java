package com.smart.admin.center.result;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色菜单表结果集
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysRoleMenuResult implements Serializable{
  private static final long serialVersionUID=1L;

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Long roleId;
    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    private Long menuId;

}

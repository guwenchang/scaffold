package com.smart.admin.center.param;

import com.smart.starter.core.model.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * 角色 查询参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
public class SysRoleQueryParam extends PageParam {

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

}

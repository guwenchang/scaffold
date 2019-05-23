package com.smart.admin.center.param;


import lombok.Data;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import com.smart.starter.core.model.PageParam;
/**
 * 角色查询参数
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysRoleQueryParam extends PageParam{

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

}

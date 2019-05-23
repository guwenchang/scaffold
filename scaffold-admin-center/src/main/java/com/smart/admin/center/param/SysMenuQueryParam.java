package com.smart.admin.center.param;


import lombok.Data;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import com.smart.starter.core.model.PageParam;
/**
 * 菜单权限查询参数
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysMenuQueryParam extends PageParam{

    /**
     * 
     */
    @ApiModelProperty("菜单编码")
    private String code;
    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;
    /**
     * 菜单权限标识
     */
    @ApiModelProperty("菜单权限标识")
    private String permission;
    /**
     * 前端URL
     */
    @ApiModelProperty("前端URL")
    private String path;
    /**
     * 菜单类型 1 菜单，2 功能
     */
    @ApiModelProperty("菜单类型 1 菜单，2 功能")
    private Integer type;
}

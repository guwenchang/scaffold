package com.smart.admin.center.param;


import lombok.Data;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import com.smart.starter.core.model.PageParam;
/**
 * 系统用户查询参数
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysUserQueryParam extends PageParam{

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String realName;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;
    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private Long deptId;
}

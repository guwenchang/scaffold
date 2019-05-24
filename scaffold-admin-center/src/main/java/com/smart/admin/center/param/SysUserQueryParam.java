package com.smart.admin.center.param;

import java.time.LocalDateTime;
import com.smart.starter.core.model.PageParam;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 系统用户 查询参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@ApiModel(value="系统用户查询参数", description="系统用户")
public class SysUserQueryParam extends PageParam {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    private Long deptId;

}

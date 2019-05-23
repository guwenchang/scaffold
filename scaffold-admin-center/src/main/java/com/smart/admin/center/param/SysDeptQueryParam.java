package com.smart.admin.center.param;


import lombok.Data;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import com.smart.starter.core.model.PageParam;
/**
 * 部门查询参数
 *
 * @author guwenchang
 * @date 2019-05-23 15:14:18
 */
@Data
public class SysDeptQueryParam extends PageParam{

    /**
     * 部门编码
     */
    @ApiModelProperty("部门编码")
    private String code;
    /**
     * 父部门编码
     */
    @ApiModelProperty("父部门编码")
    private String parentCode;
    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String name;

}

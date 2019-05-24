package com.smart.admin.center.param;

import com.smart.starter.core.model.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * 字典 查询参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
public class SysDictQueryParam extends PageParam {

    /**
     * 标签名
     */
    @ApiModelProperty(value = "标签名")
    private String label;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;
    /**
     * 字典状态 1 启用，2 禁用
     */
    @ApiModelProperty(value = "字典状态 1 启用，2 禁用")
    private Integer status;


}

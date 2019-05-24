package com.smart.admin.center.param;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.io.Serializable;
/**
 * 字典参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@ApiModel(value="字典参数", description="字典")
public class SysDictParam implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Long id;
    /**
     * 数据值
     */
    @ApiModelProperty(value = "数据值")
    private String value;
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
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;
    /**
     * 排序（升序）
     */
    @ApiModelProperty(value = "排序（升序）")
    private Integer sort;

}

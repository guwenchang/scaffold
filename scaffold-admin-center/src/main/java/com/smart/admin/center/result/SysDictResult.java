package com.smart.admin.center.result;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
/**
 *
 * 字典 结果集
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@ApiModel(value="字典结果集", description="字典")
public class SysDictResult implements Serializable {

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
    /**
     * 字典状态 1 启用，2 禁用
     */
    @ApiModelProperty(value = "字典状态 1 启用，2 禁用")
    private Integer status;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

}

package com.smart.admin.center.result;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典结果集
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysDictResult implements Serializable{
  private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private Long id;
    /**
     * 数据值
     */
    @ApiModelProperty("数据值")
    private String value;
    /**
     * 标签名
     */
    @ApiModelProperty("标签名")
    private String label;
    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;
    /**
     * 排序（升序）
     */
    @ApiModelProperty("排序（升序）")
    private Integer sort;
    /**
     * 字典状态 1 启用，2 禁用
     */
    @ApiModelProperty("字典状态 1 启用，2 禁用")
    private Integer status;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

}

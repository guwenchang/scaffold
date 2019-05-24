package com.smart.log.center.result;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
/**
 *
 * 日志 结果集
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@ApiModel(value="日志结果集", description="日志")
public class OpLogResult implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private Long id;
    /**
     * 日志类型
     */
    @ApiModelProperty(value = "日志类型")
    private String logType;
    /**
     * 日志标题
     */
    @ApiModelProperty(value = "日志标题")
    private String title;
    /**
     * 服务名
     */
    @ApiModelProperty(value = "服务名")
    private String app;
    /**
     * 操作IP地址
     */
    @ApiModelProperty(value = "操作IP地址")
    private String remoteAddr;
    /**
     * 用户代理
     */
    @ApiModelProperty(value = "用户代理")
    private String userAgent;
    /**
     * 请求URI
     */
    @ApiModelProperty(value = "请求URI")
    private String requestUri;
    /**
     * 操作方式
     */
    @ApiModelProperty(value = "操作方式")
    private String method;
    /**
     * 操作提交的数据
     */
    @ApiModelProperty(value = "操作提交的数据")
    private String params;
    /**
     * 执行时间
     */
    @ApiModelProperty(value = "执行时间")
    private Integer time;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createBy;
    /**
     * 异常信息
     */
    @ApiModelProperty(value = "异常信息")
    private String exception;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}

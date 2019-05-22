package com.smart.log.center.param;


import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;

/**
 * 日志参数
 *
 * @author guwenchang
 * @date 2019-05-22 18:05:51
 */
@Data
public class OpLogParam implements Serializable{
  private static final long serialVersionUID=1L;

  /**
   * 编号
   */
  @ApiModelProperty("编号")
  private Long id;
  /**
   * 日志类型
   */
  @ApiModelProperty("日志类型")
  private Integer logType;
  /**
   * 日志标题
   */
  @ApiModelProperty("日志标题")
  private String title;
  /**
   * 服务名
   */
  @ApiModelProperty("服务名")
  private String app;
  /**
   * 操作IP地址
   */
  @ApiModelProperty("操作IP地址")
  private String remoteAddr;
  /**
   * 用户代理
   */
  @ApiModelProperty("用户代理")
  private String userAgent;
  /**
   * 请求URI
   */
  @ApiModelProperty("请求URI")
  private String requestUri;
  /**
   * 操作方式
   */
  @ApiModelProperty("操作方式")
  private String method;
  /**
   * 操作提交的数据
   */
  @ApiModelProperty("操作提交的数据")
  private String params;
  /**
   * 执行时间
   */
  @ApiModelProperty("执行时间")
  private Integer time;
  /**
   * 创建者
   */
  @ApiModelProperty("创建者")
  private String createBy;
  /**
   * 异常信息
   */
  @ApiModelProperty("异常信息")
  private String exception;
  /**
   * 创建时间
   */
  @ApiModelProperty("创建时间")
  private LocalDateTime createTime;

}

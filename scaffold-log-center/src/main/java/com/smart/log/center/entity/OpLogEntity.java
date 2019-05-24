package com.smart.log.center.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 日志 实体
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@TableName("t_op_log")
public class OpLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 服务名
     */
    private String app;

    /**
     * 操作IP地址
     */
    private String remoteAddr;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 操作方式
     */
    private String method;

    /**
     * 操作提交的数据
     */
    private String params;

    /**
     * 执行时间
     */
    private Integer time;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 异常信息
     */
    private String exception;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}

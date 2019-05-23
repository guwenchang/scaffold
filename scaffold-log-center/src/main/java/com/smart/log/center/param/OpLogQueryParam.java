package com.smart.log.center.param;


import lombok.Data;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import com.smart.starter.core.model.PageParam;
/**
 * 日志查询参数
 *
 * @author guwenchang
 * @date 2019-05-22 19:17:59
 */
@Data
public class OpLogQueryParam extends PageParam{

    /**
     * 日志类型
     */
    @ApiModelProperty("日志类型")
    private String logType;
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

}

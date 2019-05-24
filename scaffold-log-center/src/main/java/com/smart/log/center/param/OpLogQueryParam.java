package com.smart.log.center.param;

import com.smart.starter.core.model.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * 日志 查询参数
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Data
@ApiModel(value="日志查询参数", description="日志")
public class OpLogQueryParam extends PageParam {

    /**
     * 日志类型
     */
    @ApiModelProperty(value = "日志类型")
    private String logType;
    /**
     * 服务名
     */
    @ApiModelProperty(value = "服务名")
    private String app;
    /**
     * 请求URI
     */
    @ApiModelProperty(value = "请求URI")
    private String requestUri;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createBy;

}

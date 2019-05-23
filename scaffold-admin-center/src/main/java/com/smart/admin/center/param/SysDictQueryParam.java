package com.smart.admin.center.param;


import lombok.Data;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModelProperty;
import com.smart.starter.core.model.PageParam;
/**
 * 字典查询参数
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
@Data
public class SysDictQueryParam extends PageParam{
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

}

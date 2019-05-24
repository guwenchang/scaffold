package ${cfg.ParamPackage};

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import java.io.Serializable;
/**
 * ${table.comment!}参数
 *
 * @author ${author}
 * @date ${date}
 */
@Data
@ApiModel(value="${table.comment!}参数", description="${table.comment!}")
public class ${entity}Param implements Serializable {

    private static final long serialVersionUID = 1L;
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.comment!?length gt 0>
    /**
     * ${field.comment}
     */
    @ApiModelProperty(value = "${field.comment}")
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->

}

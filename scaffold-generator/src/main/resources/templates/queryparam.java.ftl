package ${cfg.ParamPackage};

import java.time.LocalDateTime;
import com.smart.starter.core.model.PageParam;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * ${table.comment!} 查询参数
 *
 * @author ${author}
 * @date ${date}
 */
@Data
public class ${entity}QueryParam extends PageParam {

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

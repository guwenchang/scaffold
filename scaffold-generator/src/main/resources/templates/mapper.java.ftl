package ${package.Mapper};

import ${package.Entity}.${entity}Entity;
import ${superMapperClassPackage};

/**
 *
 * ${table.comment!} Mapper 接口
 *
 * @author ${author}
 * @date ${date}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}Entity>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}Entity> {

}
</#if>

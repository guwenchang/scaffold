package ${package.Service};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity?replace("entity","param")}.${entity}Param;
import ${package.Entity?replace("entity","param")}.${entity}QueryParam;
import ${package.Entity?replace("entity","result")}.${entity}Result;
import java.util.List;

/**
 *
 * ${table.comment!} 服务接口
 *
 * @author ${author}
 * @date ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} {

    /**
     * 保存
     *
     * @param param
     * @return
     */
    Boolean save(${entity}Param param);

    /**
     * 更新
     *
     * @param param
     * @return
     */
    Boolean update(${entity}Param param);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Boolean delete(Long id);

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    ${entity}Result get(Long id);

    /**
     * 列表查询
     *
     * @param param
     * @return
     */
    List<${entity}Result> list(${entity}QueryParam param);


    /**
     * 分页查询
     *
     * @param page
     * @param param
     * @return
     */
    Page<${entity}Result> page(Page< ${entity}Result> page, ${entity}QueryParam param);

}
</#if>

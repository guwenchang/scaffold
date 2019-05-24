package com.smart.admin.center.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysMenuParam;
import com.smart.admin.center.param.SysMenuQueryParam;
import com.smart.admin.center.result.SysMenuResult;
import java.util.List;

/**
 *
 * 菜单权限 服务接口
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
public interface ISysMenuService {

    /**
     * 保存
     *
     * @param param
     * @return
     */
    Boolean save(SysMenuParam param);

    /**
     * 更新
     *
     * @param param
     * @return
     */
    Boolean update(SysMenuParam param);

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
    SysMenuResult get(Long id);

    /**
     * 列表查询
     *
     * @param param
     * @return
     */
    List<SysMenuResult> list(SysMenuQueryParam param);


    /**
     * 分页查询
     *
     * @param page
     * @param param
     * @return
     */
    Page<SysMenuResult> page(Page<SysMenuResult> page, SysMenuQueryParam param);

}

package com.smart.admin.center.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.admin.center.entity.SysMenuEntity;
import com.smart.admin.center.param.SysMenuParam;
import com.smart.admin.center.param.SysMenuQueryParam;
import com.smart.admin.center.result.SysMenuResult;

import java.util.List;

/**
 * 菜单权限
 *
 * @author guwenchang
 * @date 2019-05-23 17:16:28
 */
public interface SysMenuService extends IService<SysMenuEntity> {


    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysMenuResult get(Long id);

    /**
     * 简单分页查询
     * @param page
     * @param param
     * @return
     */
    Page<SysMenuResult> page(Page<SysMenuResult> page, SysMenuQueryParam param);

    /**
     * 更新
     * @param param
     * @return
     */
    Boolean updateById(SysMenuParam param);

    /**
     * 新建
     * @param param
     * @return
     */
    Boolean save(SysMenuParam param);

}

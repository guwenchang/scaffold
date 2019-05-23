package com.smart.admin.center.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.admin.center.entity.SysRoleEntity;
import com.smart.admin.center.param.SysRoleParam;
import com.smart.admin.center.param.SysRoleQueryParam;
import com.smart.admin.center.result.SysRoleResult;

/**
 * 角色
 *
 * @author guwenchang
 * @date 2019-05-23 17:16:28
 */
public interface SysRoleService extends IService<SysRoleEntity> {


    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysRoleResult get(Long id);

    /**
     * 简单分页查询
     * @param page
     * @param param
     * @return
     */
    Page<SysRoleResult> page(Page<SysRoleResult> page, SysRoleQueryParam param);

    /**
     * 更新
     * @param param
     * @return
     */
    Boolean updateById(SysRoleParam param);

    /**
     * 新建
     * @param param
     * @return
     */
    Boolean save(SysRoleParam param);

}

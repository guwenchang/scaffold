package com.smart.admin.center.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.admin.center.entity.SysUserEntity;
import com.smart.admin.center.param.SysUserParam;
import com.smart.admin.center.param.SysUserQueryParam;
import com.smart.admin.center.result.SysUserResult;

/**
 * 系统用户
 *
 * @author guwenchang
 * @date 2019-05-23 17:16:28
 */
public interface SysUserService extends IService<SysUserEntity> {


    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysUserResult get(Long id);

    /**
     * 简单分页查询
     * @param page
     * @param param
     * @return
     */
    Page<SysUserResult> page(Page<SysUserResult> page, SysUserQueryParam param);

    /**
     * 更新
     * @param param
     * @return
     */
    Boolean updateById(SysUserParam param);

    /**
     * 新建
     * @param param
     * @return
     */
    Boolean save(SysUserParam param);

}

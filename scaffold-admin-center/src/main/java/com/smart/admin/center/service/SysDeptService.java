package com.smart.admin.center.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.admin.center.entity.SysDeptEntity;
import com.smart.admin.center.param.SysDeptParam;
import com.smart.admin.center.param.SysDeptQueryParam;
import com.smart.admin.center.result.SysDeptResult;
import com.smart.admin.center.result.SysDeptTreeResult;

import java.util.List;

/**
 * 部门
 *
 * @author guwenchang
 * @date 2019-05-23 15:14:18
 */
public interface SysDeptService extends IService<SysDeptEntity> {


    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysDeptResult get(Long id);

    /**
     * 简单分页查询
     * @param page
     * @param param
     * @return
     */
    Page<SysDeptResult> page(Page<SysDeptResult> page, SysDeptQueryParam param);

    /**
     * 更新
     * @param param
     * @return
     */
    Boolean updateById(SysDeptParam param);

    /**
     * 新建
     * @param param
     * @return
     */
    Boolean save(SysDeptParam param);


    /**
     * 获取部门树
     *
     * @return
     */
    List<SysDeptTreeResult> selectListTree();

}

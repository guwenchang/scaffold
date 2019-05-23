package com.smart.admin.center.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.admin.center.entity.SysDictEntity;
import com.smart.admin.center.param.SysDictParam;
import com.smart.admin.center.param.SysDictQueryParam;
import com.smart.admin.center.result.SysDictResult;

/**
 * 字典
 *
 * @author guwenchang
 * @date 2019-05-23 17:16:28
 */
public interface SysDictService extends IService<SysDictEntity> {


    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysDictResult get(Long id);

    /**
     * 简单分页查询
     * @param page
     * @param param
     * @return
     */
    Page<SysDictResult> page(Page<SysDictResult> page, SysDictQueryParam param);

    /**
     * 更新
     * @param param
     * @return
     */
    Boolean updateById(SysDictParam param);

    /**
     * 新建
     * @param param
     * @return
     */
    Boolean save(SysDictParam param);

}

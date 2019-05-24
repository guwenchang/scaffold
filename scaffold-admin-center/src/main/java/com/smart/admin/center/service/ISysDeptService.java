package com.smart.admin.center.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysDeptParam;
import com.smart.admin.center.param.SysDeptQueryParam;
import com.smart.admin.center.result.SysDeptResult;
import com.smart.admin.center.result.SysDeptTreeResult;

import java.util.List;

/**
 *
 * 部门 服务接口
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
public interface ISysDeptService {

    /**
     * 保存
     *
     * @param param
     * @return
     */
    Boolean save(SysDeptParam param);

    /**
     * 更新
     *
     * @param param
     * @return
     */
    Boolean update(SysDeptParam param);

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
    SysDeptResult get(Long id);

    /**
     * 列表查询
     *
     * @param param
     * @return
     */
    List<SysDeptResult> list(SysDeptQueryParam param);


    /**
     * 分页查询
     *
     * @param page
     * @param param
     * @return
     */
    Page<SysDeptResult> page(Page<SysDeptResult> page, SysDeptQueryParam param);

    /**
     * 获取部门树
     *
     * @return
     */
    List<SysDeptTreeResult> selectListTree();

}

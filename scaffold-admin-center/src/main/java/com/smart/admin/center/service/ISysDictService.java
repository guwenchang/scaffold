package com.smart.admin.center.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysDictParam;
import com.smart.admin.center.param.SysDictQueryParam;
import com.smart.admin.center.result.SysDictResult;
import java.util.List;

/**
 *
 * 字典 服务接口
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
public interface ISysDictService {

    /**
     * 保存
     *
     * @param param
     * @return
     */
    Boolean save(SysDictParam param);

    /**
     * 更新
     *
     * @param param
     * @return
     */
    Boolean update(SysDictParam param);

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
    SysDictResult get(Long id);

    /**
     * 列表查询
     *
     * @param param
     * @return
     */
    List<SysDictResult> list(SysDictQueryParam param);


    /**
     * 分页查询
     *
     * @param page
     * @param param
     * @return
     */
    Page<SysDictResult> page(Page<SysDictResult> page, SysDictQueryParam param);

}

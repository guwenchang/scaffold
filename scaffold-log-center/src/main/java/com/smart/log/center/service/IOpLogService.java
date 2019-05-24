package com.smart.log.center.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.log.center.param.OpLogQueryParam;
import com.smart.log.center.result.OpLogResult;
import com.smart.starter.log.OpLogParam;

import java.util.List;

/**
 *
 * 日志 服务接口
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
public interface IOpLogService {

    /**
     * 保存
     *
     * @param param
     * @return
     */
    Boolean save(OpLogParam param);

    /**
     * 更新
     *
     * @param param
     * @return
     */
    Boolean update(OpLogParam param);

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
    OpLogResult get(Long id);

    /**
     * 列表查询
     *
     * @param param
     * @return
     */
    List<OpLogResult> list(OpLogQueryParam param);


    /**
     * 分页查询
     *
     * @param page
     * @param param
     * @return
     */
    Page<OpLogResult> page(Page<OpLogResult> page, OpLogQueryParam param);

}

package com.smart.log.center.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.log.center.entity.OpLogEntity;
import com.smart.log.center.param.OpLogQueryParam;
import com.smart.log.center.result.OpLogResult;
import com.smart.starter.log.OpLogParam;

/**
 * 日志
 *
 * @author guwenchang
 * @date 2019-05-22 19:17:59
 */
public interface OpLogService extends IService<OpLogEntity> {


    /**
     * 根据id查询
     * @param id
     * @return
     */
    OpLogResult get(Long id);

    /**
     * 简单分页查询
     * @param page
     * @param param
     * @return
     */
    Page<OpLogResult> listPage(Page<OpLogResult> page, OpLogQueryParam param);

    /**
     * 新建
     * @param param
     * @return
     */
    Boolean save(OpLogParam param);

}

package com.smart.log.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.log.center.entity.OpLogEntity;
import com.smart.log.center.param.OpLogQueryParam;
import com.smart.log.center.result.OpLogResult;
import com.smart.log.center.mapper.OpLogMapper;
import com.smart.log.center.service.OpLogService;
import com.smart.starter.core.util.CopyUtils;
import com.smart.starter.log.OpLogParam;
import org.springframework.stereotype.Service;

/**
 * 日志
 *
 * @author guwenchang
 * @date 2019-05-22 19:17:59
 */
@Service
public class OpLogServiceImpl extends ServiceImpl<OpLogMapper, OpLogEntity> implements OpLogService {

    @Override
    public OpLogResult get(Long id) {
        OpLogEntity entity = getById(id);
        OpLogResult result = CopyUtils.copyObject(entity, OpLogResult.class);
        return result;
    }

    @Override
    public Page<OpLogResult> page(Page<OpLogResult> page, OpLogQueryParam param) {
        QueryWrapper<OpLogEntity> queryWrapper = new QueryWrapper();
        Page<OpLogEntity> entityPage = new Page<>();
        entityPage.setSize(page.getSize());
        entityPage.setCurrent(page.getCurrent());
        entityPage.setAsc(page.ascs());
        entityPage.setDesc(page.descs());
        page(entityPage, queryWrapper);
        return CopyUtils.copyPage(entityPage, OpLogResult.class);
    }


    @Override
    public Boolean save(OpLogParam param) {
        OpLogEntity entity = CopyUtils.copyObject(param, OpLogEntity.class);
        return save(entity);
    }

}

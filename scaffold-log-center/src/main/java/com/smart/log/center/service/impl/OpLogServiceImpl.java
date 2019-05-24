package com.smart.log.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.starter.core.util.CopyUtils;
import com.smart.log.center.entity.OpLogEntity;
import com.smart.log.center.mapper.OpLogMapper;
import com.smart.log.center.service.IOpLogService;
import com.smart.starter.log.OpLogParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.log.center.param.OpLogQueryParam;
import com.smart.log.center.result.OpLogResult;
import java.util.List;

/**
 *
 * 日志 服务实现类
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Service
@RequiredArgsConstructor
public class OpLogServiceImpl implements IOpLogService {

    private final OpLogMapper mapper;


    @Override
    public Boolean save(OpLogParam param) {
        OpLogEntity entity = CopyUtils.copyObject(param, OpLogEntity.class);
        int insert = mapper.insert(entity);
        return insert > 0;
    }

    @Override
    public Boolean update(OpLogParam param) {
        OpLogEntity entity = CopyUtils.copyObject(param, OpLogEntity.class);
        int update = mapper.updateById(entity);
        return update > 0;

    }

    @Override
    public Boolean delete(Long id) {
        int delete = mapper.deleteById(id);
        return delete > 0;
    }

    @Override
    public OpLogResult get(Long id) {
        OpLogEntity entity = mapper.selectById(id);
        return CopyUtils.copyObject(entity, OpLogResult.class);
    }

    @Override
    public List<OpLogResult> list(OpLogQueryParam param) {
        QueryWrapper<OpLogEntity> queryWrapper = new QueryWrapper<>();
        List<OpLogEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, OpLogResult.class);
    }

    @Override
    public Page<OpLogResult> page(Page<OpLogResult> page, OpLogQueryParam param) {
        QueryWrapper<OpLogEntity> queryWrapper = new QueryWrapper<>();
        Page<OpLogEntity> entityPage = new Page<>();
        entityPage.setSize(page.getSize());
        entityPage.setCurrent(page.getCurrent());
        entityPage.setAsc(page.ascs());
        entityPage.setDesc(page.descs());
        mapper.selectPage(entityPage, queryWrapper);
        Page<OpLogResult> resultPage = CopyUtils.copyPage(entityPage, OpLogResult.class);
        return resultPage;
    }


}

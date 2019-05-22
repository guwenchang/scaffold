package com.smart.log.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.log.center.entity.OpLogEntity;
import com.smart.log.center.param.OpLogParam;
import com.smart.log.center.param.OpLogQueryParam;
import com.smart.log.center.result.OpLogResult;
import com.smart.log.center.mapper.OpLogMapper;
import com.smart.log.center.service.OpLogService;
import com.smart.starter.core.util.CopyUtils ;
import org.springframework.stereotype.Service;

/**
 * 日志
 *
 * @author guwenchang
 * @date 2019-05-22 18:05:51
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
  public Page<OpLogResult> listPage(Page<OpLogResult> page, OpLogQueryParam param) {
    QueryWrapper<OpLogEntity> wrapper = new QueryWrapper();
    Page<OpLogEntity> entityPage = new Page<>();
    CopyUtils.copyObject(page,entityPage);
    page(entityPage, wrapper);
    CopyUtils.copyObject(entityPage,page);
    return page;
  }

  @Override
  public Boolean updateById(OpLogParam param) {
    OpLogEntity entity = CopyUtils.copyObject(param, OpLogEntity.class);
    return updateById(entity);
  }

  @Override
  public Boolean save(OpLogParam param) {
    OpLogEntity entity = CopyUtils.copyObject(param, OpLogEntity.class);
    return save(entity);
  }



}

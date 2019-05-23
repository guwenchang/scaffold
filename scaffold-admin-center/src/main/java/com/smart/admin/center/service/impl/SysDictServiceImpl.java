package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.admin.center.entity.SysDictEntity;
import com.smart.admin.center.param.SysDictParam;
import com.smart.admin.center.param.SysDictQueryParam;
import com.smart.admin.center.result.SysDictResult;
import com.smart.admin.center.mapper.SysDictMapper;
import com.smart.admin.center.service.SysDictService;
import com.smart.starter.core.util.CopyUtils ;
import org.springframework.stereotype.Service;

/**
 * 字典
 *
 * @author guwenchang
 * @date 2019-05-23 17:16:28
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictEntity> implements SysDictService {

    @Override
    public SysDictResult get(Long id) {
      SysDictEntity entity = getById(id);
      SysDictResult result = CopyUtils.copyObject(entity, SysDictResult.class);
      return result;
    }

    @Override
    public Page<SysDictResult> page(Page<SysDictResult> page, SysDictQueryParam param) {
      QueryWrapper<SysDictEntity> wrapper = new QueryWrapper(CopyUtils.copyObject(param, SysDictEntity.class));
      Page<SysDictEntity> entityPage = new Page<>();
      entityPage.setSize(page.getSize());
      entityPage.setCurrent(page.getCurrent());
      entityPage.setAsc(page.ascs());
      entityPage.setDesc(page.descs());
      page(entityPage, wrapper);
      return CopyUtils.copyPage(entityPage, SysDictResult.class);
    }

    @Override
    public Boolean updateById(SysDictParam param) {
      SysDictEntity entity = CopyUtils.copyObject(param, SysDictEntity.class);
      return updateById(entity);
    }

    @Override
    public Boolean save(SysDictParam param) {
      SysDictEntity entity = CopyUtils.copyObject(param, SysDictEntity.class);
      return save(entity);
    }

}

package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.admin.center.entity.SysMenuEntity;
import com.smart.admin.center.param.SysMenuParam;
import com.smart.admin.center.param.SysMenuQueryParam;
import com.smart.admin.center.result.SysMenuResult;
import com.smart.admin.center.mapper.SysMenuMapper;
import com.smart.admin.center.service.SysMenuService;
import com.smart.starter.core.util.CopyUtils ;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单权限
 *
 * @author guwenchang
 * @date 2019-05-23 17:16:28
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {

    @Override
    public SysMenuResult get(Long id) {
      SysMenuEntity entity = getById(id);
      SysMenuResult result = CopyUtils.copyObject(entity, SysMenuResult.class);
      return result;
    }

    @Override
    public Page<SysMenuResult> page(Page<SysMenuResult> page, SysMenuQueryParam param) {
      QueryWrapper<SysMenuEntity> wrapper = new QueryWrapper(CopyUtils.copyObject(param, SysMenuEntity.class));
      Page<SysMenuEntity> entityPage = new Page<>();
      entityPage.setSize(page.getSize());
      entityPage.setCurrent(page.getCurrent());
      entityPage.setAsc(page.ascs());
      entityPage.setDesc(page.descs());
      page(entityPage, wrapper);
      return CopyUtils.copyPage(entityPage, SysMenuResult.class);
    }

    @Override
    public Boolean updateById(SysMenuParam param) {
      SysMenuEntity entity = CopyUtils.copyObject(param, SysMenuEntity.class);
      return updateById(entity);
    }

    @Override
    public Boolean save(SysMenuParam param) {
      SysMenuEntity entity = CopyUtils.copyObject(param, SysMenuEntity.class);
      return save(entity);
    }

}

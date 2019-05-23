package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.admin.center.entity.SysRoleEntity;
import com.smart.admin.center.param.SysRoleParam;
import com.smart.admin.center.param.SysRoleQueryParam;
import com.smart.admin.center.result.SysRoleResult;
import com.smart.admin.center.mapper.SysRoleMapper;
import com.smart.admin.center.service.SysRoleService;
import com.smart.starter.core.util.CopyUtils ;
import org.springframework.stereotype.Service;

/**
 * 角色
 *
 * @author guwenchang
 * @date 2019-05-23 17:16:28
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {

    @Override
    public SysRoleResult get(Long id) {
      SysRoleEntity entity = getById(id);
      SysRoleResult result = CopyUtils.copyObject(entity, SysRoleResult.class);
      return result;
    }

    @Override
    public Page<SysRoleResult> page(Page<SysRoleResult> page, SysRoleQueryParam param) {
      QueryWrapper<SysRoleEntity> wrapper = new QueryWrapper(CopyUtils.copyObject(param, SysRoleEntity.class));
      Page<SysRoleEntity> entityPage = new Page<>();
      entityPage.setSize(page.getSize());
      entityPage.setCurrent(page.getCurrent());
      entityPage.setAsc(page.ascs());
      entityPage.setDesc(page.descs());
      page(entityPage, wrapper);
      return CopyUtils.copyPage(entityPage, SysRoleResult.class);
    }

    @Override
    public Boolean updateById(SysRoleParam param) {
      SysRoleEntity entity = CopyUtils.copyObject(param, SysRoleEntity.class);
      return updateById(entity);
    }

    @Override
    public Boolean save(SysRoleParam param) {
      SysRoleEntity entity = CopyUtils.copyObject(param, SysRoleEntity.class);
      return save(entity);
    }

}

package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.admin.center.entity.SysUserEntity;
import com.smart.admin.center.param.SysUserParam;
import com.smart.admin.center.param.SysUserQueryParam;
import com.smart.admin.center.result.SysUserResult;
import com.smart.admin.center.mapper.SysUserMapper;
import com.smart.admin.center.service.SysUserService;
import com.smart.starter.core.util.CopyUtils ;
import org.springframework.stereotype.Service;

/**
 * 系统用户
 *
 * @author guwenchang
 * @date 2019-05-23 17:16:28
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Override
    public SysUserResult get(Long id) {
      SysUserEntity entity = getById(id);
      SysUserResult result = CopyUtils.copyObject(entity, SysUserResult.class);
      return result;
    }

    @Override
    public Page<SysUserResult> page(Page<SysUserResult> page, SysUserQueryParam param) {
      QueryWrapper<SysUserEntity> wrapper = new QueryWrapper(CopyUtils.copyObject(param, SysUserEntity.class));
      Page<SysUserEntity> entityPage = new Page<>();
      entityPage.setSize(page.getSize());
      entityPage.setCurrent(page.getCurrent());
      entityPage.setAsc(page.ascs());
      entityPage.setDesc(page.descs());
      page(entityPage, wrapper);
      return CopyUtils.copyPage(entityPage, SysUserResult.class);
    }

    @Override
    public Boolean updateById(SysUserParam param) {
      SysUserEntity entity = CopyUtils.copyObject(param, SysUserEntity.class);
      return updateById(entity);
    }

    @Override
    public Boolean save(SysUserParam param) {
      SysUserEntity entity = CopyUtils.copyObject(param, SysUserEntity.class);
      return save(entity);
    }

}

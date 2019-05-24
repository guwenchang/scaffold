package com.smart.admin.center.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Sets;
import com.smart.admin.center.entity.SysMenuEntity;
import com.smart.admin.center.entity.SysRoleEntity;
import com.smart.admin.center.entity.SysUserEntity;
import com.smart.admin.center.mapper.SysMenuMapper;
import com.smart.admin.center.mapper.SysRoleMapper;
import com.smart.admin.center.param.SysUserParam;
import com.smart.admin.center.param.SysUserQueryParam;
import com.smart.admin.center.result.SysMenuResult;
import com.smart.admin.center.result.SysRoleResult;
import com.smart.admin.center.result.SysUserResult;
import com.smart.admin.center.mapper.SysUserMapper;
import com.smart.admin.center.service.SysUserService;
import com.smart.starter.core.util.CopyUtils ;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 系统用户
 *
 * @author guwenchang
 * @date 2019-05-23 17:16:28
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {


    private final SysMenuMapper sysMenuMapper;
    private final SysRoleMapper sysRoleMapper;

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

    @Override
    public List<SysMenuResult> listMenusByUserId(Long userId) {
        //获取角色列表
        List<SysRoleEntity> sysRoleEntityList = sysRoleMapper.listRolesByUserId(userId);
        //获取权限列表
        Set<SysMenuResult> sysMenuResultSet = Sets.newHashSet();
        sysRoleEntityList.forEach(role -> {
            List<SysMenuEntity> sysMenuEntityList = sysMenuMapper.listMenusByRoleId(role.getId());
            List<SysMenuResult> sysMenuResultList = sysMenuEntityList.stream()
                    .map(menu -> CopyUtils.copyObject(menu,SysMenuResult.class)).collect(Collectors.toList());
            sysMenuResultSet.addAll(sysMenuResultList);
        });
        return CollectionUtil.newArrayList(sysMenuResultSet);
    }

}

package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Sets;
import com.smart.admin.center.entity.SysRoleEntity;
import com.smart.admin.center.mapper.SysRoleMapper;
import com.smart.admin.center.result.SysMenuTreeResult;
import com.smart.admin.center.result.SysRoleResult;
import com.smart.starter.core.constant.CommonConstant;
import com.smart.starter.core.util.CopyUtils;
import com.smart.admin.center.entity.SysMenuEntity;
import com.smart.admin.center.mapper.SysMenuMapper;
import com.smart.admin.center.service.ISysMenuService;
import com.smart.starter.core.util.PageUtils;
import com.smart.starter.core.util.TreeUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysMenuParam;
import com.smart.admin.center.param.SysMenuQueryParam;
import com.smart.admin.center.result.SysMenuResult;

import java.util.*;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

/**
 *
 * 菜单权限 服务实现类
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl implements ISysMenuService {

    private final SysMenuMapper mapper;
    private final SysRoleMapper sysRoleMapper;

    @Override
    public Boolean save(SysMenuParam param) {
        SysMenuEntity entity = CopyUtils.copyObject(param, SysMenuEntity.class);
        int insert = mapper.insert(entity);
        return insert > 0;
    }

    @Override
    public Boolean update(SysMenuParam param) {
        SysMenuEntity entity = CopyUtils.copyObject(param, SysMenuEntity.class);
        int update = mapper.updateById(entity);
        return update > 0;

    }

    @Override
    public Boolean delete(Long id) {
        int delete = mapper.deleteById(id);
        return delete > 0;
    }

    @Override
    public SysMenuResult get(Long id) {
        SysMenuEntity entity = mapper.selectById(id);
        return CopyUtils.copyObject(entity, SysMenuResult.class);
    }

    @Override
    public List<SysMenuResult> list(SysMenuQueryParam param) {
        QueryWrapper<SysMenuEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysMenuEntity.class));
        List<SysMenuEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, SysMenuResult.class);
    }

    @Override
    public Page<SysMenuResult> page(Page<SysMenuResult> page, SysMenuQueryParam param) {
        QueryWrapper<SysMenuEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysMenuEntity.class));
        Page<SysMenuEntity> entityPage = PageUtils.buildPage(page, SysMenuEntity.class);
        mapper.selectPage(entityPage, queryWrapper);
        Page<SysMenuResult> resultPage = CopyUtils.copyPage(entityPage, SysMenuResult.class);
        return resultPage;
    }

    @Override
    public List<SysMenuResult> findByRoleId(Long roleId) {
        List<SysMenuEntity> sysMenuEntities = mapper.listMenusByRoleId(roleId);
        return CopyUtils.copyList(sysMenuEntities,SysMenuResult.class);
    }


    @Override
    public List<SysMenuTreeResult> userMenu(Long userId) {
        //获取角色列表
        List<SysRoleEntity> sysRoleEntityList = sysRoleMapper.listRolesByUserId(userId);
        //获取权限列表
        Set<SysMenuEntity> sysMenuEntities = Sets.newHashSet();
        sysRoleEntityList.forEach(role -> {
            List<SysMenuEntity> sysMenuEntityList = mapper.listMenusByRoleId(role.getId());
            sysMenuEntities.addAll(sysMenuEntityList);
        });
        return getSysMenuTreeResults(sysMenuEntities);
    }

    @Override
    public List<SysMenuTreeResult> allTree() {
        List<SysMenuEntity> sysMenuEntities = mapper.selectList(null);
        return getSysMenuTreeResults(sysMenuEntities);
    }

    private List<SysMenuTreeResult> getSysMenuTreeResults(Collection<SysMenuEntity> sysMenuEntities) {
        List<SysMenuTreeResult> sysMenuTreeResults = sysMenuEntities.stream().filter(result -> CommonConstant.MenuType.MENU == result.getType())
                .map(result -> CopyUtils.copyObject(result, SysMenuTreeResult.class))
                .sorted(Comparator.comparingInt(SysMenuTreeResult::getSort))
                .collect(Collectors.toList());
        return TreeUtil.bulid(sysMenuTreeResults, "");
    }

}

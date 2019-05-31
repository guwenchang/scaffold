package com.smart.admin.center.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.entity.SysRoleEntity;
import com.smart.admin.center.entity.SysRoleMenuEntity;
import com.smart.admin.center.mapper.SysRoleMapper;
import com.smart.admin.center.mapper.SysRoleMenuMapper;
import com.smart.admin.center.param.SysRoleMenuUpdateParam;
import com.smart.admin.center.param.SysRoleParam;
import com.smart.admin.center.param.SysRoleQueryParam;
import com.smart.admin.center.result.SysRoleResult;
import com.smart.admin.center.service.ISysRoleService;
import com.smart.starter.core.util.CopyUtils;
import com.smart.starter.core.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 角色 服务实现类
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl implements ISysRoleService {

    private final SysRoleMapper mapper;
    private final SysRoleMenuMapper sysRoleMenuMapper;


    @Override
    public Boolean save(SysRoleParam param) {
        SysRoleEntity entity = CopyUtils.copyObject(param, SysRoleEntity.class);
        int insert = mapper.insert(entity);
        return insert > 0;
    }

    @Override
    public Boolean update(SysRoleParam param) {
        SysRoleEntity entity = CopyUtils.copyObject(param, SysRoleEntity.class);
        int update = mapper.updateById(entity);
        return update > 0;

    }

    @Override
    public Boolean delete(Long id) {
        int delete = mapper.deleteById(id);
        return delete > 0;
    }

    @Override
    public SysRoleResult get(Long id) {
        SysRoleEntity entity = mapper.selectById(id);
        return CopyUtils.copyObject(entity, SysRoleResult.class);
    }

    @Override
    public List<SysRoleResult> list(SysRoleQueryParam param) {
        QueryWrapper<SysRoleEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysRoleEntity.class));
        List<SysRoleEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, SysRoleResult.class);
    }

    @Override
    public Page<SysRoleResult> page(Page<SysRoleResult> page, SysRoleQueryParam param) {
        QueryWrapper<SysRoleEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysRoleEntity.class));
        Page<SysRoleEntity> entityPage = PageUtils.buildPage(page, SysRoleEntity.class);
        mapper.selectPage(entityPage, queryWrapper);
        Page<SysRoleResult> resultPage = CopyUtils.copyPage(entityPage, SysRoleResult.class);
        return resultPage;
    }

    @Override
    public Boolean updateMenu(SysRoleMenuUpdateParam param) {
        QueryWrapper<SysRoleMenuEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRoleMenuEntity::getRoleId,param.getId());
        sysRoleMenuMapper.delete(queryWrapper);
        if (CollectionUtil.isEmpty(param.getMenuIds())) {
            return Boolean.TRUE;
        }

        List<SysRoleMenuEntity> roleMenuList = param.getMenuIds().stream()
                .map(menuId -> {
                    SysRoleMenuEntity roleMenu = new SysRoleMenuEntity();
                    roleMenu.setRoleId(param.getId());
                    roleMenu.setMenuId(menuId);
                    return roleMenu;
                }).collect(Collectors.toList());
        roleMenuList.forEach(sysRoleMenu -> {
            sysRoleMenuMapper.insert(sysRoleMenu);
        });
        //清空用户缓存
        return Boolean.TRUE;
    }



}

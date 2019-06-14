package com.smart.auth.center.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Sets;
import com.smart.auth.center.entity.SysMenuEntity;
import com.smart.auth.center.entity.SysRoleEntity;
import com.smart.auth.center.entity.SysUserEntity;
import com.smart.auth.center.mapper.SysMenuMapper;
import com.smart.auth.center.mapper.SysRoleMapper;
import com.smart.auth.center.mapper.SysUserMapper;
import com.smart.auth.center.result.SysMenuResult;
import com.smart.auth.center.service.ISysUserService;
import com.smart.starter.core.util.CopyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * 系统用户 服务实现类
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements ISysUserService {

    private final SysUserMapper mapper;
    private final SysMenuMapper sysMenuMapper;
    private final SysRoleMapper sysRoleMapper;




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

    @Override
    public SysUserEntity getOneByUserName(String username) {
        return mapper.selectOne(new QueryWrapper<SysUserEntity>().lambda().eq(SysUserEntity::getUsername,username));
    }

}

package com.smart.admin.center.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Sets;
import com.smart.admin.center.entity.SysMenuEntity;
import com.smart.admin.center.entity.SysRoleEntity;
import com.smart.admin.center.entity.SysUserEntity;
import com.smart.admin.center.entity.SysUserRoleEntity;
import com.smart.admin.center.mapper.SysMenuMapper;
import com.smart.admin.center.mapper.SysRoleMapper;
import com.smart.admin.center.mapper.SysUserMapper;
import com.smart.admin.center.mapper.SysUserRoleMapper;
import com.smart.admin.center.param.SysUserParam;
import com.smart.admin.center.param.SysUserQueryParam;
import com.smart.admin.center.result.SysMenuResult;
import com.smart.admin.center.result.SysRoleResult;
import com.smart.admin.center.result.SysUserResult;
import com.smart.admin.center.service.ISysUserService;
import com.smart.starter.core.util.CopyUtils;
import com.smart.starter.core.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final SysUserRoleMapper sysUserRoleMapper;
    private final SysMenuMapper sysMenuMapper;
    private final SysRoleMapper sysRoleMapper;
    private final PasswordEncoder passwordEncoder;



    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean save(SysUserParam param) {
        SysUserEntity entity = CopyUtils.copyObject(param, SysUserEntity.class);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        int insert = mapper.insert(entity);
        updateUserRole(param, entity);
        return insert > 0;
    }

    @Override
    public Boolean update(SysUserParam param) {
        SysUserEntity entity = CopyUtils.copyObject(param, SysUserEntity.class);
        if (StrUtil.isNotBlank(entity.getPassword())){
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        }
        int update = mapper.updateById(entity);
        QueryWrapper<SysUserRoleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysUserRoleEntity::getUserId, param.getId());
        sysUserRoleMapper.delete(queryWrapper);
        updateUserRole(param, entity);
        return update > 0;

    }

    @Override
    public Boolean delete(Long id) {
        int delete = mapper.deleteById(id);
        return delete > 0;
    }

    @Override
    public SysUserResult get(Long id) {
        SysUserEntity entity = mapper.selectById(id);
        SysUserResult sysUserResult = CopyUtils.copyObject(entity, SysUserResult.class);
        List<SysRoleEntity> sysRoleEntities = sysRoleMapper.listRolesByUserId(id);
        sysUserResult.setRoles(CopyUtils.copyList(sysRoleEntities, SysRoleResult.class));
        return sysUserResult;
    }

    @Override
    public List<SysUserResult> list(SysUserQueryParam param) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysUserEntity.class));
        List<SysUserEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, SysUserResult.class);
    }

    @Override
    public Page<SysUserResult> page(Page<SysUserResult> page, SysUserQueryParam param) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysUserEntity.class));
        Page<SysUserEntity> entityPage = PageUtils.buildPage(page, SysUserEntity.class);
        mapper.selectPage(entityPage, queryWrapper);
        Page<SysUserResult> resultPage = CopyUtils.copyPage(entityPage, SysUserResult.class);
        return resultPage;
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

    @Override
    public SysUserEntity getOneByUserName(String username) {
        return mapper.selectOne(new QueryWrapper<SysUserEntity>().lambda().eq(SysUserEntity::getUsername,username));
    }

    private void updateUserRole(SysUserParam param, SysUserEntity entity) {
        param.getRoleIds().forEach(roleId -> {
            SysUserRoleEntity userRole = new SysUserRoleEntity();
            userRole.setUserId(entity.getId());
            userRole.setRoleId(roleId);
            sysUserRoleMapper.insert(userRole);
        });
    }
}

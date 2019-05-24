package com.smart.admin.center.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Sets;
import com.smart.admin.center.entity.SysMenuEntity;
import com.smart.admin.center.entity.SysRoleEntity;
import com.smart.admin.center.mapper.SysMenuMapper;
import com.smart.admin.center.mapper.SysRoleMapper;
import com.smart.admin.center.result.SysMenuResult;
import com.smart.starter.core.util.CopyUtils;
import com.smart.admin.center.entity.SysUserEntity;
import com.smart.admin.center.mapper.SysUserMapper;
import com.smart.admin.center.service.ISysUserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysUserParam;
import com.smart.admin.center.param.SysUserQueryParam;
import com.smart.admin.center.result.SysUserResult;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

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
    public Boolean save(SysUserParam param) {
        SysUserEntity entity = CopyUtils.copyObject(param, SysUserEntity.class);
        int insert = mapper.insert(entity);
        return insert > 0;
    }

    @Override
    public Boolean update(SysUserParam param) {
        SysUserEntity entity = CopyUtils.copyObject(param, SysUserEntity.class);
        int update = mapper.updateById(entity);
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
        return CopyUtils.copyObject(entity, SysUserResult.class);
    }

    @Override
    public List<SysUserResult> list(SysUserQueryParam param) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        List<SysUserEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, SysUserResult.class);
    }

    @Override
    public Page<SysUserResult> page(Page<SysUserResult> page, SysUserQueryParam param) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        Page<SysUserEntity> entityPage = new Page<>();
        entityPage.setSize(page.getSize());
        entityPage.setCurrent(page.getCurrent());
        entityPage.setAsc(page.ascs());
        entityPage.setDesc(page.descs());
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


}

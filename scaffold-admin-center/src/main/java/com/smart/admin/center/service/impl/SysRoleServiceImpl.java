package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.starter.core.util.CopyUtils;
import com.smart.admin.center.entity.SysRoleEntity;
import com.smart.admin.center.mapper.SysRoleMapper;
import com.smart.admin.center.service.ISysRoleService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysRoleParam;
import com.smart.admin.center.param.SysRoleQueryParam;
import com.smart.admin.center.result.SysRoleResult;
import java.util.List;
import lombok.RequiredArgsConstructor;

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
        QueryWrapper<SysRoleEntity> queryWrapper = new QueryWrapper<>();
        List<SysRoleEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, SysRoleResult.class);
    }

    @Override
    public Page<SysRoleResult> page(Page<SysRoleResult> page, SysRoleQueryParam param) {
        QueryWrapper<SysRoleEntity> queryWrapper = new QueryWrapper<>();
        Page<SysRoleEntity> entityPage = new Page<>();
        entityPage.setSize(page.getSize());
        entityPage.setCurrent(page.getCurrent());
        entityPage.setAsc(page.ascs());
        entityPage.setDesc(page.descs());
        mapper.selectPage(entityPage, queryWrapper);
        Page<SysRoleResult> resultPage = CopyUtils.copyPage(entityPage, SysRoleResult.class);
        return resultPage;
    }


}

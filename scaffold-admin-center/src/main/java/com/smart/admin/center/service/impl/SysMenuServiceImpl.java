package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.starter.core.util.CopyUtils;
import com.smart.admin.center.entity.SysMenuEntity;
import com.smart.admin.center.mapper.SysMenuMapper;
import com.smart.admin.center.service.ISysMenuService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysMenuParam;
import com.smart.admin.center.param.SysMenuQueryParam;
import com.smart.admin.center.result.SysMenuResult;
import java.util.List;
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
        QueryWrapper<SysMenuEntity> queryWrapper = new QueryWrapper<>();
        List<SysMenuEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, SysMenuResult.class);
    }

    @Override
    public Page<SysMenuResult> page(Page<SysMenuResult> page, SysMenuQueryParam param) {
        QueryWrapper<SysMenuEntity> queryWrapper = new QueryWrapper<>();
        Page<SysMenuEntity> entityPage = new Page<>();
        entityPage.setSize(page.getSize());
        entityPage.setCurrent(page.getCurrent());
        entityPage.setAsc(page.ascs());
        entityPage.setDesc(page.descs());
        mapper.selectPage(entityPage, queryWrapper);
        Page<SysMenuResult> resultPage = CopyUtils.copyPage(entityPage, SysMenuResult.class);
        return resultPage;
    }


}

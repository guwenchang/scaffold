package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.starter.core.util.CopyUtils;
import com.smart.admin.center.entity.SysDictEntity;
import com.smart.admin.center.mapper.SysDictMapper;
import com.smart.admin.center.service.ISysDictService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysDictParam;
import com.smart.admin.center.param.SysDictQueryParam;
import com.smart.admin.center.result.SysDictResult;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 *
 * 字典 服务实现类
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Service
@RequiredArgsConstructor
public class SysDictServiceImpl implements ISysDictService {

    private final SysDictMapper mapper;


    @Override
    public Boolean save(SysDictParam param) {
        SysDictEntity entity = CopyUtils.copyObject(param, SysDictEntity.class);
        int insert = mapper.insert(entity);
        return insert > 0;
    }

    @Override
    public Boolean update(SysDictParam param) {
        SysDictEntity entity = CopyUtils.copyObject(param, SysDictEntity.class);
        int update = mapper.updateById(entity);
        return update > 0;

    }

    @Override
    public Boolean delete(Long id) {
        int delete = mapper.deleteById(id);
        return delete > 0;
    }

    @Override
    public SysDictResult get(Long id) {
        SysDictEntity entity = mapper.selectById(id);
        return CopyUtils.copyObject(entity, SysDictResult.class);
    }

    @Override
    public List<SysDictResult> list(SysDictQueryParam param) {
        QueryWrapper<SysDictEntity> queryWrapper = new QueryWrapper<>();
        List<SysDictEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, SysDictResult.class);
    }

    @Override
    public Page<SysDictResult> page(Page<SysDictResult> page, SysDictQueryParam param) {
        QueryWrapper<SysDictEntity> queryWrapper = new QueryWrapper<>();
        Page<SysDictEntity> entityPage = new Page<>();
        entityPage.setSize(page.getSize());
        entityPage.setCurrent(page.getCurrent());
        entityPage.setAsc(page.ascs());
        entityPage.setDesc(page.descs());
        mapper.selectPage(entityPage, queryWrapper);
        Page<SysDictResult> resultPage = CopyUtils.copyPage(entityPage, SysDictResult.class);
        return resultPage;
    }


}

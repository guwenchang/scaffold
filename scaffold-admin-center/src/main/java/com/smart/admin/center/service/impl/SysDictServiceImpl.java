package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.starter.core.util.CopyUtils;
import com.smart.admin.center.entity.SysDictEntity;
import com.smart.admin.center.mapper.SysDictMapper;
import com.smart.admin.center.service.ISysDictService;
import com.smart.starter.core.util.PageUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    public static final String DICT_DETAILS = "dict_details";


    @Override
    @CacheEvict(value = DICT_DETAILS, key = "#param.type")
    public Boolean save(SysDictParam param) {
        SysDictEntity entity = CopyUtils.copyObject(param, SysDictEntity.class);
        int insert = mapper.insert(entity);
        return insert > 0;
    }

    @Override
    @CacheEvict(value = DICT_DETAILS, key = "#param.type")
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
    @Cacheable(value = DICT_DETAILS, key = "#param.type")
    public List<SysDictResult> list(SysDictQueryParam param) {
        QueryWrapper<SysDictEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysDictEntity.class));
        queryWrapper.lambda().orderByAsc(SysDictEntity::getSort);
        List<SysDictEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, SysDictResult.class);
    }

    @Override
    public Page<SysDictResult> page(Page<SysDictResult> page, SysDictQueryParam param) {
        QueryWrapper<SysDictEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysDictEntity.class));
        Page<SysDictEntity> entityPage = PageUtils.buildPage(page, SysDictEntity.class);
        mapper.selectPage(entityPage, queryWrapper);
        Page<SysDictResult> resultPage = CopyUtils.copyPage(entityPage, SysDictResult.class);
        return resultPage;
    }


}

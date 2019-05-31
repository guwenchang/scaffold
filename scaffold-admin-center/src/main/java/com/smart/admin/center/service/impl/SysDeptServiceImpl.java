package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.admin.center.entity.SysDictEntity;
import com.smart.admin.center.result.SysDeptTreeResult;
import com.smart.starter.core.util.CopyUtils;
import com.smart.admin.center.entity.SysDeptEntity;
import com.smart.admin.center.mapper.SysDeptMapper;
import com.smart.admin.center.service.ISysDeptService;
import com.smart.starter.core.util.PageUtils;
import com.smart.starter.core.util.TreeUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysDeptParam;
import com.smart.admin.center.param.SysDeptQueryParam;
import com.smart.admin.center.result.SysDeptResult;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

/**
 *
 * 部门 服务实现类
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
@Service
@RequiredArgsConstructor
public class SysDeptServiceImpl implements ISysDeptService {

    private final SysDeptMapper mapper;


    @Override
    public Boolean save(SysDeptParam param) {
        SysDeptEntity entity = CopyUtils.copyObject(param, SysDeptEntity.class);
        int insert = mapper.insert(entity);
        return insert > 0;
    }

    @Override
    public Boolean update(SysDeptParam param) {
        SysDeptEntity entity = CopyUtils.copyObject(param, SysDeptEntity.class);
        int update = mapper.updateById(entity);
        return update > 0;

    }

    @Override
    public Boolean delete(Long id) {
        int delete = mapper.deleteById(id);
        return delete > 0;
    }

    @Override
    public SysDeptResult get(Long id) {
        SysDeptEntity entity = mapper.selectById(id);
        return CopyUtils.copyObject(entity, SysDeptResult.class);
    }

    @Override
    public List<SysDeptResult> list(SysDeptQueryParam param) {
        QueryWrapper<SysDeptEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysDeptEntity.class));
        List<SysDeptEntity> entityList = mapper.selectList(queryWrapper);
        return CopyUtils.copyList(entityList, SysDeptResult.class);
    }

    @Override
    public Page<SysDeptResult> page(Page<SysDeptResult> page, SysDeptQueryParam param) {
        QueryWrapper<SysDeptEntity> queryWrapper = new QueryWrapper<>(CopyUtils.copyObject(param,SysDeptEntity.class));
        Page<SysDeptEntity> entityPage = PageUtils.buildPage(page, SysDeptEntity.class);
        mapper.selectPage(entityPage, queryWrapper);
        Page<SysDeptResult> resultPage = CopyUtils.copyPage(entityPage, SysDeptResult.class);
        return resultPage;
    }

    @Override
    public List<SysDeptTreeResult> selectListTree() {
        List<SysDeptEntity> deptEntityList = mapper.selectList(null);
        return getDeptTree(deptEntityList, "");
    }


    /**
     * 构建部门树
     *
     * @param deptEntityList 部门
     * @return
     */
    private List<SysDeptTreeResult> getDeptTree(List<SysDeptEntity> deptEntityList, String parentCode) {
        List<SysDeptTreeResult> treeList = deptEntityList.stream()
                .filter(dept -> !dept.getCode().equals(dept.getParentCode()))
                .map(dept -> {
                    SysDeptTreeResult node = new SysDeptTreeResult();
                    node.setCode(dept.getCode());
                    node.setParentCode(dept.getParentCode());
                    node.setName(dept.getName());
                    return node;
                }).collect(Collectors.toList());
        return TreeUtil.bulid(treeList, parentCode);
    }



}

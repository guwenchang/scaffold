package com.smart.admin.center.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.admin.center.entity.SysDeptEntity;
import com.smart.admin.center.param.SysDeptParam;
import com.smart.admin.center.param.SysDeptQueryParam;
import com.smart.admin.center.result.SysDeptResult;
import com.smart.admin.center.mapper.SysDeptMapper;
import com.smart.admin.center.result.SysDeptTreeResult;
import com.smart.admin.center.service.SysDeptService;
import com.smart.starter.core.util.CopyUtils;
import com.smart.starter.core.util.TreeUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门
 *
 * @author guwenchang
 * @date 2019-05-23 15:14:18
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDeptEntity> implements SysDeptService {

    @Override
    public SysDeptResult get(Long id) {
        SysDeptEntity entity = getById(id);
        SysDeptResult result = CopyUtils.copyObject(entity, SysDeptResult.class);
        return result;
    }

    @Override
    public Page<SysDeptResult> page(Page<SysDeptResult> page, SysDeptQueryParam param) {
        QueryWrapper<SysDeptEntity> wrapper = new QueryWrapper(CopyUtils.copyObject(param, SysDeptEntity.class));
        Page<SysDeptEntity> entityPage = new Page<>();
        entityPage.setSize(page.getSize());
        entityPage.setCurrent(page.getCurrent());
        entityPage.setAsc(page.ascs());
        entityPage.setDesc(page.descs());
        page(entityPage, wrapper);
        return CopyUtils.copyPage(entityPage, SysDeptResult.class);

    }

    @Override
    public Boolean updateById(SysDeptParam param) {
        SysDeptEntity entity = CopyUtils.copyObject(param, SysDeptEntity.class);
        return updateById(entity);
    }

    @Override
    public Boolean save(SysDeptParam param) {
        SysDeptEntity entity = CopyUtils.copyObject(param, SysDeptEntity.class);
        return save(entity);
    }

    @Override
    public List<SysDeptTreeResult> selectListTree() {
        List<SysDeptEntity> deptEntityList = list();
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

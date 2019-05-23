package com.smart.admin.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.admin.center.entity.SysRoleEntity;

import java.util.List;

/**
 * 角色
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {


    /**
     * 通过用户ID，查询角色信息
     *
     * @param userId
     * @return
     */
    List<SysRoleEntity> listRolesByUserId(Long userId);

}

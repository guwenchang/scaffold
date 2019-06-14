package com.smart.auth.center.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.auth.center.entity.SysMenuEntity;

import java.util.List;

/**
 * 菜单权限
 *
 * @author guwenchang
 * @date 2019-05-23 16:59:41
 */
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

    /**
     * 根据角色id查询权限集合
     *
     * @param roleId
     * @return
     */
    List<SysMenuEntity> listMenusByRoleId(Long roleId);


}

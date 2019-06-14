package com.smart.auth.center.service;

import com.smart.auth.center.entity.SysUserEntity;
import com.smart.auth.center.result.SysMenuResult;

import java.util.List;

/**
 *
 * 系统用户 服务接口
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
public interface ISysUserService {



    /**
     * 根据用户ID获取用户权限
     * @param userId
     * @return
     */
    List<SysMenuResult> listMenusByUserId(Long userId);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    SysUserEntity getOneByUserName(String username);
}

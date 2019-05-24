package com.smart.admin.center.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.entity.SysUserEntity;
import com.smart.admin.center.param.SysUserParam;
import com.smart.admin.center.param.SysUserQueryParam;
import com.smart.admin.center.result.SysMenuResult;
import com.smart.admin.center.result.SysUserResult;
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
     * 保存
     *
     * @param param
     * @return
     */
    Boolean save(SysUserParam param);

    /**
     * 更新
     *
     * @param param
     * @return
     */
    Boolean update(SysUserParam param);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Boolean delete(Long id);

    /**
     * 根据id获取
     *
     * @param id
     * @return
     */
    SysUserResult get(Long id);

    /**
     * 列表查询
     *
     * @param param
     * @return
     */
    List<SysUserResult> list(SysUserQueryParam param);


    /**
     * 分页查询
     *
     * @param page
     * @param param
     * @return
     */
    Page<SysUserResult> page(Page<SysUserResult> page, SysUserQueryParam param);


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

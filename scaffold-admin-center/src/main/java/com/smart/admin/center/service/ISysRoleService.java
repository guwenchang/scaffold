package com.smart.admin.center.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysRoleParam;
import com.smart.admin.center.param.SysRoleQueryParam;
import com.smart.admin.center.result.SysRoleResult;
import java.util.List;

/**
 *
 * 角色 服务接口
 *
 * @author guxiaobai
 * @date 2019-05-24
 */
public interface ISysRoleService {

    /**
     * 保存
     *
     * @param param
     * @return
     */
    Boolean save(SysRoleParam param);

    /**
     * 更新
     *
     * @param param
     * @return
     */
    Boolean update(SysRoleParam param);

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
    SysRoleResult get(Long id);

    /**
     * 列表查询
     *
     * @param param
     * @return
     */
    List<SysRoleResult> list(SysRoleQueryParam param);


    /**
     * 分页查询
     *
     * @param page
     * @param param
     * @return
     */
    Page<SysRoleResult> page(Page<SysRoleResult> page, SysRoleQueryParam param);

}

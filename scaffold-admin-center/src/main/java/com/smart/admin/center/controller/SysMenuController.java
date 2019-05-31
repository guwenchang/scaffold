package com.smart.admin.center.controller;


import com.smart.admin.center.param.SysMenuParam;
import com.smart.admin.center.result.SysMenuResult;
import com.smart.admin.center.result.SysMenuTreeResult;
import com.smart.admin.center.service.ISysMenuService;
import com.smart.starter.core.model.ApiResult;
import com.smart.starter.core.model.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限管理
 * @author guwenchang
 * @date 2019-05-31
 */
@Api(tags = "权限管理")
@RestController
@RequestMapping("/sys/sys-menu")
@RequiredArgsConstructor
@Validated
public class SysMenuController extends BaseController {
    private final ISysMenuService sysMenuService;

    /**
     * 添加菜单
     *
     * @param param 菜单信息
     * @return success/false
     */
    @ApiOperation(value = "添加菜单")
    @PostMapping
    public ApiResult<Boolean> add(@Validated @RequestBody SysMenuParam param) {
        return ApiResult.success(sysMenuService.save(param));
    }


    /**
     * 更新菜单
     *
     * @param param 菜单信息
     * @return
     */
    @ApiOperation(value = "更新菜单")
    @PutMapping
    public ApiResult<Boolean> update(@Validated @RequestBody SysMenuParam param) {
        return ApiResult.success(sysMenuService.update(param));
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return success/false
     */
    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.success(sysMenuService.delete(id));
    }


    /**
     * 通过ID查询
     *
     * @param id 菜单ID
     * @return 菜单详细信息
     */
    @ApiOperation(value = "通过ID查询")
    @GetMapping("/{id}")
    public ApiResult<SysMenuResult> get(@PathVariable Long id) {
        return ApiResult.success(sysMenuService.get(id));
    }

    /**
     * 通过角色编码查询菜单
     *
     * @param roleId 角色id
     * @return 菜单列表
     */
    @ApiOperation(value = "通过角色编码查询菜单")
    @GetMapping("/role/{roleId}")
    public ApiResult<List<SysMenuResult>> findMenuByRoleId(@PathVariable Long roleId) {
        return ApiResult.success(sysMenuService.findByRoleId(roleId));
    }

    /**
     * 查询用户的权限
     *
     * @return 当前用户的树形菜单
     */
    @ApiOperation(value = "查询用户的权限")
    @GetMapping(value = "/user/{userId}")
    public ApiResult<List<SysMenuTreeResult>> userMenu(@PathVariable Long userId) {
        return ApiResult.success(sysMenuService.userMenu(userId));
    }

    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @ApiOperation(value = "返回树形菜单集合")
    @GetMapping(value = "/tree")
    public ApiResult<List<SysMenuTreeResult>> allTree() {
        return ApiResult.success(sysMenuService.allTree());

    }






}

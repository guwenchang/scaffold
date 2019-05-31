package com.smart.admin.center.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysRoleMenuUpdateParam;
import com.smart.admin.center.param.SysRoleParam;
import com.smart.admin.center.param.SysRoleQueryParam;
import com.smart.admin.center.result.SysRoleResult;
import com.smart.admin.center.service.ISysRoleService;
import com.smart.starter.core.model.ApiResult;
import com.smart.starter.core.model.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 角色管理
 * @author guwenchang
 * @date 2019-05-31
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/sys/sys-role")
@AllArgsConstructor
public class SysRoleController extends BaseController {
    private final ISysRoleService sysRoleService;


    /**
     * 添加角色
     *
     * @param param 角色信息
     * @return success、false
     */
    @ApiOperation(value = "添加角色")
    @PostMapping
    public ApiResult<Boolean> save(@RequestBody SysRoleParam param) {
        return ApiResult.success(sysRoleService.save(param));
    }

    /**
     * 修改角色
     *
     * @param param 角色信息
     * @return success/false
     */
    @ApiOperation(value = "修改角色")
    @PutMapping
    public ApiResult<Boolean> update(@RequestBody SysRoleParam param) {
        return ApiResult.success(sysRoleService.update(param));
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return success/false
     */
    @ApiOperation(value = "根据id删除")
    @DeleteMapping("/{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.success(sysRoleService.delete(id));

    }

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return 角色信息
     */
    @ApiOperation(value = "通过ID查询")
    @GetMapping("/{id}")
    public ApiResult<SysRoleResult> get(@PathVariable Long id) {
        return ApiResult.success(sysRoleService.get(id));
    }

    /**
     * 分页查询
     *
     * @param param 查询对象
     * @return 分页对象
     */
    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ApiResult<Page<SysRoleResult>> page(SysRoleQueryParam param) {
        Page<SysRoleResult> page = getPage(param);
        return ApiResult.success(sysRoleService.page(page, param));
    }

    /**
     * 更新角色菜单
     *
     * @param param 更新参数
     * @return success、false
     */
    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/menu")
    public ApiResult<Boolean> updateMenu(@RequestBody SysRoleMenuUpdateParam param) {
        return ApiResult.success(sysRoleService.updateMenu(param));

    }


}

package com.smart.admin.center.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysUserParam;
import com.smart.admin.center.param.SysUserQueryParam;
import com.smart.admin.center.result.SysUserResult;
import com.smart.admin.center.service.ISysUserService;
import com.smart.starter.core.model.ApiResult;
import com.smart.starter.core.model.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理
 * @author guwenchang
 * @date 2019-05-31
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/sys/sys-user")
@RequiredArgsConstructor
public class SysUserController extends BaseController {
    private final ISysUserService sysUserService;


    /**
     * 添加用户
     *
     * @param param 用户信息
     * @return success/false
     */
    @ApiOperation("添加用户")
    @PostMapping
    public ApiResult<Boolean> save(@Validated @RequestBody SysUserParam param) {
        return ApiResult.success(sysUserService.save(param));
    }


    /**
     * 更新用户
     *
     * @param param 用户信息
     * @return R
     */
    @ApiOperation("更新用户")
    @PutMapping
    public ApiResult<Boolean> update(@Validated @RequestBody SysUserParam param) {
        return ApiResult.success(sysUserService.update(param));

    }


    /**
     * 删除用户信息
     *
     * @param id ID
     * @return R
     */
    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.success(sysUserService.delete(id));
    }


    /**
     * 通过ID查询(含角色)
     *
     * @param id ID
     * @return 用户信息
     */
    @ApiOperation("通过ID查询")
    @GetMapping("/{id}")
    public ApiResult<SysUserResult> get(@PathVariable Long id) {
        return ApiResult.success(sysUserService.get(id));
    }


    /**
     * 分页查询
     *
     * @param param 查询参数
     * @return 用户集合
     */
    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ApiResult<Page<SysUserResult>> page(SysUserQueryParam param) {
        Page<SysUserResult> page = getPage(param);
        return ApiResult.success(sysUserService.page(page, param));
    }

}

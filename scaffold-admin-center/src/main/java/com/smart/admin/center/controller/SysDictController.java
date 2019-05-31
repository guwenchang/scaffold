package com.smart.admin.center.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysDictParam;
import com.smart.admin.center.param.SysDictQueryParam;
import com.smart.admin.center.result.SysDictResult;
import com.smart.admin.center.service.ISysDictService;
import com.smart.starter.core.model.ApiResult;
import com.smart.starter.core.model.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 字典管理
 * @author guwenchang
 * @date 2019-05-31
 */
@Api(tags = "字典管理")
@RestController
@RequestMapping("/sys/sys-dict")
@RequiredArgsConstructor
@Validated
public class SysDictController extends BaseController {

    private final ISysDictService sysDictService;

    /**
     * 添加字典
     *
     * @param param 字典信息
     * @return success、false
     */
    @ApiOperation(value = "添加字典")
    @PostMapping
    public ApiResult<Boolean> add(@Validated @RequestBody SysDictParam param) {
        return ApiResult.success(sysDictService.save(param));
    }


    /**
     * 修改字典
     *
     * @param param 字典信息
     * @return success/false
     */
    @ApiOperation(value = "修改字典")
    @PutMapping
    public ApiResult<Boolean> update(@Validated @RequestBody SysDictParam param) {
        return ApiResult.success(sysDictService.update(param));
    }

    /**
     * 删除字典
     *
     * @param id ID
     * @return R
     */
    @ApiOperation(value = "删除字典")
    @DeleteMapping("/{id}")
    public ApiResult<Boolean> delete(@PathVariable Long id) {
        return ApiResult.success(sysDictService.delete(id));
    }


    /**
     * 通过ID查询
     *
     * @param id ID
     * @return 字典信息
     */
    @ApiOperation("通过ID查询")
    @GetMapping("/{id}")
    public ApiResult<SysDictResult> get(@Min(1L) @PathVariable Long id) {
        SysDictResult result = sysDictService.get(id);
        return ApiResult.success(result);
    }

    /**
     * 分页查询
     *
     * @param param 查询参数
     * @return
     */
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<Page<SysDictResult>> page(SysDictQueryParam param) {
        Page<SysDictResult> page = getPage(param);
        return ApiResult.success(sysDictService.page(page, param));
    }

    /**
     * 通过字典类型查询
     *
     * @param type 类型
     * @return 同类型字典
     */
    @ApiOperation(value = "通过字典类型查询")
    @GetMapping("/type/{type}")
    public ApiResult<List<SysDictResult>> listByType(@NotBlank @PathVariable String type) {
        SysDictQueryParam param = new SysDictQueryParam();
        param.setType(type);
        return ApiResult.success(sysDictService.list(param));
    }






}

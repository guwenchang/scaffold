package com.smart.admin.center.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.admin.center.param.SysDeptParam;
import com.smart.admin.center.param.SysDeptQueryParam;
import com.smart.admin.center.result.SysDeptResult;
import com.smart.admin.center.result.SysDeptTreeResult;
import com.smart.admin.center.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.smart.starter.core.model.*;

import java.util.List;


/**
 * 部门
 *
 * @author guwenchang
 * @date 2019-05-23 15:14:18
 */
@Api(tags = "部门管理")
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysDept")
public class SysDeptController extends BaseController  {

    private final  SysDeptService sysDeptService;

    /**
     * 简单分页查询
     * @param param
     * @return
     */
    @GetMapping("/page")
    public ApiResult<Page<SysDeptResult>> page(@RequestBody SysDeptQueryParam param) {
      Page<SysDeptResult> page = getPage(param);
      sysDeptService.page(page,param);
      return ApiResult.success(page);
    }


    /**
     * 通过id查询单条记录
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ApiResult<SysDeptResult> get(@PathVariable("id") Long id){
      return ApiResult.success(sysDeptService.get(id));
    }

    /**
     * 新增记录
     * @param param
     * @return
     */
    @PostMapping
    public ApiResult save(@RequestBody SysDeptParam param){
      return ApiResult.success(sysDeptService.save(param));
    }

    /**
     * 修改记录
     * @param param
     * @return
     */
    @PutMapping
    public ApiResult update(@RequestBody SysDeptParam param){
      return ApiResult.success(sysDeptService.updateById(param));
    }


    /**
     * 返回部门树
     *
     * @return 树形菜单
     */
    @ApiOperation(value = "获取部门树")
    @GetMapping(value = "/tree")
    public ApiResult<List<SysDeptTreeResult>> getTree() {
        return ApiResult.success(sysDeptService.selectListTree());
    }


    /**
     * 通过id删除一条记录
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ApiResult removeById(@PathVariable Long id){
      return ApiResult.success(sysDeptService.removeById(id));
    }

}

package com.smart.log.center.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.log.center.param.OpLogQueryParam;
import com.smart.log.center.result.OpLogResult;
import com.smart.log.center.service.IOpLogService;
import com.smart.starter.core.model.ApiResult;
import com.smart.starter.core.model.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 日志
 *
 * @author guwenchang
 * @date 2019-05-22 19:17:59
 */
@Api(tags = "日志相关接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class OpLogController extends BaseController  {

    private final IOpLogService opLogService;

    /**
     * 简单分页查询
     * @param param
     * @return
     */
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public ApiResult<Page<OpLogResult>> page(OpLogQueryParam param) {
      Page<OpLogResult> page = getPage(param);
      return ApiResult.success(opLogService.page(page, param));
    }


    /**
     * 通过id查询单条记录
     * @param id
     * @return
     */
    @ApiOperation("根据ID查询")
    @GetMapping("/{id}")
    public ApiResult<OpLogResult> get(@PathVariable("id") Long id){
      return ApiResult.success(opLogService.get(id));
    }

    /**
     * 通过id删除一条记录
     * @param id
     * @return
     */
    @ApiOperation("根据ID删除")
    @DeleteMapping("/{id}")
    public ApiResult removeById(@PathVariable Long id){
      return ApiResult.success(opLogService.delete(id));
    }

}

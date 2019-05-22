package com.smart.log.center.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.log.center.param.OpLogParam;
import com.smart.log.center.param.OpLogQueryParam;
import com.smart.log.center.result.OpLogResult;
import com.smart.log.center.service.OpLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.smart.starter.core.model.*;


/**
 * 日志
 *
 * @author guwenchang
 * @date 2019-05-22 18:05:51
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/oplog")
public class OpLogController extends BaseController  {

  private final  OpLogService opLogService;

  /**
   * 简单分页查询
   * @param param
   * @return
   */
  @GetMapping("/page")
  public ApiResult<Page<OpLogResult>> page(@RequestBody OpLogQueryParam param) {
    Page<OpLogResult> page = getPage(param);
    opLogService.listPage(page,param);
    return ApiResult.success(page);
  }


  /**
   * 通过id查询单条记录
   * @param id
   * @return
   */
  @GetMapping("/{id}")
  public ApiResult<OpLogResult> get(@PathVariable("id") Long id){
    return ApiResult.success(opLogService.get(id));
  }

  /**
   * 新增记录
   * @param param
   * @return
   */
  @PostMapping
  public ApiResult save(@RequestBody OpLogParam param){
    return ApiResult.success(opLogService.save(param));
  }

  /**
   * 修改记录
   * @param param
   * @return
   */
  @PutMapping
  public ApiResult update(@RequestBody OpLogParam param){
    return ApiResult.success(opLogService.updateById(param));
  }

  /**
   * 通过id删除一条记录
   * @param id
   * @return
   */
  @DeleteMapping("/{id}")
  public ApiResult removeById(@PathVariable Long id){
    return ApiResult.success(opLogService.removeById(id));
  }

}

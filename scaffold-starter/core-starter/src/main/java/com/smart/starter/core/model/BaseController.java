package com.smart.starter.core.model;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
* 基础controller
* @author xiaobai
* @date 2017/10/30 11:54
**/
@Slf4j
public class BaseController {
	protected <T> Page<T> getPage(PageParam pageParam) {
		Page<T> page = new Page<T>(pageParam.getPageNo(), pageParam.getPageSize());
		if (page.getSize() > PageParam.MAX_PAGE_SIZE){
			page.setSize(PageParam.MAX_PAGE_SIZE);
		}
		page.setAsc(pageParam.getAscs());
		page.setDesc(pageParam.getDescs());
		return page;
	}


}

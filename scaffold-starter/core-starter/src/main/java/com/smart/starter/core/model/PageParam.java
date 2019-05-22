package com.smart.starter.core.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author guwenchang
 * @date 2019-05-22
 */
@Data
public class PageParam implements Serializable {

	private static final long serialVersionUID=1L;
	/**
	* 默认的最大的分页数
	*/
	public static final int MAX_PAGE_SIZE = 100;
	
	@ApiModelProperty("页码")
	private int pageNo = 1;

	@ApiModelProperty("每页记录数")
	private int pageSize = 20;

	@ApiModelProperty("升序字段数组")
	private String[] ascs;

	@ApiModelProperty("降序字段数组")
	private String[] descs;


}

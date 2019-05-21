package com.smart.starter.log.annotation;


import com.smart.starter.log.ConstantsLog;

import java.lang.annotation.*;

/**
 * 操作日志注解
 * @author guwenchang
 * @date 2019-04-28 16:34
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpLog {

	/**
	 * 描述
	 *
	 * @return {String}
	 */
	String value();

	/**
	 * 日志类型
	 *
	 * @return {String}
	 */
	String type() default ConstantsLog.OP;
}

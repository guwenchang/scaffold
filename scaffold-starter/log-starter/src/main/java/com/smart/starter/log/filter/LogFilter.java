package com.smart.starter.log.filter;


import com.smart.starter.log.util.RequestUtils;
import com.smart.starter.security.jwt.UserOperator;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 日志过滤器
 * @author guwenchang
 * @date 2019-04-24 10:45
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogFilter extends GenericFilterBean {

	@Override
	@SneakyThrows
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		log.debug("request:{}", RequestUtils.dump(httpServletRequest));

		filterChain.doFilter(request, response);
	}
}

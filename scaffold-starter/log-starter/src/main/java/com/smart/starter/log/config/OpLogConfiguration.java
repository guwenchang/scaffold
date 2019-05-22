package com.smart.starter.log.config;


import com.smart.starter.log.ConstantsLog;
import com.smart.starter.log.aspect.OpLogAspect;
import com.smart.starter.log.event.OpLogListener;
import com.smart.starter.log.filter.LogFilter;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.Resource;

/**
 * 日志自动配置类
 * @author guwenchang
 * @date 2019-04-29 14:10
 */
@EnableAsync
@ConditionalOnWebApplication
@AutoConfigureBefore(OpLogAutoConfiguration.class)
@Configuration
public class OpLogConfiguration{


	@Resource
	private RabbitTemplate rabbitTemplate;

	@Bean
	@ConditionalOnMissingBean
	public OpLogListener opLogListener() {
		return new OpLogListener(rabbitTemplate);
	}

	@Bean
	@ConditionalOnMissingBean
	public OpLogAspect opLogAspect() {
		return new OpLogAspect();
	}
	/**
	 * 请求过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean logFilterRegistration1() {
		//新建过滤器注册类
		FilterRegistrationBean registration = new FilterRegistrationBean();
		// 添加我们写好的过滤器
		registration.setFilter( new LogFilter());
		// 设置过滤器的URL模式
		registration.addUrlPatterns("/*");
		return registration;
	}

	@Bean
	public Queue opLogQueue() {
		// 第一个是 QUEUE 的名字,第二个是消息是否需要持久化处理
		return new Queue(ConstantsLog.OP_LOG_QUEUE, true);
	}
}

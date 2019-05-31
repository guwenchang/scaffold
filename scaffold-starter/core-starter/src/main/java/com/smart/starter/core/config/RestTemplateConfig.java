package com.smart.starter.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate config
 * @author guxiaobai
 * @date 2018/11/28 20:55
 */
@Configuration
public class RestTemplateConfig {
   @Bean
   public RestTemplate restTemplate() {
       return new RestTemplate();
   }
}

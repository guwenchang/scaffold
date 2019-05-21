package com.smart.starter.lock.config;

import com.smart.starter.lock.DefaultRedisKeyGenerator;
import com.smart.starter.lock.RedisKeyGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 *
 * @author guwenchang
 * @date 2019-04-29
 */
@Configuration
@ConditionalOnClass(RedisAutoConfiguration.class)
@RequiredArgsConstructor
public class RedisLockAutoConfiguration {


    private final StringRedisTemplate stringRedisTemplate;

    @Bean
    @ConditionalOnMissingBean
    public RedisLockHelper redisLockHelper() {
        return new RedisLockHelper(stringRedisTemplate);
    }

    @Bean
    @ConditionalOnMissingBean
    public RedisKeyGenerator redisKeyGenerator() {
        return new DefaultRedisKeyGenerator();
    }

    @Bean
    @ConditionalOnMissingBean
    public RedisLockAspect redisLockAspect() {
        return new RedisLockAspect(redisLockHelper(),redisKeyGenerator());
    }


}

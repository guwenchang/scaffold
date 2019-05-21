package com.smart.starter.lock.config;


import com.smart.starter.lock.RedisKeyGenerator;
import com.smart.starter.lock.annotation.RedisLock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 *
 * @author guwenchang
 * @date 2019-04-29
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
public class RedisLockAspect {
    private final RedisLockHelper redisLockHelper;
    private final RedisKeyGenerator redisKeyGenerator;


    @Around("@annotation(redisLock)")
    public Object interceptor(ProceedingJoinPoint pjp, RedisLock redisLock) {
        if (StringUtils.isEmpty(redisLock.prefix())) {
            throw new RuntimeException("lock key prefix don't null...");
        }
        final String lockKey = redisKeyGenerator.generate(redisLock.prefix(), redisLock.delimiter(), pjp);
        String value = UUID.randomUUID().toString();
        try {
            final boolean success = redisLockHelper.lock(lockKey, value, redisLock);
            log.debug("Redis lock key is [{}] and status is [{}]", lockKey, success);

            if (!success) {
                throw new RuntimeException(redisLock.message());
            }
            try {
                return pjp.proceed();
            } catch (Throwable throwable) {
                throw new RuntimeException("server exception");
            }
        } finally {
            redisLockHelper.unlock(lockKey, value);
        }
    }
}
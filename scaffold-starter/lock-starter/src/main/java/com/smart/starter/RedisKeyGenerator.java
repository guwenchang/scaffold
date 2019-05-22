package com.smart.starter;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author guwenchang
 * @date 2019-04-29
 */
public interface RedisKeyGenerator {

    String generate(String prefix, String delimiter, ProceedingJoinPoint pjp);
}
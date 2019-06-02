package com.baizhi.cache;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Aspect //声明当前类为一个切面 供容器读取
@Configuration
public class AnnotationCache {
    @Autowired
    RedisTemplate redisTemplate;

    @Around("@annotation(com.baizhi.annotation.AddCache)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("我在之前被切了");
        Object proceed = null;
        StringBuffer sb = new StringBuffer();
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String mothodName = proceedingJoinPoint.getSignature().getName();
        sb.append(mothodName);
        Object[] args = proceedingJoinPoint.getArgs();

        for (Object arg : args) {
            sb.append(arg.toString());
        }
        String s = sb.toString();
        HashOperations hashOperations = redisTemplate.opsForHash();
        Boolean aBoolean = hashOperations.hasKey(className, s);
        if (aBoolean) {
            proceed = hashOperations.get(className, s);
        } else {
            proceed = proceedingJoinPoint.proceed();
            hashOperations.put(className, s, proceed);
        }
        System.out.println("我在之后被切了");
        return proceed;
    }

    @After("@annotation(com.baizhi.annotation.DeleteCache)")
    public void after(JoinPoint joinPoint) {
        Object className = joinPoint.getTarget().getClass().getName();
        System.out.println(className);
        redisTemplate.delete(className);
        System.out.println("被切了。。。。。。。。");
    }
}

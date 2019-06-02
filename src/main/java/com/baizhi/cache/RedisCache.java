package com.baizhi.cache;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@Aspect
public class RedisCache {
    @Autowired
    RedisTemplate redisTemplate;
    /*@Autowired
    StringRedisTemplate stringRedisTemplate;*/
    /*@Around("execution(* com.baizhi.service.*.query*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        StringBuffer sb=new StringBuffer();
        System.out.println("核心功能执行之前");
        Object proceed =null;
       *//*Object target = proceedingJoinPoint.getTarget();
        System.out.println(target.toString());
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg.toString());
        }*//*
        String name = proceedingJoinPoint.getTarget().getClass().getName();
        sb.append(name);
        String name1 = proceedingJoinPoint.getSignature().getName();
        sb.append(name1);
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            sb.append(arg.toString());
        }
        ValueOperations valueOperations = redisTemplate.opsForValue();
 *//*       String kind = proceedingJoinPoint.getKind();
        System.out.println(kind);*//*
        String s = sb.toString();
        Boolean key = redisTemplate.hasKey(s);
        if(key){
           proceed=valueOperations.get(s);
        }else{
            proceed = proceedingJoinPoint.proceed();
            valueOperations.set(s,proceed);
        }
        System.out.println("核心功能执行之后");
        return proceed;
    }
    @After("execution(* com.baizhi.service.*.delete*(..))")
    public void after(JoinPoint joinPoint){
        Set<String> keys = stringRedisTemplate.keys("*");
        for (String key : keys) {
            System.out.println(key);
            stringRedisTemplate.delete(key);
        }
    }*/


}

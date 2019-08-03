package com.example.gateway.service.cache;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by JiWen on 2019/7/27 at Home.
 */
@Aspect
@Component
@Slf4j
public class ServiceCacheHandler {

    @Pointcut("@annotation(com.example.gateway.service.cache.ServiceCache)&&@annotation(serviceCache)")
    public void cache(ServiceCache serviceCache) {
    }

    @Around(value = "cache(serviceCache)")
    public Object handleCache(ProceedingJoinPoint joinPoint, ServiceCache serviceCache) {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        String key = signature.toString() + JSONObject.toJSONString(args);
        log.info("loading cache {}", key);
        return CacheUtil.getCache(key, () -> {
            try {
                log.info("loading database {}", key);
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                log.error("执行方法{} 发生异常", joinPoint.getSignature(), throwable);
            }
            return null;
        });
    }
}

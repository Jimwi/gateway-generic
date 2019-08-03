package com.example.gateway.service.cache;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by JiWen on 2019/7/27 at Home.
 */
@Slf4j
public class CacheUtil {

    private static Cache<Object, Object> dbCache = CacheBuilder.newBuilder().maximumSize(5000).expireAfterWrite(1, TimeUnit.MINUTES).build();

    @SuppressWarnings("unchecked")
    public static <K, V> V getCache(K k, Callable<V> cable) {
        try {
            return (V) dbCache.get(k, cable);
        } catch (Throwable t) {
            log.error("guava 缓存发生错误", t);
        }
        return null;
    }
}

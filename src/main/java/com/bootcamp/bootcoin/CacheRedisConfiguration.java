package com.bootcamp.bootcoin;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheRedisConfiguration {

    public CacheManager getCache(){
        return new ConcurrentMapCacheManager("type-change");
    }
}

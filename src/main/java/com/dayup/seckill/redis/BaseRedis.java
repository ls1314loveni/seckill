package com.dayup.seckill.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public abstract class BaseRedis<T> {

    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;

    protected HashOperations<String, String, T> hashOperations;

    abstract String getRedisKey();

    public void put(String key, T domain, long expire) {
        hashOperations.put(getRedisKey(), key, domain);
        if (expire != -1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }
}

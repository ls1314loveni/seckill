package com.dayup.seckill.redis;

import com.dayup.seckill.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserReids extends BaseRedis<User>{

    private static final String REDIS_KEY = "com.dayup.seckill.redis.UserRedis";

    @Override
    String getRedisKey() {
        return REDIS_KEY;
    }
}

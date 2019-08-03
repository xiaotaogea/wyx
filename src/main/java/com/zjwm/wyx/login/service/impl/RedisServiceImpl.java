package com.zjwm.wyx.login.service.impl;

import com.zjwm.wyx.login.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 王俊涛
 * @date: 2019/8/3 17:14
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value, 300, TimeUnit.SECONDS);//5分钟过期
    }

    @Override
    public String getValue(String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

}

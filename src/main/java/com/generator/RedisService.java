package com.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RedisService {
    private final RedisTemplate<String, String> redisTemplate;
    private static final String SET_KEY = "tracking_numbers";

    @Autowired
    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public synchronized String insertUniqueValue() {
        String newValue = UUID.randomUUID().toString();
        redisTemplate.opsForValue().setIfAbsent(SET_KEY, newValue);
        return newValue;
    }
}
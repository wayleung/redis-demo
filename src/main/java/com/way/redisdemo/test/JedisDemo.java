package com.way.redisdemo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
public class JedisDemo {
    @Autowired
    JedisPool jedisPool = new JedisPool();

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    Jedis jedis = jedisPool.getResource();

    @GetMapping("/{key}")
    public String getValue(@PathVariable(value = "key") String key){
        return jedis.get(key);
    }


    @PostMapping("/{key}/{value}")
    public String setValue(@PathVariable(value = "key") String key,@PathVariable(value = "value") String value){
        String result = jedis.set(key, value);
        return result;
    }


}

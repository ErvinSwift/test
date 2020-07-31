package com.yingxue.lesson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
    @Autowired
    private JedisPool jedisPool;

    public boolean exists(String key){
        Jedis jedis = null;
        boolean result;
        try{
            jedis = jedisPool.getResource();
            result = jedis.exists(key);
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }

       return result;
    }
    public Long del(String... keys){
        Jedis jedis = null;
        Long result;
        try{
            jedis = jedisPool.getResource();
            result = jedis.del(keys);
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return  result;

    }

}

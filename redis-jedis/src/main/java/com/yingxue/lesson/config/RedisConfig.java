package com.yingxue.lesson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
@Configuration
public class RedisConfig
{
    @Value("${redis.maxIdle}")
    private int maxIdle;
    @Value("${redis.minIdle}")
    private int minIdle;
    @Value("${redis.maxTotal}")
    private int maxTotal;
    @Value("${redis.timeout}")
    private int timeout;
    @Value("${redis.maxWait}")
    private int maxWait;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.host}")
    private String host;
    @Bean
    public JedisPool jedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        jedisPoolConfig.setMaxTotal(maxTotal);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout);
        return jedisPool;
    }

}

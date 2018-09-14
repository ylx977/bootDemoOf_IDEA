package com.fuzamei.config.jedis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author lingjun.jlj
 * @create 2017-11-28
 **/
@Configuration
@EnableCaching // 启用缓存，这个注解很重要
public class RedisConfig extends CachingConfigurerSupport {

    private int maxIdle = 20;

    private int minIdle = 20;

    private long maxWaitTimeout = 5000L;

    private int maxTotal = 20;

    private int database = 1;

    private String host = "172.16.100.24";

    private int port = 6379;

    private String password = "d1igtHT/TnsE";

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setBlockWhenExhausted(true);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setFairness(false);
        jedisPoolConfig.setMaxWaitMillis(maxWaitTimeout);
        jedisPoolConfig.setMaxTotal(maxTotal);
        return jedisPoolConfig;
    }

    @Bean
    public JedisPool jedisPool(){
        return new JedisPool(jedisPoolConfig(), host, port, (int)maxWaitTimeout, password, database);
    }

}

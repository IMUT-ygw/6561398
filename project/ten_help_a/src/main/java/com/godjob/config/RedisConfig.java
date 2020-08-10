package com.godjob.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/26 10:02
 */
@Configuration
public class RedisConfig {
    //redis配置序列化
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
            RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object, Object>();
            redisTemplate.setConnectionFactory(redisConnectionFactory);
            RedisSerializer<Object> redisSerializer =new Jackson2JsonRedisSerializer<Object>(Object.class);
            redisTemplate.setDefaultSerializer(redisSerializer);
            return redisTemplate;
    }
}

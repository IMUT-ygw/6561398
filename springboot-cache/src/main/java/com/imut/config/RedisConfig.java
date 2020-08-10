package com.imut.config;

import com.imut.pojo.User;
import com.imut.redis.KillServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.net.UnknownServiceException;
import java.time.Duration;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/23 20:01
 */
@Configuration
public class RedisConfig {

//    @Bean
//    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object,Object>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        RedisSerializer<Object> redisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        redisTemplate.setDefaultSerializer(redisSerializer);
//        return redisTemplate;
//    }

    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, User> redisTemplate = new RedisTemplate<Object, User>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        RedisSerializer<User> redisSerializer = new Jackson2JsonRedisSerializer<User>(User.class);
        redisTemplate.setDefaultSerializer(redisSerializer);
        return redisTemplate;
    }


//    //缓存管理器
////    @Primary
////    @Bean
////    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
////        RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig()
////                .entryTtl(null);
////        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
////                .cacheDefaults(redisCacheConfiguration).build();
////    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ServletRegistrationBean registrationBean){
            ServletRegistrationBean bean = new ServletRegistrationBean(new KillServlet(),"/kill");
            return bean;
    }

}

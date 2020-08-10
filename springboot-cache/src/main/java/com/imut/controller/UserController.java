package com.imut.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.imut.mapper.UserMapper;
import com.imut.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/22 15:57
 */
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate<Object,User> userRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @GetMapping("/findAll")
    public String findAll(){
        //查询缓存
        User users = (User) userRedisTemplate.opsForValue().get("allUserUserFindAll_01");
        if(users ==null){
            users = userMapper.findAll();
            userRedisTemplate.opsForValue().set("allUserUserFindAll_01",users);
        }
        return JSON.toJSON(users).toString();
    }

    @GetMapping("/findAll2")
    public String findAll2(){
        RedisSerializer serializable = new Jackson2JsonRedisSerializer(Object.class);
        redisTemplate.setValueSerializer(serializable);
        //查询缓存
        User users = (User)redisTemplate.opsForValue().get("allUserFindAll_02");
        if(users ==null){
            users = userMapper.findAll();
            redisTemplate.opsForValue().set("allUserFindAll_02",users);
        }
        return JSON.toJSON(users).toString();
    }

}

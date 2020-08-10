package com.imut.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * @author nmtl_ygw
 * @Description
 * @date 20/7/2020 下午 5:54
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
        return new RandomRule(); //ribbon 负载均衡策略 变为随机
    }
}

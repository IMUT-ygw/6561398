package com.imut.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author nmtl_ygw
 * @Description
 * @date 12/7/2020 上午 8:26
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //因为自己写负载均衡算法，所以去掉该注解
    //@LoadBalanced //负载均衡（没有这个注解 直接使用注册中心的提供者集群会报错）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

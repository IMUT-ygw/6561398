package com.imut.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author nmtl_ygw
 * @Description
 * @date 24/7/2020 上午 8:44
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //服务类出现服务降级注解，启动类要加这个注解
public class HystrixPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001.class,args);
    }
}

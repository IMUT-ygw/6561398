package com.imut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author nmtl_ygw
 * @Description
 * @date 11/7/2020 下午 3:51
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableEurekaClient 只支持Eureka注册中心，@EnableDiscoveryClient 支持Eureka、Zookeeper、Consul 这三个注册中心。
@EnableDiscoveryClient
public class PaymentMain8081 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8081.class,args);
    }
}

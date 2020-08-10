package com.imut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author nmtl_ygw
 * @Description
 * @date 11/7/2020 下午 3:51
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8082 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8082.class,args);
    }
}

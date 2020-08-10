package com.imut.springcloud;

import com.imut.springcloud.entities.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author nmtl_ygw
 * @Description
 * @date 14/7/2020 下午 9:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain80 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain80.class,args);
    }
}

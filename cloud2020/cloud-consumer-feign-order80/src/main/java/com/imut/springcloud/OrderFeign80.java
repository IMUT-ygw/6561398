package com.imut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author nmtl_ygw
 * @Description
 * @date 23/7/2020 下午 4:24
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80.class,args);
    }
}

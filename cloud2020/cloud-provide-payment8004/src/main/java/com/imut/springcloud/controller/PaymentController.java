package com.imut.springcloud.controller;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author nmtl_ygw
 * @Description
 * @date 14/7/2020 下午 5:20
 */
@RestController
@Slf4j
public class PaymentController {
    private String serverPort = "8004";

    @GetMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper："+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}

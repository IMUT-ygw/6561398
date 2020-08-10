package com.imut.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author nmtl_ygw
 * @Description
 * @date 14/7/2020 下午 9:15
 */
@RestController
@Slf4j
public class OrderZKController {
    public final String URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/zk")
    public String payment(){
        String result  = restTemplate.getForObject(URL+"/payment/zk",String.class);
        return result;
    }
}

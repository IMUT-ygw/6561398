package com.imut.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author nmtl_ygw
 * @Description
 * @date 15/7/2020 下午 3:44
 */
@RestController
@Slf4j
public class PaymentConsulController {
    public static final String INVOKE_URL = "http://consul-provider-peyment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
}

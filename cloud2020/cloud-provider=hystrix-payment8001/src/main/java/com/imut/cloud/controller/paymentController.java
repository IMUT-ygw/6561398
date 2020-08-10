package com.imut.cloud.controller;

import com.imut.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author nmtl_ygw
 * @Description
 * @date 24/7/2020 上午 9:15
 */
@RestController
@Slf4j
public class paymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_error(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_error(id);
        log.info("******result" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_ok(id);
        log.info("******result" + result);
        return result;
    }
}

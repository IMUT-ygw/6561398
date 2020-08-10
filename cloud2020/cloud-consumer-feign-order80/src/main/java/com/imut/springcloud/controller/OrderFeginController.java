package com.imut.springcloud.controller;

import com.imut.springcloud.entities.CommonResult;
import com.imut.springcloud.entities.Payment;
import com.imut.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nmtl_ygw
 * @Description
 * @date 23/7/2020 下午 4:49
 */
@RestController
@Slf4j
public class OrderFeginController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    //使用feign调用提供者，通过此接口调用service的feign的接口类
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getId(id);
    }
}

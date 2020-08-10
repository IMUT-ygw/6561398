package com.imut.cloud.service;

import com.imut.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author nmtl_ygw
 * @Description
 * @date 24/7/2020 上午 10:40
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallBackService.class)
public interface FeignHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_error(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);
}

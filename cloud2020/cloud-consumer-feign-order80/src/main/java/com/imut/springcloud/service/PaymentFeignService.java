package com.imut.springcloud.service;

import com.imut.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author nmtl_ygw
 * @Description
 * @date 23/7/2020 下午 4:46
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")//实例名
public interface PaymentFeignService {

    //此方法时服务端提供的方法
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getId(@PathVariable("id") Long id);
}

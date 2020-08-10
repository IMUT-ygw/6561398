package com.imut.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author nmtl_ygw
 * @Description  集成引用8001的服务接口类，并实现，这个类放置8001宕机而搭建的服务降级
 * @date 7/8/2020 下午 5:06
 */
@Component
public class PaymentFallBackService implements FeignHystrixService {
    @Override
    public String paymentInfo_error(Integer id) {
        return "---------------error";
    }

    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------------ok";
    }
}

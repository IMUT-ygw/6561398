package com.imut.cloud.controller;

import com.imut.cloud.service.FeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author nmtl_ygw
 * @Description
 * @date 24/7/2020 上午 10:46
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") //如果不指定单独的降级方法默认使用全局降级方法
public class OrderController {
    @Autowired
    private FeignHystrixService feignHystrixService;

    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "errorMethod", commandProperties = {
            //客户端服务1.5s后服务降级
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String paymentInfo_error(@PathVariable("id") Integer id){
        int i = 10/0;
        String result = feignHystrixService.paymentInfo_error(id);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout01/{id}")
    @HystrixCommand  //没指定具体降级方法就会使用全局降级方法
    public String paymentInfo_error_global(@PathVariable("id") Integer id){
        int i = 10/0;
        String result = feignHystrixService.paymentInfo_error(id);
        return result;
    }
    //兜底服务 除了方法名不同其他都要相同
    public String errorMethod(@PathVariable("id") Integer id){
        return "客户端服务降级~~~   error~~~~~";
    }


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = feignHystrixService.paymentInfo_OK(id);
        return result;
    }

    public String payment_Global_FallbackMethod(){
        return "全局降级方法";
    }
}

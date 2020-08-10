package com.imut.springcloud.controller;

import com.imut.springcloud.entities.CommonResult;
import com.imut.springcloud.entities.Payment;
import com.imut.springcloud.service.impl.PaymentImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author nmtl_ygw
 * @Description
 * @date 11/7/2020 下午 4:26
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentImpl paymentImpl ;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int creat = paymentImpl.create(payment);
        log.info("********插入结果：" + creat + " asdasdsaasdadsadsa");
        if(creat > 0){
            return new CommonResult(200,"插入数据库成功" + serverPort,creat);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getId(@PathVariable("id") Long id){
        Payment byId = paymentImpl.getById(id);
        log.info("********插入结果：" + byId);
        if(byId != null){
            return new CommonResult(200,"查询成功" + serverPort,byId);
        }else{
            return new CommonResult(444,"查询失败，没有对应记录，查询id:"+id,null);
        }
    }

    @GetMapping("/payment/lb")
    public String m2(){
        return serverPort;
    }

}

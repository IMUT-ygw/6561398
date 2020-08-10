package com.imut.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author nmtl_ygw
 * @Description
 * @date 15/7/2020 下午 3:36
 */
@RestController
@Slf4j
public class ConsulController {

    @GetMapping("/payment/consul")
    public String method(){
        return "springcloud consul" + UUID.randomUUID().toString();
    }
}

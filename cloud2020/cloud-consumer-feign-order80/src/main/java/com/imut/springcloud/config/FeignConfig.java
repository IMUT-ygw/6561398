package com.imut.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author nmtl_ygw
 * @Description
 * @date 23/7/2020 下午 5:20
 */
@Configuration
public class FeignConfig {
    //feign的日志级别
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}

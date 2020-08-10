package com.imut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/19 10:23
 */
@MapperScan(value = {"com.imut.mapper"})
@SpringBootApplication
//扫面servlet组件注解
@ServletComponentScan
public class UpLoadImageApplication {
    public static void main(String[] args) {
        SpringApplication.run(UpLoadImageApplication.class, args);

    }
}

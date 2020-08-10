package com.godjob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.godjob.mapper"})
public class TenHelpAApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenHelpAApplication.class, args);
    }

}

package com.imut.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = {"classpath:bean.xml"})  导入spring配置文件
@SpringBootApplication
public class SpringbootYgwApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootYgwApplication.class, args);
    }

}

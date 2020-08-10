package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 9:05
 */
@RestController
@EnableConfigurationProperties({User.class})
public class UserController {

    @Autowired
    User user;

    @GetMapping("/666")
    public String test(){
        System.out.println(user);
        return "success";
    }
}

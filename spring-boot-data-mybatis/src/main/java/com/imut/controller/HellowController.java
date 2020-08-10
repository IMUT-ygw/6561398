package com.imut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/19 16:32
 */
@Controller
public class HellowController {
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}

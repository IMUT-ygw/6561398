package com.imut.springboot.controller;

import com.imut.springboot.pojo.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/4 19:46
 */
@Controller
public class HelloController {


    @RequestMapping("/success")
    public String getMethod(Map<String,Object> map){
        Car c = new Car();
        c.setName("hhh");
        c.setMoney(11111);
        map.put("name","<h1>ygw</h1>");
        map.put("list", Arrays.asList(1,2,3,4,5));
        map.put("car",c);
        return "success" ;
    }


}

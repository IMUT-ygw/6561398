package com.imut.controller;

import com.imut.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/16 21:11
 */
@Controller
public class PersonController {


        @GetMapping("/person")
        @ResponseBody
        public String test1(Person p){
            System.out.println("处理完毕");
            return p.toString();
        }


        @PostMapping("/person1")
        @ResponseBody
         public String  test1( String  name){
        System.out.println("处理完毕");
        return name;
    }




}

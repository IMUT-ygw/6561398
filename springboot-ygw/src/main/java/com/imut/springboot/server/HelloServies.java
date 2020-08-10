package com.imut.springboot.server;

import com.imut.springboot.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/4 20:09
 */
public class HelloServies {
    @Autowired
    Person person;
    public void method(){
        System.out.println(person);
    }
}

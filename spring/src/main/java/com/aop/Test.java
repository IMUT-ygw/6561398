package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/11 21:17
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext aop = new ClassPathXmlApplicationContext("aop.xml");
        MathI mathI = aop.getBean( MathImpl.class);
        mathI.m3(1,2);
    }
}

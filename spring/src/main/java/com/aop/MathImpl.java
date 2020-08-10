package com.aop;


import org.springframework.stereotype.Component;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/11 21:08
 */
@Component
public class MathImpl implements MathI {
    @Override
    public void m1(int i,int j) {
        int m = 1/0;
        System.out.println("+");

    }

    @Override
    public void m2(int i,int j) {
        System.out.println("-");
    }

    @Override
    public void m3(int i,int j) {
        System.out.println("*");
    }

    @Override
    public void m4(int i,int j) {
        System.out.println("/");
    }
}

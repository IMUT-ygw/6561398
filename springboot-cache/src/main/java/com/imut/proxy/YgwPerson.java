package com.imut.proxy;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/24 15:32
 */
public class YgwPerson implements Person {
    public String name;

    public YgwPerson(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("吃");
    }

    @Override
    public void sleep() {
        System.out.println("睡");
    }
}

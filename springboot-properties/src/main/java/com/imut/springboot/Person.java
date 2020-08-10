package com.imut.springboot;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/5 15:21
 */
public class Person {
    private static String name = "ygw";
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(Person.name);
    }
    private static void method(){
        String name = "aaa";
    }


}

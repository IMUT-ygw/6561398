package com.imut.cglibProxy;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/29 16:02
 */
public class Demo {
    public static void main(String[] args) {
        UserService u = new UserService();
        CgProxy proxy = new CgProxy(u);
        UserService p =(UserService) proxy.getProxy();
        p.hello();

    }
}

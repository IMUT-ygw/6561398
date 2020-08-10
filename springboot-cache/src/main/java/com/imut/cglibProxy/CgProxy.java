package com.imut.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/29 15:57
 */
public class CgProxy implements MethodInterceptor {
    private UserService userService;
    public CgProxy(UserService userService){
        this.userService = userService;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强前");
        Object invoke = method.invoke(userService, objects);
        System.out.println("增强后");
        return null;
    }
    public Object getProxy(){
        Enhancer en = new Enhancer();
        en.setSuperclass(userService.getClass());
        en.setCallback(this);
        return en.create();
    }
}

package com.imut.proxy;

import javafx.beans.InvalidationListener;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/24 15:33
 */
public class StartProxy implements InvocationHandler {
    private Object ygwPerson;

    public StartProxy(Object ygwPerson) {
        this.ygwPerson = ygwPerson;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(ygwPerson, args);
        System.out.println("方法增强");
        return invoke;
    }

//    public Object createProxyObj(){
//        return Proxy.newProxyInstance(ygwPerson.getClass().getClassLoader(),ygwPerson.getClass().getInterfaces(),this);
//    }
}

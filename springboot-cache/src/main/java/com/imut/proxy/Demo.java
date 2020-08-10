package com.imut.proxy;

import java.lang.reflect.Proxy;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/24 15:47
 */
public class Demo {
    public static void main(String[] args) {
        Person y = new YgwPerson("ygw");
        StartProxy startProxy = new StartProxy(y);
        Person o = (Person) Proxy.newProxyInstance(y.getClass().getClassLoader(), y.getClass().getInterfaces(), startProxy);
        o.eat();
        o.sleep();

//        Object person = Proxy.newProxyInstance(y.getClass().getClassLoader(),y.getClass().getInterfaces(),((proxy, method, args1) ->
//        {
//            if (method.getName().equals("eat")){
//                System.out.println("方法增强！");
//                return method.invoke(y,args1);
//            }
//            return null;
//        }));
//        Person person1 = (Person) person;
//        person1.eat();
//        person1.sleep();
//    }
    }
}

package com.imut;

import com.imut.domain.Student;
import com.imut.server.SelectInfo;
import com.imut.server.UpdateInfo;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.support.ManagedMap;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/18 9:34
 */
public class Demo {
//    public static void main(String[] args) {
//        SelectInfo selectInfo = new SelectInfo();
//        UpdateInfo updateInfo = new UpdateInfo();
//        //查找全部
//        List<Student> all = selectInfo.findAll();
//        System.out.println("查找全部："+all.get(0));
//        //根据id查找
//        Student byId = selectInfo.findById(2017202001);
//        System.out.println("根据id查找"+byId);
//        //插入数据
//        Integer integer = updateInfo.insertInfo(2017202005, "袁国伟", 21, 0, "软件17-1", "内蒙古呼和浩特");
//        System.out.println("影响条数:" + integer);
//
//        //根据id删除
//        Integer delete = updateInfo.delete("2017202002");
//        System.out.println("影响条数:" + delete);
//    }
public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Class<?> aClass = Class.forName("com.imut.server.UserService");

    //获取构造器
    Constructor<?> constructors = aClass.getConstructor(String.class, String.class); //共有
    Object o = constructors.newInstance("袁国伟", "男");
    Constructor<?> constructors2 = aClass.getDeclaredConstructor();
    constructors2.setAccessible(true);
    Object o1 = constructors2.newInstance();
    System.out.println(o1.toString());
    System.out.println(o.toString());

    //获取方法
    Method getData = aClass.getMethod("getData",String.class);
    getData.invoke(o,"ygw");

    HashMap<String,String> map = new HashMap<>();
    map.put("ygw","123");
    map.put("ygw1","1234");

    Set<String> strings = map.keySet();
    Iterator it = strings.iterator();
    while(it.hasNext()){
        Object key = it.next();
        Object value = map.get(key);
        System.out.println(key + " " + value);
    }

    Set<Map.Entry<String, String>> entries = map.entrySet();
    Iterator its = entries.iterator();
    while (its.hasNext()){
        Map.Entry me = (Map.Entry) its.next();
        System.out.println(me.getKey()+" " + me.getValue());
    }
}

}

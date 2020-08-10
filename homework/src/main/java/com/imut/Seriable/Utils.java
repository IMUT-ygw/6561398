package com.imut.Seriable;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/25 19:22
 */
public class Utils {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person();
        p.setAge(23);
        p.setName("袁国伟");

        on(p);
        off();
    }
    public static void on(Person person) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("f://a.txt")));
        oos.writeObject(person);

        System.out.println("序列化成功！");
    }
    public static Object off() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("f://a.txt")));
        Person object = (Person) ois.readObject();
        System.out.println(object);
        System.out.println("反序列化成功");
        return object;
    }

}

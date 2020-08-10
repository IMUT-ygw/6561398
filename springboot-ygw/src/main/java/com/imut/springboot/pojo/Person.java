package com.imut.springboot.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

/**
 * 加载到spring容器中
 */
@Component
@PropertySource(value = {"classpath:application.yml"})
/**
 * 读取主配置文件 依次将值注入到属性
 */
@ConfigurationProperties(prefix = "person")
/**
 * 属性需要校验  只支持在配置文件中 @Value不支持校验
 */
//@Validated
public class Person {
    private String name;
    private int age;
    private List<String> list;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", date=" + date +
                '}';
    }
}

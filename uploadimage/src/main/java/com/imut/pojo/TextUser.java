package com.imut.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/13 10:12
 */
@Component
@PropertySource(value = {"/application.properties"})
@ConfigurationProperties(prefix = "text")
public class TextUser {
    String name;
    Integer age;

    public TextUser() {
    }

    public TextUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TextUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

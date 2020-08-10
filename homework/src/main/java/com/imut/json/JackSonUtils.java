package com.imut.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imut.Seriable.Person;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/25 20:20
 */
public class JackSonUtils {
    private static Object List;

    public static void main(String[] args) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);//忽略有默认值的属性
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//忽略json中存在对象中不存在的属性
        Person person = new Person();
        person.setName("袁国伟");
        person.setAge(23);
        String string = om.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(string);


        String jsonArray ="[{\"username\":\"刘佳丽\",\"age\":\"21\",\"lll\":\"asd\"},{\"username\":\"猪猪\",\"age\":\"20\",\"lll\":\"asd\"}]";
        List<Person> person1 = om.readValue(jsonArray,new TypeReference<List<Person>>() {});
        for (Person p:person1) {
            System.out.println(p);
        }


    }
}

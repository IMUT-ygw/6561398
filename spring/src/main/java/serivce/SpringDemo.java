package serivce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Person;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/15 8:47
 */


public class SpringDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        Object bean = ioc.getBean("person");
        System.out.println(bean);
        ioc.close();
    }
}
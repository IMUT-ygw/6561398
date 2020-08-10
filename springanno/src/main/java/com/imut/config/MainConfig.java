package com.imut.config;
import com.imut.condition.LinuxCondition;
import com.imut.condition.MyImportBeanRegistrar;
import com.imut.condition.MyImportSelector;
import com.imut.condition.WindowsCondition;
import com.imut.pojo.MyFactorBean;
import com.imut.service.DemoService;
import org.springframework.context.annotation.*;
import com.imut.pojo.Person;
import org.springframework.stereotype.Controller;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/22 20:38
 */
@Configuration
//@ComponentScan(value = "com.imut",excludeFilters =
//        {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class})})   //排除
@ComponentScan(value = "com.imut",
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class})}
//        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})}
        ,useDefaultFilters = false)
//快速注册的类
@Import({MyImportSelector.class, MyImportBeanRegistrar.class})
public class MainConfig {

    /**
     * prototype 多例的  主动使用才会创建
     * singleton 单例的（默认值） ioc容器启动则实例创建
     * request  同一次请求创建一个实例
     * session 统一个session创建一个实例
     *
     * 懒加载：
     *      单例模式下，默认情况下随着ioc的创建对象也会创建，懒加载则ioc容器创建时不会加载，用的时候加载
     */
    @Scope("singleton")
    @Lazy
    @Bean
    public Person person(){
        System.out.println("加载实例");
        return new Person("a",1);
    }

    /**
     * Condition注解可以使用在类上或方法上
     *  判断方式在condition包下类中
     */
    @Conditional({WindowsCondition.class})
    @Bean("windows")
    public Person person0(){
        System.out.println("加载实例");
        return new Person("windows",1);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linux")
    public Person person1(){
        System.out.println("加载实例");
        return new Person("linux",1);
    }

    @Bean
    public MyFactorBean myFactorBean(){
        return new MyFactorBean();
    }
}

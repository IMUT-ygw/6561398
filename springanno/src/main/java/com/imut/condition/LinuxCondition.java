package com.imut.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


import java.lang.annotation.Annotation;

/**
 * @author nmtl_ygw
 * @Description 判断是否Linux系统
 * @date 2020/4/27 19:41
 */
public class LinuxCondition  implements Condition {

    /**
     *
     * @param conditionContext  判断条件
     * @param annotatedTypeMetadata 注释信息
     * @return
     *
     * Condition注解可以根据判断条件所持有的内容进行容器的加载或进行类的加载，因为注解放置的位置不同
     * 放置在方法上，满足条件才会加载方法或bean被加载
     * 如果放置在类上，满足条件后才会加载类中所有方法或bean
     * Condition注解括号内是数组形式 需要加大括号，里面放条件类名.class
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取bean的创建工厂
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");
        if(property.contains("Linux")){
            return true;
        }
        return false;
    }
}

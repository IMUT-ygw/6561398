package com.imut.condition;

import com.imut.pojo.QuickModule;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/28 9:35
 */
public class MyImportBeanRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *  此类用于快速注册组件
     * @param annotationMetadata  当前类的注解信息
     * @param beanDefinitionRegistry  bean定义的注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //判断容器中是否包含quick01的bean
        boolean quick01 = beanDefinitionRegistry.containsBeanDefinition("com.imut.pojo.Quick01");
        //注册方法
        if(quick01){
            //将组件通过RootBeanDefinition类
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(QuickModule.class);
            beanDefinitionRegistry.registerBeanDefinition("quickModule",rootBeanDefinition);
        }

    }
}

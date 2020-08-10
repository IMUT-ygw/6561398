package com.imut.pojo;

/**
 * @author nmtl_ygw
 * @Description  快速导入组件
 * @date 2020/4/27 20:03
 */
public class QuickModule {
    /**
     * 导入组件最常见的就是在配置类中利用@Bean注解，不过这种方式比较复杂
     *  快速导入组件：
     *      1、在配置类上@Improt(类名.class)
     *      2、ImportSelector :返回需要导入的去全类名数组
     *      3、ImportBeanDefinitionRegistrar
     *      4、工厂bean 实现FactoryBean<Bean.class> 重写三个方法
     *      需要在配置类中添加改工厂的bean 获取该类类型为实体类类型，想要获取工厂类本身
     *      需要在获取类名前加‘&’
     */
}

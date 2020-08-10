package com.imut.springboot.config;

import com.imut.springboot.server.HelloServies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/4 20:16
 */
@Configuration
public class HelloConfig  {

    /**
     * bean 将返回值添加到容器中  组件的id名  默认就是方法名
     * <bean id = "helloServies"  class = "com.imut.springboot.server.HelloServies"></bean>
     * @return
     */
//    @Bean
//    public HelloServies helloServies(){
//        System.out.println("配置类给bean添加组件了");
//        return new HelloServies();
//    }


}

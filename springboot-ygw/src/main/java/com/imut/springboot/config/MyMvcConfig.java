package com.imut.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/18 10:02
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //发送请求到达指定页面
        registry.addViewController("/6666").setViewName("success");
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index.html").setViewName("index");
    }
    @Bean
    public WebMvcConfigurer webMvcConfigurationSupport(){
        WebMvcConfigurer WebMvcConfigurer = new WebMvcConfigurer(){
                @Override
                public void addViewControllers(ViewControllerRegistry registry) {
                    registry.addViewController("/").setViewName("index");
                    registry.addViewController("/index.html").setViewName("index");
                }
            };
            return WebMvcConfigurer;
    }
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/templates/");
//    }
}

package com.imut.config;

import com.imut.component.LoginHandlerInterceptor;
import com.imut.component.MyLocaleResolver;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/18 11:37
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
            }

//            //注册拦截器  SpringBoot已经处理好静态资源映射
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                    //拦截所有请求，不包含index.html  springboot已经做好静态资源映射
//                    registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                            .excludePathPatterns("/index.html","/","/login");
//            }


        };
        return webMvcConfigurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}

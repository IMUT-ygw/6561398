package com.example.demo.config;

import com.example.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Servlet;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 10:09
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean((Servlet) new MyServlet(),"/myServlet");
        return servletRegistrationBean;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}

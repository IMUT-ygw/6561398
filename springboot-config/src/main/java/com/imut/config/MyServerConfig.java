package com.imut.config;

import com.imut.filter.MyFilter;
import com.imut.listener.MyListener;
import com.imut.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


import java.util.Arrays;


/**
 * @author nmtl_ygw
 * @Description  服务器的配置类
 * @date 2020/4/22 13:43
 */
@Configuration
public class MyServerConfig  {

    /**
     * 注册三大组件
     */

    @Bean
    public ServletRegistrationBean myServlet(){
        //注册Servlet
        ServletRegistrationBean servletServletRegistrationBean =
                new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return servletServletRegistrationBean;

    }

    @Bean
    public FilterRegistrationBean myFilter(){
        //注册filter
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        //注册监听器
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<MyListener>();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }


    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            //配置嵌入式servlet容器
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8081);
            }
        };
    }




}

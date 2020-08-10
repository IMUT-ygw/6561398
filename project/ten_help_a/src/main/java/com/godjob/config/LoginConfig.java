package com.godjob.config;

import com.godjob.component.LoginHandleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 16:55
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    /**
//     *  登录拦截器
//     */
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/get");
////    }

    /**
     *  并发请求拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/ha");
    }

    /**
     * 视图映射
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("success");
    }
}

package com.imutdata.springbootdata.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.sun.javafx.collections.MappingChange;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/24 11:54
 */
@Configuration

public class DruidConfig {
    /**
     *引入配置文件的设置
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource") //讲配置文件中的值与类中属性进行一一对应的赋值
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }


    //配置druid的监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet());
         HashMap<String,String> initParams = new HashMap<String,String>();
         //进入druid监控页面的默认值
         initParams.put("loginUsername","admin");
         initParams.put("loginPassword","123456");
         initParams.put("allow","*");  //ip白名单
        // initParams.put("deny",""); //ip黑名单（优先于白名单）
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        bean.addInitParameter("exclusions","*.js,*.css,/druid/*");
        bean.addUrlPatterns("/*");
        return bean;
    }


}

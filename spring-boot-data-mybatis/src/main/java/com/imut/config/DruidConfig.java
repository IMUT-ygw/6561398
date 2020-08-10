package com.imut.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/15 9:15
 */
@Configuration
public class DruidConfig {
    @Autowired
    DataSource dataSource;

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }


//    //配置druid数据源监听
////    @Bean
////    public ServletRegistrationBean statViewServlet(){
////        ServletRegistrationBean bean =new ServletRegistrationBean(new StatViewServlet());
////        HashMap<String,String> map = new HashMap<>();
////        map.put("loginUsername","admin");
////        map.put("loginPassword","123456");
////        bean.setInitParameters(map);
////        return bean;
////    }

//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
//        bean.addInitParameter("exclusions","*.js,*.css,/druid/*");
//        bean.addUrlPatterns("/*");
//        return  bean;
//    }
}

package com.imut.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/22 13:59
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized ... web 已启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("当前web项目销毁！");
    }
}

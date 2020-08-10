package com.godjob.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author nmtl_ygw
 * @Description  登录检查
 * @date 2020/6/8 17:02
 */
public class LoginHandleInterceptor implements HandlerInterceptor {

    //并发请求拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Thread.sleep(1000);
        return true;
    }
}

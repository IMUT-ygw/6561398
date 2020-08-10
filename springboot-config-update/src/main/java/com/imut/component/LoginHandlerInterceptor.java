package com.imut.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nmtl_ygw
 * @Description 登录检查
 * @date 2020/4/18 19:54
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在请求域中设置一个session，根据session判断是否登录
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            //未登录
            request.setAttribute("msg","没有权限，请重新登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //已登录
            return true;
        }
    }
}

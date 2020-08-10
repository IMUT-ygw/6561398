package com.imut.component;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nmtl_ygw
 * @Description 登录检查
 * @date 2020/4/18 19:54
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理
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

    //在业务处理器处理请求执行完成后，生成视图之前执行。
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在DispatcherServlet完全处理完请求后被调用，可用于清理资源等
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

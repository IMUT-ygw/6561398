package com.imut.filter;


import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/14 9:36
 */
//server3.0注解  拦截路径  被Spring扫描、
@WebFilter(urlPatterns = "/testUpload",filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("启动容器时加载的初始化方法！");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String username = request.getParameter("username");
        request.getServletContext().setAttribute("user","ygw");
        if("ygw".equals(username)){
            filterChain.doFilter(request,response);
        }else{
            System.out.println("权限没通过！");
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("filter销毁！");
    }
}

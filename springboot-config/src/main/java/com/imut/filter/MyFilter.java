package com.imut.filter;;
import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/22 13:50
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

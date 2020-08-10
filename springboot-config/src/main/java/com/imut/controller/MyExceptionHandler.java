package com.imut.controller;

import com.imut.exception.UserNotExitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/21 12:13
 */

/**
 *      此注解
*              全局异常处理
*             全局数据绑定
*             全局数据预处理
 */
@ControllerAdvice
public class MyExceptionHandler {





    /**
     * 改进版异常json处理 根据客户端还是网页显示不同的效果 对异常进行处理
     */
//    @ExceptionHandler(UserNotExitException.class)
//    public String handleException(Exception e, HttpServletRequest request){
//        Map<String,Object> map = new HashMap<>();
//        //无论客户端或网页请求获得异常时，状态码就会显示200，不会加载error中的错误页面，只有4xx或5xx时才会显示，所以我们要自己设置状态码
//        //springmvc根据状态码判断显示的是json还是错误网页的形式
//        request.setAttribute("javax.servlet.error.status_code",500);
//        map.put("code","not");
//        map.put("message",e.getMessage());
//        //如果不转发到error  则会在网页也显示json格式
//        request.setAttribute("ext",map);
//        return "forward:/error";
//    }



}

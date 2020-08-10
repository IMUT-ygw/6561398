package com.imut.compoent;

import com.sun.javafx.collections.MappingChange;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/13 11:31
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handleException(Exception e, HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",100);
        map.put("mas",e.getMessage());
        map.put("url",request.getRequestURL());
        return map;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Object myException(MyException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
    }

}

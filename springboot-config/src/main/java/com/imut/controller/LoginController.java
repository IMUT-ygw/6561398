package com.imut.controller;

import com.imut.exception.UserNotExitException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/18 16:42
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession httpSession){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //成功进入以后设置一个Session
            httpSession.setAttribute("loginUser",username);
            return "dashboard";
        }else{
            map.put("msg","用户名密码错误");
            return "index";
        }
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String Hello(@RequestParam("user") String user){
        if("123".equals(user)){
            return "hello";
        }else{
            throw new UserNotExitException();
        }


    }
}

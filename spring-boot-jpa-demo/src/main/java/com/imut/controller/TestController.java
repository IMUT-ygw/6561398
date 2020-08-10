package com.imut.controller;

import com.imut.dao.UserDao;
import com.imut.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/27 8:17
 */
@Controller
public class TestController {
    @Autowired
    UserDao userDao;

    @GetMapping("/user")
    public String test(User user){
        userDao.save(user);
        return "success";
    }
}

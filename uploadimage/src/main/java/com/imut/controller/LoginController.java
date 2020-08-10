package com.imut.controller;

import com.imut.mapper.UserInfoMapper;
import com.imut.pojo.LoginAttribute;
import com.imut.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author nmtl_ygw
 * @Description  用户及管理员登录
 * @date 2020/5/19 10:28
 */
@Controller
public class LoginController {
    @Autowired
    UserInfoMapper userInfoMapper;

    @PostMapping("/loginUser")
    @ResponseBody
    /**
     * 如果前端参数与此方法下参数名不同，可以通过@RequestParam将前端参数封装交给方法下参数
     */
    public String userLogin(@RequestBody LoginAttribute loginAttribute){
        UserInfo userInfo = userInfoMapper.userLogin(loginAttribute.getTelephone(), loginAttribute.getPassword());
        if(userInfo == null){
            return "error";
        }
        return "success";
    }


    @PostMapping("/loginAdmin")
    @ResponseBody
    public String adminLogin(@RequestBody LoginAttribute loginAttribute){
        if("admin".equals(loginAttribute.getAdminId()) && "123456".equals(loginAttribute.getAdminPassword())){
            return "success";
    }
        return "error";
    }

}

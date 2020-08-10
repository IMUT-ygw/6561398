package com.imut.controller;

import com.imut.mapper.UserInfoMapper;
import com.imut.pojo.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/19 10:48
 */
@Controller
public class UserInfoController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @PostMapping("/addUserInfo")
    @ResponseBody
    //此为from表单注册形式（不用）
    public String addUserInfo(UserInfo userInfo){
        System.out.println(userInfo);
        //此处注册用户应保持手机号的唯一性
        userInfoMapper.insert(userInfo);
        return "success";
    }

    //注册添加方式二（json模式 使用中）
    @PostMapping("/addUserInfo1")
    @ResponseBody
    public String addUserInfo1(@RequestBody UserInfo u ){
        userInfoMapper.insert(u);
        return "success";
    }



    @GetMapping("/findAll")
    @ResponseBody
    public List<UserInfo> findAll(){
       List<UserInfo> all = userInfoMapper.findAll();
       return all;
    }

    @GetMapping("/findByTelephone")
    @ResponseBody
    public UserInfo findByTelephone(String telephone){
        UserInfo byTelephone = userInfoMapper.findByTelephone(telephone);
        return byTelephone;
    }
}

package com.godjob.controller;

import com.godjob.entity.ResultData;
import com.godjob.mapper.HelperInfoMapper;
import com.godjob.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 16:53
 */
@RestController
public class HelloController {
    @Autowired
    HelperInfoMapper helperInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @GetMapping("/get")
    public String getSession(HttpSession httpSession){
        httpSession.setAttribute("ygw","666");
        return "success";
    }

    @GetMapping("/hello")
    public List<ResultData> hello(){
        List<ResultData> data = userInfoMapper.findData();
        return data;
    }


    @GetMapping("/hello11")
    public List<ResultData> hello1(){
        List<ResultData> data = helperInfoMapper.findData();
        return data;
    }
}

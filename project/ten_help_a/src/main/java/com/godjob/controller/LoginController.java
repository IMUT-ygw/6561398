package com.godjob.controller;

import com.alibaba.fastjson.JSON;
import com.godjob.entity.NormalInfo;
import com.godjob.entity.UserInfo;
import com.godjob.mapper.NormalInfoMapper;
import com.godjob.mapper.UserInfoMapper;
import org.apache.tomcat.jni.Time;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 18:55
 */
@RestController
public class LoginController {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private NormalInfoMapper normalInfoMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    /**
     * 首次登录  ok  缓存完成
     */
    @PostMapping("/nwxu")
    public String newUserLogin(@RequestBody UserInfo userInfo) throws IOException {
        UserInfo byUserId = null;
        if (userInfo.getUserId() != null) {
            //判断缓存里面是否有该用户
             String userId = (String) redisTemplate.opsForValue().get("firstlog_" + userInfo.getUserId());
            //如果没有
            if(byUserId == null) {
                 byUserId = userInfoMapper.findByUserId(userInfo.getUserId());
                 redisTemplate.opsForValue().set("firstlog_" + userInfo.getUserId(),userInfo.getUserId());
            }
            //查找后将用户存入缓存
            if (byUserId != null || userId != null) {
                return "Multiple user logins";
            } else {
                System.out.println("接收参数：" + userInfo.getUserWxName());
                Date d = new Date();
                Timestamp t = new Timestamp(d.getTime());
                userInfo.setUserFirstDate(t);
                String address = userInfo.getCountry() + " " + userInfo.getProvince() + " " + userInfo.getCity();
                userInfo.setUserId(userInfo.getUserId());
                userInfo.setUserAddress(address);
                userInfoMapper.insert(userInfo);//用户表存储
                String uuIdNormal = UUID.randomUUID().toString();
                NormalInfo normalInfo = new NormalInfo(uuIdNormal, userInfo.getUserId());//记录至普通用户表
                normalInfoMapper.insert(normalInfo);
                return "User's first login";
            }
        }
        return "error: Parameter is null";
    }


    /**
     * 完善信息  ok
     */
    @PostMapping("/ui")
    public String updateInformation(@RequestBody UserInfo userInfo) throws IOException {
        if (userInfo != null) {
            UserInfo byUserId = userInfoMapper.findByUserId(userInfo.getUserId());
            if (byUserId != null) {
                //更新信息
                userInfoMapper.addInformation(userInfo);
                return "The user uploaded the information successfully";
            } else {
                return "error：User failed to upload information!  Reason: There is no unique user ID\n" +
                        "\n";
            }
        }
        return "error: Parameter is null";
    }


    /**
     * 传头像  及  用户唯一id   ok
     */
    @PostMapping("/uim")
    public String updateInformationImage(MultipartFile userPhoto, String userId) throws IOException {
        System.out.println("照片:" + userPhoto.getBytes());
        System.out.println(userId);
        UserInfo byUserId = userInfoMapper.findByUserId(userId);
        if (byUserId != null) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userId);
            //更新信息
            userInfoMapper.addInformation(userInfo);
            return "The user uploaded the information successfully";
        } else {
            return "error：User failed to upload information!  Reason: There is no unique user ID\n" +
                    "\n";
        }
    }
}







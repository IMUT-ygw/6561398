package com.godjob.controller;

import com.alibaba.fastjson.JSON;
import com.godjob.entity.Admin;
import com.godjob.entity.AdminAuditInfo;
import com.godjob.entity.HelperInfo;
import com.godjob.mapper.AdminMapper;
import com.godjob.mapper.HelperInfoMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description  管理员登录
 * @date 2020/6/9 11:37
 */
@RestController
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
   private HelperInfoMapper helperInfoMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @PostMapping("/admin")
    public String admin(@RequestBody Admin admin){
        Admin one = null;
        //判断缓存
        String o = (String) redisTemplate.opsForValue().get("admin_" + admin.getOpenId());
        if(o == null){
            one = adminMapper.findOne(admin);
            if(one != null) {
                String string = JSON.toJSONString(one);
                redisTemplate.opsForValue().set("admin_" + admin.getOpenId(), string);
            }
        }

        if(one != null|| o != null){
            return "1";
        }
        return "0";
    }

    //管理员审核信息
    @GetMapping("/adminData")
    public List<AdminAuditInfo> adminData(){
        List<AdminAuditInfo> adminData = helperInfoMapper.findAdminData();
        System.out.println(adminData.size());
        for(int i = 0; i < adminData.size() ;i++){
            AdminAuditInfo adminAuditInfo = adminData.get(i);
            byte[] userPhoto = adminAuditInfo.getUserInfo().getUserPhoto();
            adminAuditInfo.getUserInfo().setBasePhoto("data:image/png;base64," + Base64.encodeBase64String(userPhoto));
            adminAuditInfo.getHelperImage().setImageBase01("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage01()));
            adminAuditInfo.getHelperImage().setImageBase02("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage02()));
            adminAuditInfo.getHelperImage().setImageBase03("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage03()));
            adminAuditInfo.getHelperImage().setImageBase04("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage04()));
            adminAuditInfo.getHelperImage().setImageBase05("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage05()));
        }
        return adminData;
    }


    //管理员审核信息
    @PostMapping("/adminDataAgain")
    public AdminAuditInfo adminData2(@RequestBody HelperInfo helperInfo){
       AdminAuditInfo adminAuditInfo = helperInfoMapper.findAdminData2(helperInfo.getUserId());
            byte[] userPhoto = adminAuditInfo.getUserInfo().getUserPhoto();
            adminAuditInfo.getUserInfo().setBasePhoto("data:image/png;base64," + Base64.encodeBase64String(userPhoto));
            adminAuditInfo.getHelperImage().setImageBase01("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage01()));
            adminAuditInfo.getHelperImage().setImageBase02("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage02()));
            adminAuditInfo.getHelperImage().setImageBase03("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage03()));
            adminAuditInfo.getHelperImage().setImageBase04("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage04()));
            adminAuditInfo.getHelperImage().setImageBase05("data:image/png;base64,"+Base64.encodeBase64String(adminAuditInfo.getHelperImage().getImage05()));
        return adminAuditInfo;
    }




}

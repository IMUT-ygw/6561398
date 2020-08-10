package com.godjob.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.godjob.entity.*;
import com.godjob.mapper.HelperImageMapper;
import com.godjob.mapper.HelperInfoMapper;
import com.godjob.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 20:29
 */
@RestController
public class HelpApplyController {

    @Autowired
    private HelperInfoMapper helperInfoMapper;
    @Autowired
    private HelperImageMapper helperImageMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    //上传贫困认证图
    @PostMapping("/ha")
    public String helpApplyImage(MultipartFile helpApplyImage, String userId) throws IOException, InterruptedException {
        HelperImage image = new HelperImage();
        if (userId != null && helpApplyImage != null) {
            image.setImageId(userId);
        } else {
            return "参数为空或不正确！";
        }
        //判断数据库中是否存过该账户的照片
        HelperImage byId = helperImageMapper.findById(userId);
        System.out.println("照片库状态" + byId);
        if (byId == null) {
            image.setImage01(helpApplyImage.getBytes());
            helperImageMapper.insert(image);
            return "success01";
        } else {
            if (byId.getImage02() == null) {
                image.setImage02(helpApplyImage.getBytes());
                helperImageMapper.updateImage(image);
                Thread.sleep(1000);
                return "success02";
            }
            if (byId.getImage03() == null) {
                image.setImage03(helpApplyImage.getBytes());
                helperImageMapper.updateImage(image);
                return "success03";
            }
            if (byId.getImage04() == null) {
                image.setImage04(helpApplyImage.getBytes());
                helperImageMapper.updateImage(image);
                return "success04";
            }
            if (byId.getImage05() == null) {
                image.setImage05(helpApplyImage.getBytes());
                helperImageMapper.updateImage(image);
                return "success05";
            }
        }
        return "No operation!";
    }

    //上传文本
    @PostMapping("/hat")
    public String helpApplyText(@RequestBody HelperInfo helperInfo){
        HelperInfo byId = helperInfoMapper.findById(helperInfo.getUserId());
        if (byId !=null){
            System.out.println("==========贫困申请=========");
            System.out.println("事件：用户再次申请");
            System.out.println("==========贫困申请=========");
            return "请勿重复申请！您的贫困请求已在审核！";
        }
        System.out.println("贫困申请：" + helperInfo.toString());
            helperInfo.setHelperId(getUuId());
            helperInfo.setImageId(helperInfo.getUserId());
            helperInfo.setStatus("审核中");
            helperInfoMapper.insert(helperInfo);
            return "success";
    }
        //获取指定Id
        public static String getUuId() {
            String uuId = UUID.randomUUID().toString();
            String result = "helpUser" + uuId.substring(8, 24) + uuId.substring(24);
            System.out.println("此次贫困申请人唯一索引：" + result);
            return result;
        }
        //返回贫困用户简述信息
    @GetMapping("/rda")
    public List<ResultData> rtData() {
        System.out.println("接收请求");
        ArrayList<Integer> temp = new ArrayList<Integer>();
        List<ResultData> data = userInfoMapper.findData();
        ResultData resultData = null;
        for (int i = 0 ; i < data.size(); i++){
            resultData = data.get(i);
            String idByUserId = helperInfoMapper.findIdByUserId(resultData.getUserId());
            if(idByUserId != null) {
                resultData.setHelperId(idByUserId);
            }else{
                temp.add(i);
                continue;
            }
            String string = Base64.getEncoder().encodeToString(resultData.getUserPhoto());
            String resultString = "data:image/png;base64," + string;
            resultData.setBasePhoto(resultString);
        }
        for (int j = 0; j < temp.size(); j++){
            data.remove(temp.get(j).intValue());
        }
        return data;
    }

    //点击进入贫困页面
    @PostMapping("/gsoh")
    public ResultOneHelper getSomeOneHelper(@RequestBody HelperInfo helperInfo){
        System.out.println(helperInfo.getHelperId());
        ResultOneHelper rs = new ResultOneHelper();
        HelperInfo byId = helperInfoMapper.findById(helperInfo.getHelperId());
        System.out.println(byId);
        if(byId != null){
            rs.setHelperDetailAddress(byId.getHelperDetailAddress());
            rs.setHelperLog(byId.getHelperLog());
            HelperImage image = helperImageMapper.findById(byId.getImageId());
            if(image != null) {
                if (image.getImage01() != null) {
                    rs.setImage01("data:image/png;base64,"+Base64.getEncoder().encodeToString(image.getImage01()));
                }
                if (image.getImage02() != null) {
                    rs.setImage02("data:image/png;base64,"+Base64.getEncoder().encodeToString(image.getImage02()));
                }
                if (image.getImage03() != null) {
                    rs.setImage03("data:image/png;base64,"+Base64.getEncoder().encodeToString(image.getImage03()));
                }
                if (image.getImage04() != null) {
                    rs.setImage04("data:image/png;base64,"+Base64.getEncoder().encodeToString(image.getImage04()));
                }
                if (image.getImage05() != null) {
                    rs.setImage05("data:image/png;base64,"+Base64.getEncoder().encodeToString(image.getImage05()));
                }
            }
            UserInfo byUserId = userInfoMapper.findByUserId(byId.getUserId());
            rs.setUserName(byUserId.getUserName());
            rs.setUserPhoto("data:image/png;base64,"+Base64.getEncoder().encodeToString(byUserId.getUserPhoto()));
        }
        return rs;
    }

    //返回用户审核状态
    @PostMapping("/rs")
    public HelperInfo returnStatus(@RequestBody HelperInfo helperInfo){
        HelperInfo byLogAndStatus = helperInfoMapper.findByLogAndStatus(helperInfo.getUserId());
        if(byLogAndStatus != null){
            return byLogAndStatus;
        }else {
            HelperInfo byLogAndStatus1 = new HelperInfo();
            byLogAndStatus1.setStatus("用户未申请贫困！");

            return byLogAndStatus1;
        }
    }

}


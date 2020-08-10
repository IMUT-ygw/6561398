package com.godjob.controller;

import com.godjob.entity.*;
import com.godjob.mapper.FootPrintMapper;
import com.godjob.mapper.HelperInfoMapper;
import com.godjob.mapper.UserCollectionMapper;
import com.godjob.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description  用户收藏贫困用户   足迹
 * @date 2020/6/19 9:27
 */
@RestController
public class ExtendFunController {
       @Autowired
       private UserCollectionMapper userCollectionMapper;
       @Autowired
       private FootPrintMapper footPrintMapper;
       @Autowired
       private HelperInfoMapper helperInfoMapper;
       @Autowired
       private UserInfoMapper userInfoMapper;


       //收藏
        @PostMapping("/cut")
        public String userCollect(@RequestBody UserCollect userCollect){
            if(userCollect.getUserId() != null && userCollect.getHelperId()!=null){//参数问题
                HelperInfo byId = helperInfoMapper.findById(userCollect.getHelperId());//筛查是否有此贫困户
                if(byId != null) {
                    UserCollect repe = userCollectionMapper.findRepe(userCollect);
                    if (repe == null) {
                        userCollectionMapper.insert(userCollect);//查重
                        return "success";
                    } else {
                        return "收藏已存在";
                    }
                }else{
                    return "无此贫困用户";
                }
            }
            return "参数有误";

    }
    //收藏展示
    @PostMapping("/rcld")
    public List<ResultData> rtCollectionData(@RequestBody UserCollect userCollect) {
        System.out.println("接收请求遍历收藏遍历请求");
        List<ResultData> resultData = userCollectionMapper.findByUserId(userCollect.getUserId()); //获取收藏的贫困用户（存储贫困用户id及基本信息id）
        System.out.println("收藏："+resultData.size()+"条");
        for (int i = 0 ; i < resultData.size(); i++){
            ResultData data = resultData.get(i);
            System.out.println(data.getHelperId());
            UserInfo byUserId = userInfoMapper.findByUserId(data.getUserId());
            data.setBasePhoto("data:image/png;base64,"+Base64.getEncoder().encodeToString(byUserId.getUserPhoto()));
            data.setUserHelpAppleLog(helperInfoMapper.findByLog(userCollect.getUserId()));
        }
        return resultData;
    }



    //存储足迹
    @PostMapping("/fpta")
    public String footPrint(@RequestBody FootPrint footPrint){
            if(footPrint.getUserId()!=null && footPrint.getHelperId()!=null){ //判断参数
                HelperInfo byId = helperInfoMapper.findById(footPrint.getUserId()); //判断是否含有参数
                if(byId!=null){
                    UserCollect repetition = footPrintMapper.findRepetition(footPrint);//是否存在
                    if(repetition == null) {
                        Timestamp timestamp = new Timestamp(new Date().getTime());
                        footPrint.setDate(timestamp);
                        footPrintMapper.insert(footPrint);
                        return "success";
                    }else{
                        return "足迹已存在";
                    }
                }
                return "内容不存在";
            }
            return "参数不正确";

    }

    //足迹展示
    @PostMapping("/ftd")
    public List<ResultData> footPrintData(@RequestBody UserCollect userCollect) {
        System.out.println("接收请求遍历足迹遍历请求");
        List<ResultData> resultData = footPrintMapper.findByUserId(userCollect.getUserId()); //获取所有足迹
        System.out.println("足迹："+resultData.size()+"条");
        for (int i = 0 ; i < resultData.size(); i++){
            ResultData data = resultData.get(i);
            UserInfo byUserId = userInfoMapper.findByUserId(data.getUserId());
            data.setBasePhoto("data:image/png;base64,"+Base64.getEncoder().encodeToString(byUserId.getUserPhoto()));
            data.setUserHelpAppleLog(helperInfoMapper.findByLog(userCollect.getUserId()));
        }
        return resultData;
    }

}

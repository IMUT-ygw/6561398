package com.imut.controller;

import com.imut.mapper.DetailsInfoMapper;
import com.imut.pojo.DetailsInfo;
import com.imut.service.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/19 12:17
 */
@Controller
public class DetailsInfoController {
    @Autowired
    DetailsInfoMapper detailsInfoMapper;

    @GetMapping("/findAllDetails")
    @ResponseBody
    public List<DetailsInfo> findAllDetails(){
        List<DetailsInfo> all = detailsInfoMapper.findAll();
        return all;
    }

//    @PostMapping("/addDetails")
//    @ResponseBody
//    public String addDetails(MultipartFile image01,MultipartFile image02,
//                             MultipartFile image03,MultipartFile image04,
//                             MultipartFile image05,String dtUserTelephone,
//                             String dtUserAddress,String dtUserIllness) throws IOException {
//        DetailsInfo detailsInfo = new DetailsInfo(dtUserTelephone,dtUserAddress,dtUserIllness,image01.getBytes(),image02.getBytes(),image03.getBytes(),image04.getBytes(),image05.getBytes());
//        detailsInfoMapper.insert(detailsInfo);
//        return "success";
//    }
    @PostMapping("/addDetails")
    @ResponseBody
    public String addDetails(@RequestBody DetailsInfo detailsInfo) throws IOException {
        detailsInfoMapper.insert(detailsInfo);
        return "success";
    }

    @PostMapping("/addDetails1")
    @ResponseBody
    public String addDetails1(MultipartFile image01,MultipartFile image02,MultipartFile image03,MultipartFile image04,MultipartFile image05,
                             DetailsInfo detailsInfo) throws IOException {
        if(image01 != null){
            detailsInfo.setDtUserImage01(image01.getBytes());
        }
        if(image02 != null){
            detailsInfo.setDtUserImage02(image02.getBytes());
        }
        if(image03 != null){
            detailsInfo.setDtUserImage03(image03.getBytes());
        }
        if(image04 != null){
            detailsInfo.setDtUserImage04(image04.getBytes());
        }
        if(image05 != null){
            detailsInfo.setDtUserImage05(image05.getBytes());
        }
            detailsInfoMapper.insert(detailsInfo);
            return "success";
    }



    @GetMapping("/hello")
    @ResponseBody
    public String hello(HttpServletRequest request){
        String localAddr = IpUtil.getIpAddr(request);
        String user = request.getParameter("user");
        System.out.println(user);
        System.out.println(localAddr);
        return "success";
    }
}

package com.imut.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.imut.service.CodeUtil;
import com.imut.service.SmsTool;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/20 16:38
 */
@Controller
@RequestMapping("/sms")
public class IphoneMsg {
    @RequestMapping(value = "/smsXxs")
    @ResponseBody
    public HashMap<String,Object> smsXxs(String phone, HttpServletRequest request) throws ClientException {
        HashMap<String,Object> map = new HashMap<>();
        // 验证码（指定长度的随机数）
        String code = CodeUtil.generateVerifyCode(6);
        String TemplateParam = "{\"code\":\""+code+"\"}";
        // 短信模板id
        String TemplateCode = "SMS_190790729";
        SendSmsResponse response = SmsTool.sendSms(phone,TemplateParam,TemplateCode);
        map.put("verifyCode",code);
        map.put("phone",phone);
        request.getSession().setAttribute("CodePhone",map);
        if( response.getCode().equals("OK")) {
            map.put("isOk","OK");
        }
        return map;
    }
}

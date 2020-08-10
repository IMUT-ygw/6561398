package com.imut.controller;

import com.imut.compoent.MyException;
import com.imut.pojo.TextUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/13 9:26
 */
@Controller
@PropertySource({"classpath:application.properties"})
public class TestUpdate {

    @Value("${web.upload.path}")
    public String filePath;

    @PostMapping("/testUpload")
    @ResponseBody
    public void upload(@RequestParam("image") MultipartFile file, HttpServletRequest request) throws IOException {
        String username = request.getParameter("username");
        System.out.println("用户名:" + username);
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        System.out.println("上传的文件名：" + originalFilename);
        //上传文件名后缀
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("文件名后缀：" +suffixName);

        String fileName = UUID.randomUUID() + suffixName;
        File f = new File(filePath + fileName);
        file.transferTo(f);
        Object user = request.getServletContext().getAttribute("user");
        System.out.println("域对象共享数据"+user);

    }

    @GetMapping("/show")
    @ResponseBody
    public String show(HttpServletRequest request){
        Enumeration<String> initParameterNames = request.getServletContext().getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            String initParameter = request.getServletContext().getInitParameter(s);
            System.out.println(initParameter);
        }
        String realPath = request.getServletContext().getRealPath("/application.properties");
        System.out.println(realPath);
        InputStream resourceAsStream = request.getServletContext().getResourceAsStream("/application.properties");
        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("/application.properties");
        System.out.println(resourceAsStream == systemResourceAsStream);
        return "success";
    }

    @GetMapping("/myexc")
    @ResponseBody
    public String myexc(){
        throw new MyException("my exc 异常","500");
    }


}

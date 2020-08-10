package com.imut.controller;

import com.imut.mapper.UploadMapper;
import com.imut.pojo.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/16 20:31
 */
@RestController
public class UploadController {
    @Autowired
    UploadMapper uploadMapper;


    @GetMapping("/uploadImage")
    public String insert(MultipartFile image) throws IOException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        Timestamp t = Timestamp.valueOf(time);
        Upload upload = new Upload();
        upload.setDate(t);
        byte[] bytes = image.getBytes();
        upload.setImage(bytes);
        uploadMapper.insertImage(upload);
        return "success";
    }

    @GetMapping("/findImage")
    public String findAll() throws IOException {
        Upload all = uploadMapper.findAll();
        FileOutputStream fis = new FileOutputStream(new File("d://a.jpg"));
        fis.write(all.getImage());
        fis.close();
        return "success";
    }


}

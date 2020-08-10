package com.imut.springbootdatamybatis;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.sun.javafx.collections.MappingChange;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Callable;

@SpringBootTest
class SpringBootDataMybatisApplicationTests {

    @Test
    public void oRcode() throws JSONException, WriterException, IOException {
        //创建json格式得字符串，使用fastJson,设置json数据
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("公司","luckyuan");
        jsonObject.put("地址","imut");
        jsonObject.put("作者","ygw");
        String string = jsonObject.toString();


        //将以上内容生成二维码
        //二维码宽高
        int width = 200;
        int height = 200;
        //创建map集合(设置字符集作为矩阵对象得参数)
        HashMap<EncodeHintType,Object> map = new HashMap<>();
        map.put(EncodeHintType.CHARACTER_SET,"utf-8");
        //创建一个矩阵对象 参数：内容 矩阵类型 宽 高 字符集
        BitMatrix bitMatrix = new MultiFormatWriter().encode(string, BarcodeFormat.QR_CODE,width,height,map);
        //二维码生成路径
        String urlPath = "d://";
        String fileName = "ygw.jpg";
        Path path = FileSystems.getDefault().getPath(urlPath,fileName);
        //将矩阵对象生成图片
        MatrixToImageWriter.writeToPath(bitMatrix,"jpg",path);
        System.out.println("success");
    }

}

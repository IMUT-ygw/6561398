package com.imut.mapper;


import com.imut.controller.UploadController;
import com.imut.pojo.Upload;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/16 20:44
 */
public interface UploadMapper {

    @Select("select * from upload")
    Upload findAll();


    @Insert("insert into upload(image,date)values(#{image},#{date})")
    int insertImage(Upload upload);
}

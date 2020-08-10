package com.godjob.mapper;

import com.godjob.entity.HelperImage;
import com.godjob.entity.UserInfo;
import com.godjob.service.HelpImageProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 18:48
 */
public interface HelperImageMapper {
    @Select("select * from helper_image;")
    List<UserInfo> findAll();

    @Insert("insert into helper_image(image_id,image01,image02,image03,image04,image05)" +
            "values(#{imageId},#{image01},#{image02},#{image03},#{image04},#{image05});")
    void insert(HelperImage helperImage);


    @Select("select * from helper_image where image_id = #{helpImageId}")
    HelperImage findById(String helpImageId);

    @UpdateProvider(type = HelpImageProvider.class,method = "updateApp")
    void updateImage(HelperImage helperImage);
}

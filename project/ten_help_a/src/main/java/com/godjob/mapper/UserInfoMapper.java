package com.godjob.mapper;

import com.godjob.entity.ResultData;
import com.godjob.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 17:48
 */
public interface UserInfoMapper {


    @Select("select user_photo ,user_id from user_info")
    @Results({
            @Result(property = "userPhoto", column = "user_photo"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userHelpAppleLog", column = "user_id", one = @One(select = "com.godjob.mapper.HelperInfoMapper.findByLog"))
    })
    List<ResultData> findData();

    @Select("select * from user_info;")
    List<UserInfo> findAll();

    @Insert("insert into user_info(user_id,user_name,user_wx_name,user_gender,user_header,user_first_date,user_address,user_card_id,user_age,user_photo)" +
            "values(#{userId},#{userName},#{userWxName},#{userGender},#{userHeader},#{userFirstDate},#{userAddress},#{userCardId},#{userAge},#{userPhoto})")
    @Options(useGeneratedKeys = true,keyProperty = "userId",keyColumn = "user_id")
    void insert(UserInfo userInfo);

    @Update("update user_info set user_header = #{userHeader} where user_id = #{userId}")
    void addHeader(UserInfo userInfo);

    @Update("update user_info set user_name = #{userName},user_age=#{userAge},user_gender=#{userGender},user_card_id=#{userCardId}," +
            "user_photo=#{userPhoto} where user_id = #{userId}")
    void addInformation(UserInfo userInfo);

    @Select("select * from user_info where user_id = #{userId}")
    UserInfo findByUserId(String userId);

    @Select("select user_photo from user_info where user_id = #{userId}")
    byte[] findUserPhoto(String userId);

}

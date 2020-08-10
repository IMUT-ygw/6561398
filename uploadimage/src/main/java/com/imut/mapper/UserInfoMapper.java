package com.imut.mapper;

import com.imut.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/19 10:22
 */
public interface UserInfoMapper {

    @Select("select * from user_info order by id")
    List<UserInfo> findAll();

    @Insert("insert into user_info(user_name,user_card_id,user_password,user_telephone,user_gender,user_age,user_header)values" +
            "(#{userName},#{userCardId},#{userPassword},#{userTelephone},#{userGender},#{userAge},#{userHeader})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insert(UserInfo userInfo);

    @Select("select * from user_info where user_telephone = #{userTelephone}")
    UserInfo findByTelephone(String userTelephone);

    @Select("select * from user_info where user_password = #{userPassword} and user_telephone = #{userTelephone}")
    UserInfo userLogin(String userTelephone,String userPassword);



}

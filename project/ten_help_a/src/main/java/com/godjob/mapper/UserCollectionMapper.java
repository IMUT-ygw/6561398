package com.godjob.mapper;

import com.godjob.entity.ResultData;
import com.godjob.entity.UserCollect;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/19 9:30
 */
public interface UserCollectionMapper {

    @Select("select * from user_collect")
    List<UserCollect> findAll();


    @Select("select helper_id ,user_id from user_collect where user_id = #{userId}")
    List<ResultData> findByUserId(String userId);


    @Insert("insert into user_collect(user_id , helper_id)values(#{userId},#{helperId})")
    void insert(UserCollect userCollect);

    @Select("select * from user_collect where user_id = #{userId} , helper_id = #{helperId}")
   UserCollect findRepe(UserCollect userCollect);
}

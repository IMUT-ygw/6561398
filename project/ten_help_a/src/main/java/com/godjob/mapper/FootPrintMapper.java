package com.godjob.mapper;

import com.godjob.entity.FootPrint;
import com.godjob.entity.ResultData;
import com.godjob.entity.UserCollect;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description  足迹
 * @date 2020/6/19 10:02
 */
public interface FootPrintMapper {
    @Select("select * from foot_print")
    List<UserCollect> findAll();


    @Select("select user_id,helper_id,date from foot_print where user_id = #{userId}")
    List<ResultData> findByUserId(String userId);


    @Insert("insert into foot_print(user_id , helper_id,date)values(#{userId},#{helperId},#{date})")
    void insert(FootPrint footPrint);

    @Select("select * from foot_print where user_id = #{userId} and helper_id = #{helperId}")
    UserCollect findRepetition(FootPrint footPrint);

}

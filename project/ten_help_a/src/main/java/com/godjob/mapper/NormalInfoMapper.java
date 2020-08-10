package com.godjob.mapper;

import com.godjob.entity.NormalInfo;
import com.godjob.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 19:03
 */
public interface NormalInfoMapper {
    @Select("select * from normal_info;")
    List<UserInfo> findAll();

    @Insert("insert into normal_info(normal_id,user_id)" +
            "values(#{normalId},#{userId});")
    @Options(useGeneratedKeys = true,keyProperty = "normalId",keyColumn = "normal_id")
    void insert(NormalInfo normalInfo);



}

package com.godjob.mapper;

import com.godjob.entity.AdminAuditInfo;
import com.godjob.entity.HelperInfo;
import com.godjob.entity.ResultData;
import com.godjob.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/8 18:45
 */
public interface HelperInfoMapper {

    //管理员审核信息(简略)
    @Select("select * from helper_info;")
    @Results({
            @Result(property = "helperLog",column = "helper_log"),
            @Result(property = "helperDetailAddress",column = "helper_detail_address"),
            @Result(property = "status",column = "status"),
            @Result(property = "userInfo",column = "user_id",one = @One(select = "com.godjob.mapper.UserInfoMapper.findByUserId")),
            @Result(property = "helperImage",column = "image_id",one = @One(select = "com.godjob.mapper.HelperImageMapper.findById")),
    })
    List<AdminAuditInfo> findAdminData();

    //管理员审核个信息
    @Select("select * from helper_info where user_id = #{userId};")
    @Results({
            @Result(property = "helperLog",column = "helper_log"),
            @Result(property = "helperDetailAddress",column = "helper_detail_address"),
            @Result(property = "status",column = "status"),
            @Result(property = "userInfo",column = "user_id",one = @One(select = "com.godjob.mapper.UserInfoMapper.findByUserId")),
            @Result(property = "helperImage",column = "image_id",one = @One(select = "com.godjob.mapper.HelperImageMapper.findById")),
    })
    AdminAuditInfo findAdminData2(String userId);


    @Select("select helper_log,user_id from helper_info;")
    @Results({
            @Result(property = "userHelpAppleLog",column = "helper_log"),
            @Result(property = "userPhoto",column = "user_id",one = @One(select = "com.godjob.mapper.UserInfoMapper.findUserPhoto"))
    })
    List<ResultData> findData();

    @Select("select * from helper_info;")
    List<UserInfo> findAll();

    @Insert("insert into helper_info(helper_id,user_id,helper_detail_address,helper_log,status,image_id)" +
            "values(#{helperId},#{userId},#{helperDetailAddress},#{helperLog},#{status},#{imageId});")
    @Options(useGeneratedKeys = true,keyColumn ="helper_id" ,keyProperty ="helperId" )
    void insert(HelperInfo helperInfo);

    @Select("select * from helper_info where helper_id = #{helperId}")
    HelperInfo findById(String helperId);

    @Select("select helper_log from helper_info where user_id = #{userId} ")
    String findByLog(String userId);

    @Select("select helper_log ,status from helper_info where user_id = #{userId} ")
    HelperInfo findByLogAndStatus(String userId);

    @Select("select helper_id from helper_info where user_id = #{userId} ")
    String findIdByUserId(String userId);
}

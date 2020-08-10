package com.godjob.mapper;

import com.godjob.entity.Admin;
import org.apache.ibatis.annotations.Select;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/9 11:35
 */
public interface AdminMapper {



    @Select("select * from admin where open_id = #{openId} and admin_wx_name = #{adminWxName}")
    Admin findOne(Admin admin);
}

package com.imut.dao;

import com.imut.entities.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/28 12:56
 */
@Mapper
public interface UserDao {

    //管理员查看所有业务
    @Select("select * from user order by id")
    @Results(id = "user",value = {
            @Result(column = "id" , property = "id" , id = true ,jdbcType = JdbcType.INTEGER),
            @Result(column = "user_telephone",property ="userTelephone",jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_date",property ="userDate",jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_service",property = "userService",jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_describe",property = "userDescribe",jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_telephone" ,property = "customer",
                    one = @One(select = "com.imut.dao.CustomerDao.findByTelephone"))
    })
    Collection<User> findAll();

    @Select("select * from user where id = #{id}")
    @ResultMap("user")
    User findById(Integer id);

    //根据手机号查找用户卡号  用卡号查找流水信息
    @Select("select * from user where user_telephone = #{userTelephone} order by id")
    @ResultMap("user")
    ArrayList<User> findCustomer(String userTelephone);


    @Insert("INSERT INTO USER(user_telephone,user_date,user_service,user_describe) " +
            "VALUES(#{userTelephone},#{userDate},#{userService},#{userDescribe});")
    @Options(useGeneratedKeys=true,keyProperty="id")
    void insertUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUserService(Integer id);

    @Delete("delete from user where user_telephone = #{telephone}")
    void deleteByTelephone(String telephone);

}

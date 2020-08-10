package com.imut.dao;

import com.imut.entities.UserLog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Collection;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/28 13:25
 */
@Mapper
public interface UserLogDao {

    @Select("select * from user_log order by id")
    @Results( id = "userLog", value = {
            @Result(column = "id",property = "id",id = true,jdbcType = JdbcType.INTEGER),
            @Result(column = "log_user_id" ,property = "logUserId",jdbcType = JdbcType.INTEGER),
            @Result(column = "log_user_date",property = "logUserDate",jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "log_user_describe",property = "logUserDescribe",jdbcType = JdbcType.VARCHAR),
            @Result(column = "log_user_telephone",property = "logUserTelephone",jdbcType = JdbcType.VARCHAR),
            @Result(column = "log_user_telephone",property = "customer",
                 one = @One(select = "com.imut.dao.CustomerDao.findByTelephone")
            )
    })
    Collection<UserLog> findAll();


    @Select("select * from user_log where log_user_id = #{logUserId} order by id")
    @ResultMap("userLog")
    Collection<UserLog> findUserLog(Integer logUserId);


    @Delete("delete from user_log where id = #{id}")
    void deleteUserLog(Integer id);

    @Insert("insert into user_log(log_user_id,log_user_date,log_user_describe,log_user_telephone)values" +
            "(#{logUserId},#{logUserDate},#{logUserDescribe},#{logUserTelephone})")
    void insertUserLog(UserLog userLog);

    @Select("select * from user_log where log_user_telephone = #{userLogTelephone}")
    List<UserLog> findByTelephone(String userLogTelephone);

    @Delete("delete from user_log where log_user_telephone = #{telephone}")
    void deleteTelephone(String telephone);
}

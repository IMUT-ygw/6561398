package com.imut.server;

import com.imut.utils.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/18 9:54
 */
public class UpdateInfo {

    //插入数据
    public Integer insertInfo(Integer id,String name,Integer age,Integer gender,String sClass,String address){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String genders = "";
        int i = 0;

        try {
            connection = JdbcUtils.getConnection();
            String sql = "insert into student(stu_id,stu_name,stu_age,stu_gender,stu_class,stu_address)values(?,?,?,?,?,?)";
           preparedStatement =  connection.prepareStatement(sql);
           preparedStatement.setObject(1,id);
           preparedStatement.setObject(2,name);
           preparedStatement.setObject(3,age);
           if(gender == 1){
               genders = "男";
           }else {
               genders = "女";
           }
           preparedStatement.setObject(4,genders);
           preparedStatement.setObject(5,sClass);
           preparedStatement.setObject(6,address);
           i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResourceResult(connection,preparedStatement,rs);
        }
        return i;
    }

    //根究id删除
    public Integer delete(String id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int i = 0;

        try {
            connection = JdbcUtils.getConnection();
            String sql = "delete from student where stu_id = ?";
            preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.setObject(1,id);
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResourceResult(connection,preparedStatement,rs);
        }
        return i;
    }


}

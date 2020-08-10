package com.imut.server;

import com.imut.domain.Student;
import com.imut.utils.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/18 8:41
 */
public class SelectInfo {

    public List<Student> findAll(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Student> arrayList = new ArrayList<Student>();
        Student student=null;
        try {
             connection = JdbcUtils.getConnection();
             String sql = "select * from student;";
             preparedStatement = connection.prepareStatement(sql);
             rs = preparedStatement.executeQuery();
             //展示数据
            if(rs.next()){
                student = new Student();
                student.setStuId(rs.getInt(1));
                student.setStuName(rs.getString(2));
                student.setStuAge(rs.getInt(3));
                student.setStuGender(rs.getString(4));
                student.setStuClass(rs.getString(5));
                student.setStuAddress(rs.getString(6));
                arrayList.add(student);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeResourceResult(connection,preparedStatement,rs);
        }
        return arrayList;
    }

    //根据id查找
    public Student findById(Integer id)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Student student = null;
            try {
                connection = JdbcUtils.getConnection();
                String sql = "select * from student where stu_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setObject(1,id);
                rs =  preparedStatement.executeQuery();
                if(rs.next()){
                    student = new Student();
                    student.setStuId(rs.getInt(1));
                    student.setStuName(rs.getString(2));
                    student.setStuAge(rs.getInt(3));
                    student.setStuGender(rs.getString(4));
                    student.setStuClass(rs.getString(5));
                    student.setStuAddress(rs.getString(6));
                }
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                JdbcUtils.closeResourceResult(connection,preparedStatement,rs);
            }
            return student;
    }
}

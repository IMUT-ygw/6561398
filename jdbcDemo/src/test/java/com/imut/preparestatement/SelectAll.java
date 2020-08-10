package com.imut.preparestatement;

import com.imut.Account;
import com.imut.User;
import com.imut.Util.JdbcUtils;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * 针对于查询
 */
public class SelectAll {
    /*
    根据sql语句查询
     */
    @Test
    public void findAll() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from user where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            preparedStatement.setObject(1,"袁国伟");
            //因为查询方法要返回一个对象，所以语句要用executeQuery
            rs = preparedStatement.executeQuery();
            ArrayList<User> list = new ArrayList<>();
            if(rs.next()){
                User u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setAge(rs.getInt(3));
                u.setSex(rs.getInt(4));
                u.setUsername(rs.getString(5));
                u.setPwd(rs.getString(6));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResourceResult(connection,preparedStatement,rs);
        }
    }

    /**
     * 统用查找
     */
    public Account findAllTest(String sql, Object ...args) throws Exception {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i <args.length ; i++) {
            ps.setObject(i+1,args[i]);
        }
        ResultSet rs = ps.executeQuery();
        //获取结果集的元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取列数
        int colu = rsmd.getColumnCount();
        if(rs.next()){


        }
        JdbcUtils.closeResourceResult(conn,ps,rs);
        return null;
    }


}

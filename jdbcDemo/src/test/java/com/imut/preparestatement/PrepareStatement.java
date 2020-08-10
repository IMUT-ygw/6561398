package com.imut.preparestatement;

import com.imut.Util.JdbcUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 使用prepareStatement代替statement 防止字符串拼接和sql注入问题
 */
public class PrepareStatement {
    /**
     * 添加
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {
        //两种系统类加载器都可以以实现
       // InputStream resourceAsStream = PrepareStatement.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Connection connection = JdbcUtils.getConnection();
        //用链接使用prepareStatement对象(预编译sql语句并返回实例)
        String sql = "insert into account(name,money)values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //填充占位符
        preparedStatement.setString(1,"aaa");
        preparedStatement.setFloat(2,12345f);

        //执行sql语句
        preparedStatement.execute();

        //关闭资源
        JdbcUtils.closeResource(connection,preparedStatement);
    }

    /**
     * 修改
     * @throws Exception
     */
    @Test
    public void update() throws Exception {
        //获取数据库连接
        Connection coon = JdbcUtils.getConnection();

        //预编译sql语句 返回prepareStatement对象
        String sql = "update account set name = ?,money=?  where id = ?";
        PreparedStatement ps = coon.prepareStatement(sql);

        //填充占位符
        ps.setString(1,"ygw");
        ps.setFloat(2,999f);
        ps.setInt(3,2);

        //执行sql
        ps.execute();

        //关闭资源
        JdbcUtils.closeResource(coon,ps);
    }



}

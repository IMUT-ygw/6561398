package com.imut.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

/**
 * @author nmtl_ygw
 * @Description jdbc工具类
 * @date 2020/6/18 8:23
 */
public class JdbcUtils {
    public static Connection getConnection() throws IOException {
        //读取配置文件的数据源信息
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        DruidDataSource bean = ioc.getBean(DruidDataSource.class);
        DruidPooledConnection connection = null;
        try {
            connection = bean.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭资源
    public static void closeResourceResult(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (statement != null) {
                statement.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(resultSet != null){
                resultSet.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

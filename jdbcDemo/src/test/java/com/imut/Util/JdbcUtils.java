package com.imut.Util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的工具类
 */
public class JdbcUtils {
    public static Connection getConnection() throws Exception {
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String driver = properties.getProperty("driverClass");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(driver);
        java.sql.Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        return connection;
    }

    public static void closeResource(Connection connection, Statement statement){
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

    }


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

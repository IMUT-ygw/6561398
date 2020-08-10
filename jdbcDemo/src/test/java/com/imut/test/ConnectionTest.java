package com.imut.test;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    //方式一（导包获取）
    @Test
    public void testConnection1() throws SQLException {
        //驱动（需要导包 导坐标 mysql）
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost/jdbcTemplate";
        //配置用户名密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        //获取链接对象，只有获取到链接对象才能判断是否链接到数据库
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }
    //方式二（利用反射 不依赖第三方包）
    @Test
    public void testConnection2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //1.利用反射获取驱动对象
        Class Clazz = Class.forName("com.mysql.jdbc.Driver");
        com.mysql.jdbc.Driver driver = (com.mysql.jdbc.Driver) Clazz.newInstance();
        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/jdbcTemplate";

        //3.获取用户名密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");

        //4.获取Connection对象
        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

    //方式三（使用DriverManagement 代替Driver）
    @Test
    public void testConnection3()throws Exception{
        Class aClass = Class.forName("com.mysql.jdbc.Driver");

        com.mysql.jdbc.Driver driver= (com.mysql.jdbc.Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/jdbcTemplate";
        String user = "root";
        String password = "123456";

        //注册驱动
        DriverManager.registerDriver(driver);
        //获取链接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    //方式四（使用DriverManagement 代替Driver）
    @Test
    public void testConnection4()throws Exception{
        //当系统加在Driver类时 会自动执行其静态代码块的内容
        /**
         *  static {
         *         try {
         *              //加载驱动
         *             DriverManager.registerDriver(new Driver());
         *         } catch (SQLException var1) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         */
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbcTemplate";
        String user = "root";
        String password = "123456";
        //获取链接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


    //方式五（将冗杂信息 写到配置文件中）
    @Test
    public void testConnection() throws IOException, ClassNotFoundException, SQLException {
        //1.读取配置文件信息\
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties info = new Properties();
        info.load(is);

        String user = info.getProperty("user");
        String password  =info.getProperty("password");
        String url = info.getProperty("url");
        String driverClass = info.getProperty("driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}

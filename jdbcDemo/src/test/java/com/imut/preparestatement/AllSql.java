package com.imut.preparestatement;

import com.imut.Account;
import com.imut.Util.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AllSql {
    /**
     * 通用增删改
     */
    public void sqlString(String sql , Object ...args) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                //注意参数声明
                preparedStatement.setObject(i+1,args[i]);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeResource(connection, preparedStatement);
        }
    }
    @Test
    public void testAll() throws Exception {
        String sql = "update account set name = ?, money = ? where id = ?";
        String sql1 = "delete from account where id = ?";
        String sql2 = "insert into account(name,money)values(?,?)";
//        sqlString(sql1,2);
//        sqlString(sql,"ggg",123987f,3);
        sqlString(sql2,"asdfgh",4444);

    }


    public static void SqlSelect(String sql , Object...args) throws Exception {
        Connection coon = JdbcUtils.getConnection();
        PreparedStatement ps = coon.prepareStatement(sql);
        for (int i = 0; i < args.length;i++){
            ps.setObject(i+1,args[i]);
        }
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Account account = new Account();
            account.setName(rs.getString(1));
        }
    }
}

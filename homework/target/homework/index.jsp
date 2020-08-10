<%@ page contentType="text/html"%>
<%@page pageEncoding="GB2312"%>
<%@page import="java.sql.*" %>  <%--导入java.sql包--%>
<html>
<head>
    <title >从MySQL数据库中读出student表</title>
</head>
<body>
<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/homework";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        if(conn != null){
            out.print("数据库连接成功！");
            out.print("<br />");
%>
<table border="2">
    <tr>
        <td width="100" number="title">学号</td>
        <td width="100" name="title">姓名</td>
        <td width="100" age="title">年龄</td>
        <td width="100" age="title">性别</td>
        <td width="100" age="title">班级</td>
        <td width="100" age="title">地址</td>
    </tr>
    <%
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student;";  //查询语句
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        out.print("查询结果：");
        out.print("<br/>");
        while (rs.next()) {%>
    <tr>
        <td width="100" ><%=rs.getString("stu_id") %></td>
        <td width="100" ><%=rs.getString("stu_name") %></td>
        <td width="100"><%=rs.getString("stu_age") %></td>
        <td width="100"><%=rs.getString("stu_gender") %></td>
        <td width="100"><%=rs.getString("stu_class") %></td>
        <td width="100"><%=rs.getString("stu_address") %></td>
    </tr>
    <%
                }
            }else{
                out.print("连接失败！");
            }
        }catch (Exception e) {
            //e.printStackTrace();
            out.print("数据库连接异常！");
        }
    %>
</table>
</body>
</html>
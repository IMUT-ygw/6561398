<%@ page contentType="text/html"%>
<%@page pageEncoding="GB2312"%>
<%@page import="java.sql.*" %>  <%--����java.sql��--%>
<html>
<head>
    <title >��MySQL���ݿ��ж���student��</title>
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
            out.print("���ݿ����ӳɹ���");
            out.print("<br />");
%>
<table border="2">
    <tr>
        <td width="100" number="title">ѧ��</td>
        <td width="100" name="title">����</td>
        <td width="100" age="title">����</td>
        <td width="100" age="title">�Ա�</td>
        <td width="100" age="title">�༶</td>
        <td width="100" age="title">��ַ</td>
    </tr>
    <%
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM student;";  //��ѯ���
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        out.print("��ѯ�����");
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
                out.print("����ʧ�ܣ�");
            }
        }catch (Exception e) {
            //e.printStackTrace();
            out.print("���ݿ������쳣��");
        }
    %>
</table>
</body>
</html>
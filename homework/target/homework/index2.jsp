<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html"%>
<%@page pageEncoding="GB2312"%>
<%@page import="java.sql.*" %>  <%--����java.sql��--%>
<html>
<head>
    <title >��MySQL���ݿ��ж���student��</title>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="0" width="90%">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
    </tr>
    <c:forEach items="${findAll}" var="e">
        <td>${e.stuId}</td>
        <td>${e.stuName}</td>
        <td>${e.stuAge}</td>
    </c:forEach>
</table>

</body>
</html>
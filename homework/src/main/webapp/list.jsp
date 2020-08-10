<%--
  Created by IntelliJ IDEA.
  User: shilihua
  Date: 2020/6/22
  Time: 下午4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <form action="list" method="post">--%>
<%--        商品名称: <input type="text" name="pname" value="${pname}">--%>
<%--        <button>查询</button>--%>
<%--    </form>--%>
    <table border="1" cellspacing="0" cellpadding="5" width="90%">
        <tr>
            <td>编号</td>
            <td>商品名称</td>
            <td>单价</td>
        </tr>
        <c:forEach items="${findAll}" var="e">
            <td>${e.stuId}</td>
            <td>${e.stuName}</td>
            <td>${e.stuAge}</td>
        </c:forEach>
    </table>
</body>
</html>

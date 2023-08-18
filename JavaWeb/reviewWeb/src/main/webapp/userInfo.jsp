<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<H5>欢迎您：${uname}</H5>
<%--用户信息：<br>--%>
<%--Id：${u.id}<br>--%>
<%--Uname：${u.uname}<br>--%>
<%--Addr：${u.addr}<br>--%>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>id</th>
        <th>名字</th>
        <th>地址</th>
    </tr>
    <c:forEach items="${list}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.uname}</td>
        <td>${user.addr}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kanata
  Date: 2023/8/20
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
<h2>欢迎您：${user.username}</h2><br/>
<font color="red">${err}</font>
<font color="green">${info}</font>
<h3>品牌类别查询</h3>

<a href="addType.jsp"><input type="button" value="新增"></a><br>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌类别名称</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${types}" var="type" varStatus="status">
    <tr align="center">
        <td>${status.count}</td>
        <td>${type.typeName}</td>
        <td>
            <a href="${pageContext.request.contextPath}/deleteType?id=${type.id}">删除</a>
        </td>
    </tr>
    </c:forEach>
    <a href="main.jsp">返回主页</a>
</body>
</html>

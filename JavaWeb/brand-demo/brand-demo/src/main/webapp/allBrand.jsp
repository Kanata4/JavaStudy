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
<h2>欢迎您：${uname}</h2><br/>
<font color="red">${err}</font>
<font color="green">${info}</font>
<h3>查询</h3>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>类别</th>
        <th>操作</th>


    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">
    <tr align="center">
            <%--<td>${brand.id}</td>--%>
        <td>${status.count}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.ordered}</td>
        <td>${brand.description}</td>
        <c:if test="${brand.status == 1}">
            <td>启用</td>
        </c:if>
        <c:if test="${brand.status != 1}">
            <td>禁用</td>
        </c:if>
        <td>${brand.typeName}</td>
        <td>
            <a href="${pageContext.request.contextPath}/selectById?id=${brand.id}">修改</a>
            <a href="${pageContext.request.contextPath}/delete?id=${brand.id}">删除</a>
        </td>
    </tr>
    </c:forEach>
    <a href="main.jsp">返回主页</a>
</body>
</html>

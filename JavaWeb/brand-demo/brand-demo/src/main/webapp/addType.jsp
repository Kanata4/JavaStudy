<%--
  Created by IntelliJ IDEA.
  User: kanata
  Date: 2023/8/20
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>添加品牌类型</title>
</head>
<body>
<h2>欢迎您：${user.username}</h2><br/>
<h3>添加品牌类别</h3>
<font color="red">${error}</font>
<form action="${pageContext.request.contextPath}/addType" method="post">
    类别名称：<input name="typeName">
    <input type="submit" value="提交"><br>
    <a href="main.jsp">返回主页</a>
</form>
</body>
</html>

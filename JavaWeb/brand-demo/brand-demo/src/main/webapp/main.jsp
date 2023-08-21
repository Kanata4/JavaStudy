<%--
  Created by IntelliJ IDEA.
  User: kanata
  Date: 2023/8/20
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>主页</title>
</head>
<body>
<font color="red">${err}</font>
<h2>欢迎您：${user.username}</h2><br/>
<a href="${pageContext.request.contextPath}/selectAll"><input type="button" value="查询所有"></a><br>
<a href="addBrand.jsp"><input type="button" value="新增"></a><br>
<a href="${pageContext.request.contextPath}/logout"><input type="button" value="注销"></a><br>
<form action="${pageContext.request.contextPath}/selectByName" method="post">
    <input name="brandName">
    <input type="submit" value="查询">
</form>
<a href="${pageContext.request.contextPath}/allType"><input type="button" value="查询所有商品类别"></a><br>
<hr>
</body>
</html>

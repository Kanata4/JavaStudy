<%--
  Created by IntelliJ IDEA.
  User: kanata
  Date: 2023/8/15
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
<h2>欢迎您：${uname}</h2><br/>
    <h3>添加品牌</h3>
    <font color="red">${error}</font>

    <form action="/JSP814/addBrand" method="post">
        品牌名称：<input name="brandName"><br>
        企业名称：<input name="companyName"><br>
        排序：<input name="ordered"><br>
        描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
        状态：
        <input type="radio" name="status" value="0">禁用
        <input type="radio" name="status" value="1">启用<br>
        <input type="submit" value="提交">
    </form>
</body>
</html>

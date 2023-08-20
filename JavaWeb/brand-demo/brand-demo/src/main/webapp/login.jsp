<%--
  Created by IntelliJ IDEA.
  User: kanata
  Date: 2023/8/20
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<font color="green">${info}</font>
<font color="red">${err}</font>
<form action="${pageContext.request.contextPath}/login" id="form" method="post">
    用户名：<input name="username" type="text" value="${cookie.uname.value}"><br/>
    密码：<input name="password" type="password" value="${cookie.pwd.value}"><br/>
    <p>记住我：<input type="checkbox" name="rememberMe"/></p>
    <input type="submit" value="登录">
    <a href="register.jsp"><input type="button" value="注册"></a>
</form>
</body>
</html>

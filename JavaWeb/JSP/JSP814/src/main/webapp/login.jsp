<%--
  Created by IntelliJ IDEA.
  User: kanata
  Date: 2023/8/17
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<font color="red">${err}</font>
<font color="green">${info}</font>
<form action="${pageContext.request.contextPath}/login.do" id="form" method="post">
    用户名：<input name="username" type="text" value="${cookie.uname.value}"><br/>
    密码：<input name="password" type="password" value="${cookie.pass.value}"><br/>
    <p>记住我：<input type="checkbox" name="rememberMe"/></p>
    <div id="subDiv">
        <input type="submit" value="登陆">
        <input type="reset" value="重置">&nbsp;
        <a href="/JSP814/register.jsp"><input type="button" value="注册"></a><br>
    </div>
</form>
</body>
</html>

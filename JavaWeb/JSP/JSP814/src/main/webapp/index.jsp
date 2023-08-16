<html>
<body>
<h2>Hello World!</h2>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%
    System.out.println("hello,jsp~");
%>
<form action="/JSP814//login.do" method="post">
    用户名：<input name="username" type="text"><br/>
    密码：<input name="password" type="password"><br/>
    <input type="submit" value="登陆">
</form>
</body>
</html>

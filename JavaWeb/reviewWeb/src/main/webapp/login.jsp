<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>login</title>
</head>
<body>
<font color="red">
${err}
</font>
<form action="/reviewWeb/hello" method="post">
<%--    name 提交的参数的名字 --%>
    用户名：<input type="text" name="uname"/><br>
    年龄：<input type="text" name="age"/><br>
    爱好：<br>
    篮球<input type="checkbox" name="hobby" value="1">
    足球<input type="checkbox" name="hobby" value="2">
    骑车<input type="checkbox" name="hobby" value="3">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>

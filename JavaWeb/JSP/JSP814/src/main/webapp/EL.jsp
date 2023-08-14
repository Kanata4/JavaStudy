<%--
  Created by IntelliJ IDEA.
  User: kanata
  Date: 2023/8/14
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%
    //把变量存入当前页面的作用域（没用）
//    pageContext.setAttribute("age",22);

%>
age:${age}
    <h1>${myName}</h1>
</body>
</html>

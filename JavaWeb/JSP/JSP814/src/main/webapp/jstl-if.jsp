<%--
  Created by IntelliJ IDEA.
  User: kanata
  Date: 2023/8/14
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
    c:if：来完成逻辑判断，替换java if else
    --%>
    <c:if test="${status ==1}">
        启用
    </c:if>
    <c:if test="${status ==0}">
        禁用
    </c:if>
</body>
</html>

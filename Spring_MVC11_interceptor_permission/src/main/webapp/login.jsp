
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>>">
</head>
<body>
    模拟登录，将数据存入session，用以验证(模拟从数据库中读数据)
<%
    session.setAttribute("name","slb");
%>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>请求跳转到hello.jsp</h3>
    <h3>Name数据：${param.myName}</h3>
    <h3>Age数据:${param.myAge}</h3>
<%--上面等同于--%>
    <h3>取参数数据:<%=request.getParameter("myName")%></h3>
</body>
</html>

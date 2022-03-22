<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>注册学生</title>

</head>
<body>
<form action="student/addStudent.do" method="post">
<table>
    <tr>
        <td>姓名:<input type="text" name="name"></td>
    </tr>
    <tr>
        <td>邮箱:<input type="text" name="email"></td>
    </tr>
    <tr>
        <td>年龄:<input type="text" name="age"></td>
    </tr>
    <tr>
        <td><input type="submit" value="提交"></td>
    </tr>
</table>
</form>
</body>
</html>

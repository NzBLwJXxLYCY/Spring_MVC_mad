
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>功能入口</title>

</head>
<body>
<div align="center">
    <p style="color: crimson;font-size: xx-large">ssm整合</p>
    <img src="images/1.PNG" />

    <form action="addStudent.do" method="post">
        <table>
            <tr>
                <td><a href="addStudent.jsp">注册学生</a></td>
            </tr>
            <tr>
                <td><a href="listStudent.jsp">查询学生</a> </td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>

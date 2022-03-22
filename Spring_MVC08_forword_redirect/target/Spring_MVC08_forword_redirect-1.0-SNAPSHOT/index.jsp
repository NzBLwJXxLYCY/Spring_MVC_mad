
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
<p>ModelAndView实现forward</p>
<form action="doForward.do" method="post">
    <tr>
        <td>姓名：<input type="text" name="name"></td><br>
        <td>年龄：<input type="text" name="age"></td>
    </tr>
    <br/>
    <tr>
        <td><input type="submit" value="提交"></td>
    </tr>
</form>
<br/>
<p>ModelAndView实现redirect</p>
<form action="doRedirect.do" method="post">
    <tr>
        <td>姓名：<input type="text" name="name"></td><br>
        <td>年龄：<input type="text" name="age"></td>
    </tr>
    <br/>
    <tr>
        <td><input type="submit" value="提交"></td>
    </tr>
</form>
<br/>
<img src="static/images/1.PNG" alt="我是一张静态图片">
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>处理器方法返回String表示视图名称</p>
<form action="returnString.do" method="post">
    <tr>
        <td>姓名：<input type="text" name="name"></td><br>
        <td>年龄：<input type="text" name="age"></td>
    </tr>
    <br/>
    <tr>
        <td><input type="submit" value="提交"></td>
    </tr>
</form>
</body>
</html>

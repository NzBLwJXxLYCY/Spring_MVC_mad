
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>接收用户提交的参数</p>
<form action="receiveParam.do" method="post">
    <tr>
        <td>姓名：<input type="text" name="name"></td><br>
        <td>年龄：<input type="text" name="age"></td>
    </tr>
    <br/>
    <tr>
        <td><input type="submit" value="提交"></td>
    </tr>


</form>
<form action="receiveParam1.do" method="post">
    <tr>
        <td>姓名：<input type="text" name="Name"></td><br>
        <td>年龄：<input type="text" name="Age"></td>
    </tr>
    <br/>
    <tr>
        <td><input type="submit" value="提交"></td>
    </tr>


</form>

<p>使用对象接收用户提交的参数</p>
<form action="receiveObject.do" method="post">
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

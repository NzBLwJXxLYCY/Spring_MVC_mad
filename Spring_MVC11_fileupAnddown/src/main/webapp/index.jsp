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
<p>文件上传和下载</p>
<a href="fileUp.do">文件下载</a><br/>
<form action="fileDown.do" method="post" enctype="multipart/form-data">
    头像：<input type="file" name="photo"><br/>
          &nbsp;&nbsp;<input type="submit" value="提交">
</form>
</body>
</html>

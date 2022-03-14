
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"returnVoid_ajax.do",
                    data:{
                        name:"zhangsan",
                        age:20
                    },
                    type:"post",
                    dataType:"json",
                    success:function (resp) {
                        //resp是服务器端返回的json格式的字符串  {"name":"zhangsan","age":20}
                        //jquery会把字符串转为json对象，赋值给resp形参
                        alert(resp.name+"牛的==="+resp.age);
                    }
                })
            })
        })
    </script>
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
<br/>
<button id = "btn">发起ajax请求</button>
</body>
</html>

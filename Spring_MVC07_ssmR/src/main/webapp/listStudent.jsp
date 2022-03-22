
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            //在页面dom对象加载后，执行loadStudentData()
                LoadStudentData();
            $("#button").click(function () {
                LoadStudentData();
            })
        })
        
        function LoadStudentData() {
            $.ajax({
                url:"student/queryStudent.do",
                type:"get",
                dataType:"json",
                success:function (data) {
                    //每次要清除旧的数据
                    $("#info").html("")
                    //增加数据
                    $.each(data,function (i,n) {

                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.email+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("</tr>")
                    })
                }
            })
            
        }
    </script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
                <td>学生</td>
                <td>姓名</td>
                <td>邮箱</td>
                <td>年龄</td>
            </thead>

            <tbody id="info">

            </tbody>
        </table>
        <input id = "button" type="submit" value="提交">
    </div>
</body>
</html>

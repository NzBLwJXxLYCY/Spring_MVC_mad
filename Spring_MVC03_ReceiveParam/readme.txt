Spring_MVC03:接受请求参数
接受请求参数，使用的是处理器方法的形参
1)HttpServletRequest
2)HttpServletResponse
3)HttpSession
4)用户提交的数据

接受用户提交的数据
1)逐个接收
2)对象接收


注意：
get请求，无中文乱码问题
post请求，存在中文乱码问题

如何解决？
使用过滤器 CharacterEncodingFilter
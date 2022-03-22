使用拦截器验证登录

异常处理步骤：
1.新建maven web项目
2.加入依赖
3.创建Controller
4.创建show.jsp
5.创建login.jsp，模拟登录(把用户的信息放到session)
  创建一个jsp，logout.jsp模拟退出系统(从session中删除数据)
6.创建拦截器，从session中获取用户的登录信息，验证是否能访问系统
7.创建springMVC的配置文件
    1)组件扫描器，扫描@Controller注解
    2)声明拦截器，并指定拦截的请求uri地址

这边的session其实模拟的就是一个数据库读用户信息的操作
Spring_MVC01
需求：用户发起一个请求，请求交给SpringMVC的控制器对象，
      并显示请求的处理结果


实现步骤：
1.新建web maven工程
2.加入依赖
    springMVC依赖
    jsp依赖
    servlet依赖
3.重点：在web.xml中注册springMvc框架的核心对象DispatcherServlet(有了这个对象，才能说明你用了SpringMvc)
        1)DispatcherServlet叫做中央调度器，是一个Servlet，它的父类是继承HttpServlet
        2)DispatcherServlet也叫做前端控制器(front controller)
        3)DispatcherServlet负责接收用户提交的请求，调用其他的控制器对象，
                        并把请求的处理结果显示给用户
4.创建一个发起请求的页面
5.创建控制器类
    1)在类的上面加入@Controller注解，创建对象，并放入springMvc容器中
    2)在类的方法上面加入@RequestMapping注解

6.创建一个作为结果的JSP
7.创建一个springMvc的配置文件
    1)声明组件扫描器，指定@Controller注解所在的包名
    2)声明视图解析器，帮助处理视图的
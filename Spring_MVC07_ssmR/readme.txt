Spring_MVC06_SSM：SSM整合开发

SpringMVC:视图层，接收用户请求
Spring：业务层，管理Service，dao，工具类对象
Mybatis：持久层，访问数据库

用户发起请求--SpringMVC接收--Spring中的service对象--Mybatis访问数据库

SSM整合
1.第一个容器SpringMVC容器，管理Controller控制器对象的
2.第二个容器Spring容器，管理service、dao、工具类对象的
我们要做的就是将对象交给合适的容器创建，管理。
把Controller还有web开发所需要的对象交给SpringMVC容器创建管理

把service、dao、工具类等对象，交给spring配置文件去创建管理

springMVC容器是spring容器的子容器，类似于java中的继承。子可以访问父的内容。
在子容器中Controller可以访问父容器中的Service对象就可以实现Controller使用service对象


步骤：
1.新建maven项目
2.加入依赖
    springMVC、spring、mybatis三个框架的依赖，jackson依赖，musql驱动、druid连接池
    jsp、servlet依赖

3.写web.xml
    1）注册DispatcherServlet，目的：1.创建springMVC容器对象，才能创建Controller类对象
                                   2.创建Servlet，才能接收用户的请求


    2)注册spring的监听器：ContextLoaderListener，目的：创建spring的容器对象，创建service，dao等对象

    3)注册字符集过滤器，解决post请求乱码的问题


4.创建包，Controller包，service，dao，实体类包名创建好
5.写springMVC、spring、mybatis的配置文件
    1)springMVC配置文件
    2)spring配置文件
    3）mybatis主配置文件
    4)数据库的属性配置文件

6.写代码，dao接口和mapper文件，service和实现类，controller、实体类
7.写jsp页面




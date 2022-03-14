Spring_MVC04_Return:处理器方法的返回值表示请求的处理结果
1.ModelAndView：有数据和视图，对视图执行forward
2.String:表示视图，可以逻辑名称，也可以是完整的视图路径
3.void:不能表示数据，也不能表示视图。
    在处理ajax的时候，可以使用void返回值。通过HttpServletResponse输出数据。响应ajax请求，
    ajax请求服务器端返回的数据，和视图无关

4.Object：例如String，Integer，Map，List，Student等等都是对象，
            对象有属性，属性就是数据。所以返回Object表示数据，和视图无关
            可以使用对象表示的数据，响应ajax请求。


    现在做ajax，主要使用json的数据格式
    框架实现步骤：
    1.加入处理json工具库的依赖，springMVC默认使用jackson
    2.在springMVC配置文件之间加入<mvc:annotation-driven>注解驱动
       此步骤代替原始ajax：ObjectMapper om = new ObjectMapper();
                          json=om.writeValueAsString(student);将对象转为json格式这一步
    3.在处理器的上面加入@ResponseBody注解
       此步骤代替原始ajax:PrintWriter out = response.getWriter();
                         out.println(json); 将json数据返回给前端



    springMVC处理器方法返回Object，可以转为json输出到浏览器，响应ajax请求的内部原理
    1.<mvc:annotation-driven> 注解驱动
        注解驱动的功能是：完成java对象到json、xml、text等数据格式的转换
        <mvc:annotation-driven>在加入到springMVC配置文件之后，会自动创建HttpMessageConverter接口的
        七个实现类 例如：MappingJackson2HttpMessageConverter(使用jackson中的ObjectMapper将java对象转为json字符串)
        底层实现是：HttpMessageConverter接口

        这个接口有很多实现类，这些实现类完成了java对象到json、xml、二进制等数据格式的转换


        HttpMessageConverter接口中的方法
        下面这两个方法是控制器类把结果输出给浏览器时使用的：
        boolean canWrite(Class<?> var1, MediaType var2);
        void write(T var1, MediaType var2, HttpOutputMessage var3)；

        例如处理器方法
         @RequestMapping(value = "/returnString.do")
            public String doReturnView(HttpServletRequest request,String name,Integer age){
                Student st = new Student();
                st.setName("zhangsan");
                st.setAge(20);
                return st;
            }

            1)canWrite作用检查处理器方法的返回值，能不能转为var2表示的数据格式，包括json、text、xml等等
            2）write：把处理器方法的返回值对象，调用jackson中的ObjectMapper转换为json字符串
                         json=om.writeValueAsString(student);


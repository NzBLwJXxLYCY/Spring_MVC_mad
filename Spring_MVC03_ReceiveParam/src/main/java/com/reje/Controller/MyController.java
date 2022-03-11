package com.reje.Controller;

import com.reje.vo.Student;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class MyController {
    /**
     *逐个接收请求参数：
     *  要求：控制器方法的形参和请求中参数名必须一致
     *        同名的请求参数赋值给同名的形参
     *
     * 框架接收请求参数，框架内部自动帮你做的
     * 1.使用request对象接收请求参数，也就是下面两行的操作
     *      String name =request.getParameter("name");
     *      String age =request.getParameter("age");
     * 2.springMvc框架通过DispatcherServlet调用MyController的doSome()方法
     *      调用方法时，按照名称的对应，把接收的参数赋值给形参
     *      并且框架自身会提供类型转换的功能，能把String类型转换为int,long,double类型等
     *         doSome(Str name,Integer.valueOf(age))
     *
     *      以往的servlet我们获取请求的数据是需要通过request的，现在框架帮我们在内部自动实现了
     * 400状态码：客户端提交参数错误
     */

    @RequestMapping(value = "/receiveParam.do")
    public ModelAndView doSome(String name,Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 处理请求参数名和处理器方法的形参名不一样
     * @RequestParam：解决请求中参数名和形参名不一样的问题
     *             属性：1.value 请求中的参数名
     *                  2.required 是一个boolean，默认是true
     *                         true：表示请求中必须含有此参数
     *             位置：在形参定义的前面
     */
    @RequestMapping(value = "/receiveParam1.do")
    public ModelAndView doSome1(@RequestParam("Name") String name, @RequestParam("Age") Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", name);
        mv.addObject("myAge", Integer.valueOf(age));
        mv.setViewName("show");
        return mv;
    }

    /**
     *
     * 控制器的形参是java对象，并且java对象的属性和请求参数一致
     * 框架会自动帮你创建形参对象，并且使用set方法，完成属性注入，你只需用get方法获取值即可
     * @return
     */
    @RequestMapping(value = "/receiveObject.do")
    public ModelAndView doSome2(Student myStudent) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName", myStudent.getName());
        mv.addObject("myAge", myStudent.getAge());
        mv.addObject("myStudent",myStudent);
        mv.setViewName("show");
        return mv;
    }
}

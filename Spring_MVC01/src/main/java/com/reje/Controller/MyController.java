package com.reje.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller：创建处理器对象，对象放在springmvc容器中
 * 位置：在类的上面
 * 和spring中讲的@Service，@Component
 */
@Controller
public class MyController {
    /**
     * 处理用户提交的请求，springMvc中是使用方法来处理的。
     * 方法：是自定义的，可以有多种返回值，多种参数，方法名称自定义
     */

    /**
     * 准备使用doSome方法处理some.do请求
     * @RequsetMapping：请求映射，作用是把一个请求地址和一个方法绑定在一起。
     *                  一个请求指定一个方法处理
     *        属性：1.value是一个String，表示请求的url地址的(some.do)
     *                value的值必须是唯一的，不能重复。在使用时，推荐地址以"/"
     *
     *        位置：1.在方法的上面，常用的
     *             2.在类的上面
     *说明：使用@RequsetMapping修饰的方法叫做处理器方法或者控制器方法
     *      使用@RequestMapping修饰的方法可以处理请求，类似Servlet中的doGet，doPost
     *
     *返回值：ModelAndView 表示本次请求的处理结果
     * Model：数据，请求处理数据完成后，显示给用户的数据
     * View：视图，比如jsp等等
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){   //doGet()-----调用service层请求处理
        //使用doSome处理some.do请求
        ModelAndView mv = new ModelAndView();
        //添加数据,框架在请求的最后把数据放到request作用域
        //相当于servlet中request.setAttribute("msg","欢迎使用第一个springMVC项目")
        mv.addObject("msg","欢迎使用第一个springMVC项目");
        mv.addObject("fun","执行的是doSome方法");

        //指定视图，指定视图的完整路径
        //框架对视图执行的forward操作，
        // 相当于servlet中的request.getRequestDispatcher(/show.jsp).forward(request,response)
        //mv.setViewName("/show.jsp");

        //框架就会使用视图解析器帮你拼接前缀+逻辑名称+后缀 组成路径
        mv.setViewName("show");
        return mv;


        //这样在请求转发后跳转的网页中的request，response和转发前的是一样的，包括request中的数据

    }
}

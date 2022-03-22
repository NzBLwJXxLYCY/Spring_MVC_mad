package com.reje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
    /**
     *处理器方法返回ModelAndView，实现转发forward
     * 语法：setViewName("forward:视图文件完整路径")
     *forward特点：不和视图解析器一同使用，就当项目中的没有视图解析器
     * @return
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doSome(String name,Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //显式转发
        //使用forward关键字的原因在于，不是所有请求转发都是视图解析下的路径
        //如果我要访问的路径不是视图解析的路径，那么就可以用forward+完整的视图进行跳转
        //mv.setViewName("forward:/WEB-INF/view/show.jsp");
        mv.setViewName("forward:/hello.jsp");
        return mv;
    }
    /**
     *处理器方法返回ModelAndView，实现转发redirect
     * 语法：setViewName("redirect:视图文件完整路径")
     *redirect特点：不和视图解析器一同使用，就当项目中的没有视图解析器
     *
     * 框架对重定向的操作：
     * 1.框架会把Model中的简单类型的数据转为String使用，作为hello.jsp的get请求参数使用。
     *   目的是在doRedirect.do和hello.jsp两次请求之间传递数据
     * 2.在目标hello.jsp页面可以使用参数集合对象${param}获取请求参数值
     *      ${param.myName}
     * 3.redirect不能对/WEB-INF下的资源重定向
     */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doWithRedirect(String name,Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }
}

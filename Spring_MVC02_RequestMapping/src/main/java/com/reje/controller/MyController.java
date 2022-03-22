package com.reje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
/**
 * @RequestMapping:在类的上面，表示所有请求的公共部分，叫做模块名称
 */
@RequestMapping("/user")
public class MyController {
    /**
     * @RequsetMapping:请求映射
     *                  属性：method，表示请求的方式。它的值RequestMapping类 枚举值
     *                  例如表示get请求方式，RequestMethod.GET
     *                         post请求方式，RequestMethod.POST
     *
     */
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest request,
                               HttpServletResponse response,
                               HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","欢迎使用第一个springMVC项目===="+request.getParameter("name"));
        mv.addObject("fun","执行的是doSome方法");
        mv.setViewName("show");
        return mv;
    }
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","====欢迎使用第二个springMVC项目====");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("other");
        return mv;


    }
}

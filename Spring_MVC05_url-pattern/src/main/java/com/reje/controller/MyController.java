package com.reje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
    /**
     *处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     *
     * @return
     */
    @RequestMapping(value = "/doSome.do")
    public ModelAndView doSome(String name,Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        mv.setViewName("show");

        //项目中配置了视图解析器
        //框架对视图执行forward转发操作
        return mv;
    }
}

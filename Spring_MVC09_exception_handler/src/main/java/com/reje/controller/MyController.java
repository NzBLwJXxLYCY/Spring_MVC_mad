package com.reje.controller;

import com.reje.exception.AgeException;
import com.reje.exception.MyUserException;
import com.reje.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
    @RequestMapping(value ="/some.do")
    public ModelAndView doException(String name,Integer age)
            throws MyUserException {
        ModelAndView mv = new ModelAndView();
        if(!"zs".equals(name)){
            throw  new NameException("你输入的姓名有误");
        }
        if(age==null||age>80){
            throw new AgeException("一大把年纪了还来卷是吧");
        }
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        mv.setViewName("show");
        return mv;
    }
}

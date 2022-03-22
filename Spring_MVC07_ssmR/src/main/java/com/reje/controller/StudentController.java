package com.reje.controller;

import com.reje.domain.Student;
import com.reje.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        //调用service处理student对象
        String tips = "注册失败";
        int i = service.AddStudent(student);
        System.out.println(student.getName());
        if(i>0){
            tips="学生["+student.getName()+"]注册成功";
        }
        mv.addObject("tips",tips);
        mv.setViewName("result");
        return mv;
    }
    //处理查询，响应ajax
    //如何查看当前程序是否正常运行，直接在地址栏访问这个地址
    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        List<Student> studentList = service.FindStudent();
        return studentList;
    }
}

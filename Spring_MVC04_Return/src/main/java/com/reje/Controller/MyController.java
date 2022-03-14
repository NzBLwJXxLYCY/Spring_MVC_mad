package com.reje.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class MyController {
    /**
     *处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     *
     * @return
     */
    @RequestMapping(value = "/returnString.do")
    public String doReturnView(HttpServletRequest request,String name,Integer age) {
        //手工添加数据到作用域
        request.setAttribute("myName",name);
        request.setAttribute("myAge",age);
        //项目中配置了视图解析器
        //框架对视图执行forward转发操作
        return "show";
    }
    //处理器处理返回void，处理ajax请求
    @RequestMapping(value = "/returnVoid_ajax.do")
    public void doReturnVoid(HttpServletResponse response,String name,Integer age)
            throws JsonProcessingException {
        Student student =new Student();
        student.setName(name);
        student.setAge(age);
        String json = "";
        if(student!=null){
            ObjectMapper om = new ObjectMapper();
            json=om.writeValueAsString(student);
        }
        response.setContentType("application/json;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

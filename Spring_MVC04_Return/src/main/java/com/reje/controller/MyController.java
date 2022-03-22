package com.reje.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reje.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


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

    /**
     * 处理器方法返回一个Student，通过框架转为json，响应ajax请求
     * @Responsebody：
     *      作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器
     *      位置：方法定义的上面。和其他注解没有顺序的关系。
     *
     * 返回对象框架的处理流程
     * 1.框架会返回Student类型，调用框架中的ArrayList<HttpMessageConverter>中的每个类的canWrite()方法
     *      检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据——MappingJackson2HttpMessageConverter
     *
     * 2.框架会调用实现类的write(),MappingJackson2HttpMessageConverter的write()方法
     *   把李四同学的student对象转换为json，调用Jackson的ObjectMapper 转换为json
     *
     * 3.框架会调用@ResponseBody把2的结果数据输出到浏览器，ajax请求处理完成
     *
     *
     */
    @RequestMapping(value = "/returnJsonObject.do")
    @ResponseBody
    public Student doStudentJsonObject(HttpServletResponse response,String name,Integer age){
        Student st = new Student();
        st.setName("孙令博");
        st.setAge(25);
        return st;//会被框架转换为json
    }

    /**
     * 处理器返回的是list集合
     */
    @RequestMapping(value = "/returnJsonObjectArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(HttpServletResponse response,String name,Integer age){
        List<Student> list = new ArrayList<>();
        Student st = new Student();
        st.setName("孙令博");
        st.setAge(25);
        list.add(st);

        st = new Student();
        st.setAge(26);
        st.setName("这种失落会持久吗");
        list.add(st);
        return list;//会被框架转换为json数组
    }
    /**
     * 处理器返回的是String，String表示的数据，不是视图
     * 区分返回值String是数据，还是视图。就看有没有@ResponseBody注解
     * 如果有@ResponseBody注解，返回String就是数据，反之就是视图
     *
     *当前端dataType改成text后，后端默认使用"text/plain;charset=ISO-8859-1"作为contentType导致中文有乱码
     * 解决方案：给RequestMapping增加一个produces
     *
     * 返回对象框架的处理流程
     *      1.框架会返回String类型，调用框架中的ArrayList<HttpMessageConverter>中的每个类的canWrite()方法
     *            检查哪个HttpMessageConverter接口的实现类能处理String类型的数据——StringHttpMessageConverter
     *
     *      2.框架会调用实现类的write(),StringHttpMessageConverter的write()方法
     *         把字符按照指定的编码处理"text/plain;charset=ISO-8859-1"
     *
     *      3.框架会调用@ResponseBody把2的结果数据输出到浏览器，ajax请求处理完成
     */
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,String age){
        return "hello,SpringMVC，返回的数据";
    }

}

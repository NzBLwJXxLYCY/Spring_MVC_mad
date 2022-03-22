package com.reje.handler;

import com.reje.exception.AgeException;
import com.reje.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

    @ControllerAdvice
    /**
     * @ControllerAdvice:控制器增强
     */
    public class GlobalExceptionHandler {
        //定义方法，处理发生的异常
        /**
         * 处理异常的方法和控制器的方法一样，可以有多个参数，可以有ModelAndView，String，void，
         *
         * 形参：Exception，表示Controller中抛出异常的对象
         * 通过形参可以获取发生异常的信息
         *
         *
         * @ExceptionHandler(异常的class)：表示异常的类型，当发生此类型的异常的时候，由当前方法处理
         */
        @ExceptionHandler(value = NameException.class)
        public ModelAndView doNameException(Exception ex){
            //处理NameException的异常
            /**
             * 处理异常的逻辑：
             * 1.需要把异常记录下来，记录到数据库，日志文件
             *    记录日志发生的时间，哪个方法发生的，异常错误内容
             * 2.发送通知，把异常的信息通过邮件，短信，微信发送给相关人员
             * 3.给用户友好的提示
             */
            ModelAndView mv =new ModelAndView();
            mv.addObject("msg","姓名byd必须是博人");
            mv.addObject("ex",ex);
            mv.setViewName("nameError");
            return mv;
        }
        //处理AgeException
        @ExceptionHandler(value = AgeException.class)
        public ModelAndView doAgeException(Exception ex){
            ModelAndView mv = new ModelAndView();
            mv.addObject("msg","80岁了，差不多德勒");
            mv.addObject("ex",ex);
            mv.setViewName("ageError");
            return mv;

        }
        //处理其他类型的异常
        @ExceptionHandler
        public ModelAndView doException(Exception ex) {
            ModelAndView mv = new ModelAndView();
            mv.addObject("msg", "ImmatureMeSlbssss");
            mv.addObject("ex", ex);
            mv.setViewName("defaultError");
            return mv;
        }
    }

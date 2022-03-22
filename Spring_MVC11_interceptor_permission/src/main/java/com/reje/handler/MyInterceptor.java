package com.reje.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器类：拦截用户请求
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("11111-preHandle执行了");
        Object name = request.getSession().getAttribute("name");
        String loginName = "";
        if(name!=null){
            loginName = (String) name;
        }
        if(!"slb".equals(loginName)){
            request.getRequestDispatcher("tips.jsp").forward(request,response);
            return false;
        }

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("11111-postHandle执行了");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("11111-afterCompletion执行了");
    }
}

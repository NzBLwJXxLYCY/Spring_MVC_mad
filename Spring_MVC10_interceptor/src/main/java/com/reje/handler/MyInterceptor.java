package com.reje.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器类：拦截用户请求
public class MyInterceptor implements HandlerInterceptor {
    /**
     *preHandle:预处理方法
        该方法在处理器方法执行之前执行。
        其返回值为 boolean，若为 true，则紧接着会执行处理器方
        法，且会将 afterCompletion()方法放入到一个专门的方法栈中等待执行

        参数：Object handler：被拦截的控制器对象
     特点：
     1.在控制器方法执行之前执行

     2.在这个方法中可以验证信息是否符合要求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("11111-preHandle执行了");
        request.getRequestDispatcher("tips.jsp").forward(request,response);
        return false;
    }

    /**
     *postHandle:后处理方法
     * 特点：
     * 1.在some.do方法之后执行
     * 2.能够获取处理器的返回值 ModelAndView，并做二次修改，修改跳转方向
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("11111-postHandle执行了");
    }

    /**
     *afterCompletion:最后执行的方法
     * 在请求处理完成过后执行。框架中规定当你视图处理完成后，对视图执行了forward，就认为处理完成
     * 一般是做资源回收工作，程序请求中创建了一些对象，可以在这里删除
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("11111-afterCompletion执行了");
    }
}

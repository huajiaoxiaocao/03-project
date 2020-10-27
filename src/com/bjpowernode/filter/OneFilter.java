package com.bjpowernode.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //1.调用请求对象读取请求包中请求行中URI，了解用户访问的资源文件是谁
        String uri = request.getRequestURI(); //[/网站名/资源名]
        //2.如果本次请求资源文件与登录相关【login.html 或则 LoginServlet】应该无条件放行
        if(uri.indexOf("login") != -1 || "/myWeb/".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //3.如果这次访问的是其他资源文件，需要得到用户在服务端HttpSession
        HttpSession session = request.getSession(false);
        if (session!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //4.拒绝请求
        request.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);


        /*
        // HttpServletResponse response = (HttpServletResponse) servletResponse; //为了简便，直接请求转发
        //1.拦截后，通过请求对象向Tomcat索要当前用户的HttpSession
        HttpSession session = request.getSession(false);
        //2.判断来访用户身份合法性
        if(session == null){
            request.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);
            return;
        }
        // 3.放行
        filterChain.doFilter(servletRequest, servletResponse);
        */
    }
}

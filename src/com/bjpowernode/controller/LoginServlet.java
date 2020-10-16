package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        int result;
        UserDao dao = new UserDao();
        //1.通知请求对象使用utf-8对请求体内容进行重写编辑
        request.setCharacterEncoding("utf-8");
        //2.调用请求对象读取请求体参数信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        //3.调用DAO将查询验证命令发送到数据库服务器
        result = dao.login(userName, password);
        //4.根据验证结果，将对应【资源文件地址】发送给浏览器
        if(result==1) {//用户存在
            response.sendRedirect("/myWeb/index.html");
        }else{
            response.sendRedirect("/myWeb/login_error.html");
        }
    }
}

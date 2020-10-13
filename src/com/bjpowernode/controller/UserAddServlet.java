package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, password, sex, email;
        UserDao userDao = new UserDao();
        Users user = null;
        int result = 0;
        //1.【调用请求对象】读取【请求头】参数信息，得到用户的信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        //2.【调用userdao】将用户信息填充到insert命令并借助于jdbc规范发送到数据库服务器

        user = new Users(null,userName, password, sex, email);
        result = userDao.add(user);
        //3.【调用响应对象】将【处理结果】以二进制形式写入到响应体
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        if(result == 1){
            pw.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        }else{
            pw.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
            pw.print(result);
        }
        // Tomcat负责销毁【请求对象】和【响应对象】
        // Tomcat负责将HTTP响应协议包推送到发起请求的浏览器上
        // 浏览器根据响应头content-type指定编译器对响应体二进制内容进行编辑
        // 浏览器将编辑后结果在窗口展示给用户后结束
    }
}

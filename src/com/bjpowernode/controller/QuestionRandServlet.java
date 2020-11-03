package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        List questionlist = null;
        HttpSession session =request.getSession(false);
        //调用DAO对象，从question表中拿取四道题目
        questionlist = dao.findRand();
        //将题目添加到session作为共享数据传递
        session.setAttribute("key", questionlist);
        //通过请求转发调用jsp文件将四道题目写入响应体
        request.getRequestDispatcher("/exam.jsp").forward(request, response);
    }
}

package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        //[调用请求对象]获取请求头中的请求参数中的题目编号
        String questionId = request.getParameter("questionId");
        int result = dao.delete(Integer.valueOf(questionId));
        request.setAttribute("key", result);
        request.getRequestDispatcher("/delete.jsp").forward(request, response);
    }
}

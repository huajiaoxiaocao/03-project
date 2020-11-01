package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        //1.调用请求对象读取请求头中参数信息，得到试题参数
        String questionId = request.getParameter("questionId");
        //2.调用Dao推送查询命令得到这个试题编号的试题信息
        Question question = dao.findById(questionId);
        //3.调用question_update.jsp将试题信息写入到响应体
        request.setAttribute("key", question);
        request.getRequestDispatcher("/question_update.jsp").forward(request, response);

    }
}

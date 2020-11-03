package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId, title, optionA, optionB, optionC, optionD, answer;
        QuestionDao dao = new QuestionDao();
        int result;
        //1.调用请求对象读取请求头参数信息
        questionId = request.getParameter("questionId");
        title=request.getParameter("title");
        optionA=request.getParameter("optionA");
        optionB=request.getParameter("optionB");
        optionC=request.getParameter("optionC");
        optionD=request.getParameter("optionD");
        answer=request.getParameter("answer");
        //2.调用Dao实现更新操作
        Question question = new Question(Integer.valueOf(questionId),title, optionA,optionB,optionC,optionD,answer);
        result = dao.update(question);
        //3.调用info.jsp将操作结果写入到响应体中
        if(1 == result){
            request.setAttribute("info", "试题更新成功");
        }else{
            request.setAttribute("info", "试题更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);

    }
}

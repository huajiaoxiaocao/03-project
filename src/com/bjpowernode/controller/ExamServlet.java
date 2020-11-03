package com.bjpowernode.controller;

import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ExamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int score = 0;
        // 从当前用户私人储物柜得到系统提供的四道题目信息
        List<Question> questionList = (List)session.getAttribute("key");
        // 从每个question取出答案
        for(Question question: questionList){
            String answer = request.getParameter("answer_" + question.getQuestionId());
            if(question.getAnswer().equals(answer)){
                score+=25;
            }
        }
        // 将分数写入request,作为共享数据
        request.setAttribute("info", "本次成绩为：" + score);
        // 请求转发调用jsp,将用户本次考试分数写入到响应体
        request.getRequestDispatcher("/info.jsp").forward(request,response);

    }
}

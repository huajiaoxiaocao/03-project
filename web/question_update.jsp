<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: 华东校草
  Date: 2020/10/31
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Question question = (Question) request.getAttribute("key");

    %>
    <center>
        <form action="/myWeb/question/update" method="get">
            <table border="2">
                <tr>
                    <td>题目编号：</td>
                    <td><input type="text" name="questionId" value="<%=question.getQuestionId()%>" readonly></td>
                </tr>
                <tr>
                    <td>题目:</td>
                    <td><input type="text" name="title" value="<%=question.getTitle()%>"></td>
                </tr>
                <tr>
                    <td>选项A:</td>
                    <td><input type="text" name="optionA" value="<%=question.getOptionA()%>"></td>
                </tr>
                <tr>
                    <td>选项B:</td>
                    <td><input type="text" name="optionB" value="<%=question.getOptionB()%>"></td>
                </tr>
                <tr>
                    <td>选项C:</td>
                    <td><input type="text" name="optionC" value="<%=question.getOptionC()%>"></td>
                </tr>
                <tr>
                    <td>选项D:</td>
                    <td><input type="text" name="optionD" value="<%=question.getOptionD()%>"></td>
                </tr>
                <tr>
                    <td>答案</td>
                    <td><input type="radio" name="answer" value="A" <%="A".equals(question.getAnswer())?"checked":""%>>A
                        <input type="radio" name="answer" value="B" <%="B".equals(question.getAnswer())?"checked":""%>>B
                        <input type="radio" name="answer" value="C" <%="C".equals(question.getAnswer())?"checked":""%>>C
                        <input type="radio" name="answer" value="D" <%="D".equals(question.getAnswer())?"checked":""%>>D
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="更新试题"></td>
                    <td><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>

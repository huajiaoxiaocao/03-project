<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: 华东校草
  Date: 2020/10/31
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <table border="2">
            <tr>
                <td>题目编号</td>
                <td>题目信息</td>
                <td>选项A</td>
                <td>选项B</td>
                <td>选项C</td>
                <td>选项D</td>
                <td>答案</td>
                <td>试题操作</td>
            </tr>
            <%
                List<Question> list = (List) request.getAttribute("key");
                for(Question question:list){
            %>
            <tr>
                <td><%=question.getQuestionId()%></td>
                <td><%=question.getTitle()%></td>
                <td><%=question.getOptionA()%></td>
                <td><%=question.getOptionB()%></td>
                <td><%=question.getOptionC()%></td>
                <td><%=question.getOptionD()%></td>
                <td><%=question.getAnswer()%></td>
                <td><a href="/myWeb/question/delete?questionId=<%=question.getQuestionId()%>">删除试题</a></td>
                <td><a href="/myWeb/question/findById?questionId=<%=question.getQuestionId()%>">详细信息</a></td>
            </tr>
            <%
                };
            %>
        </table>
    </center>
</body>
</html>

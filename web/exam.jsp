<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: 华东校草
  Date: 2020/11/3
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <%
            List<Question> questionlist = (List)session.getAttribute("key");
        %>
        <form action="/myWeb/question/exam">
            <table border="2">
                <tr>
                    <td>试题题号</td>
                    <td>题目</td>
                    <td>A选项</td>
                    <td>B选项</td>
                    <td>C选项</td>
                    <td>D选项</td>
                    <td>答案</td>
                </tr>
                <%
                    for(Question question:questionlist){
                %>
                        <tr>
                            <td><%=question.getQuestionId()%></td>
                            <td><%=question.getTitle()%></td>
                            <td><%=question.getOptionA()%></td>
                            <td><%=question.getOptionB()%></td>
                            <td><%=question.getOptionC()%></td>
                            <td><%=question.getOptionD()%></td>
                            <td>
                                <input type="radio" name="answer_<%=question.getQuestionId()%>" value="A">A
                                <input type="radio" name="answer_<%=question.getQuestionId()%>" value="B">B
                                <input type="radio" name="answer_<%=question.getQuestionId()%>" value="C">C
                                <input type="radio" name="answer_<%=question.getQuestionId()%>" value="D">D
                            </td>
                        </tr>
                <%
                    };
                %>
                <tr align="center">
                    <td colspan="3"><input type="submit" value="交卷"></td>
                    <td colspan="4"><input type="reset" value="重置"></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>

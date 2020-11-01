<%--
  Created by IntelliJ IDEA.
  User: 华东校草
  Date: 2020/10/31
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int result;
        result = (int)request.getAttribute("key");
        if(result == 0){
            %>
        <font style="color: red;font-size: 20px">删除试题失败</font>
    <%
        }else{
            %>
        <font style="color: red;font-size: 20px">删除试题成功</font>

    <%
        };
    %>
</body>
</html>

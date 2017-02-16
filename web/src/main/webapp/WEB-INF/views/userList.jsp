<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/4/8
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<center>
    <h1>个人管理</h1>
    <h5>2：超级管理员;1：管理员;0：普通用户;</h5>
    <table style="text-align: center;font-size: 30px" border="1">
        ${message}
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>等级</th>
            <th>删除</th>
            <th>增加</th>
            <th>编辑</th>
        </tr>
        <c:forEach items="${list}" var="user" varStatus="status" >
            <tr>
                <td>${status.index+1}</td>
                <td>${user.uname}</td>
                <td>${user.isadmin}</td>
                <td><a href="${website}user/delete/${user.uid}">删除</a></td>
                <td><a href="${website}user/form">增加</a></td>
                <td><a href="${website}user/edit/${user.uid}">编辑</a></td>
            </tr>
        </c:forEach>
    </table>
</center>


</body>
</html>
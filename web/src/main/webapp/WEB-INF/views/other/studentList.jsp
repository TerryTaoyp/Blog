<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/4/6
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息展示</title>
</head>
<body>
<a href="/student/add">添加学生信息</a>
<table border="1" cellspacing="0" cellpadding="0" style="text-align: center;font-size: 20px">
    ${message}
    <form method="post" action="${website}/student/list">
        <tr>
            <th>序号</th>
            <th>id&nbsp&nbsp</th>
            <th>学号&nbsp&nbsp</th>
            <th>姓名&nbsp&nbsp</th>
            <th>性别&nbsp&nbsp</th>
            <th>年级&nbsp&nbsp</th>
            <th>班级&nbsp&nbsp</th>
            <th>学院&nbsp&nbsp</th>
            <th>生日&nbsp&nbsp</th>
            <th>是否好学生&nbsp&nbsp(1=YES&0=NO)</th>
            <th>编辑&nbsp&nbsp</th>
            <th>删除&nbsp&nbsp</th>
        </tr>
    <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
                <td>${status.index+1}</td>
                <td>${student.id}</td>
                <td>${student.studentNum}</td>
                <td>${student.studentName}</td>
                <td>${student.sex}</td>
                <td>${student.grade}</td>
                <td>${student.classNum}</td>
                <td>${student.college}</td>
                <td>${student.birthday}</td>
                <td>${student.goodStudent}</td>
                <td><a href="${website}student/edit/${student.id}">编辑</a></td>
                <td><a href="${website}student/delete/${student.id}">删除</a></td>
        </tr>
    </c:forEach>
    </form>
    </table>
        <form method='post' action="${website}/student/query/${student.id}">
            <input type="text" name="id">
            <input type="submit" value="按id搜索">
        </form>
</body>
</html>

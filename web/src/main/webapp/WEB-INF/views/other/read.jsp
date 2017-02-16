<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sql"
           uri="http://java.sun.com/jsp/jstl/sql" %>

<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/3/21
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息展示</title>
</head>
<body>

<a href="add.jsp">增加学生信息</a>
      <form method='post' action="search.jsp" >
      <input type="text" name="studentNum" >
      <input type="submit" value="按学号搜索">
      </form>
      <form method='post' action="search.jsp">
        <input type="text" name="studentName">
        <input type="submit" value="按姓名搜索">
      </form>
      <form method='post' action="search.jsp">
        <input type="text" name="sex">
        <input type="submit" value="按性别搜索">
      </form>
      <form method='post' action="search.jsp">
        <input type="text" name="grade">
        <input type="submit" value="按年级搜索">
      </form>
      <form method='post' action="search.jsp">
        <input type="text" name="classNum">
        <input type="submit" value="按班级搜索">
      </form>
      <form method='post' action="search.jsp">
        <input type="text" name="college">
        <input type="submit" value="按学院搜索">
      </form>
      <form method='post' action="search.jsp">
        <input type="text" name="birthday">
        <input type="submit" value="按生日搜索">
      </form>
      <form method='post' action="search.jsp">
        <input type="text" name="goodStudent">
        <input type="submit" value="按是(1)否(0)好学生搜索">
      </form>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
    <td>id&nbsp&nbsp</td>
    <td>学号&nbsp&nbsp</td>
    <td>姓名&nbsp&nbsp</td>
    <td>性别&nbsp&nbsp</td>
    <td>年级&nbsp&nbsp</td>
    <td>班级&nbsp&nbsp</td>
    <td>学院&nbsp&nbsp</td>
    <td>生日&nbsp&nbsp</td>
    <td>是否好学生&nbsp&nbsp(1=YES&0=NO)</td>
    <td>删除&nbsp&nbsp</td>
    <td>编辑&nbsp&nbsp</td>
  </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}"></c:out></td>
            <td><c:out value="${row.student_num}"/></td>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.sex}"/></td>
            <td><c:out value="${row.grade}"/></td>
            <td><c:out value="${row.class_num}"/></td>
            <td><c:out value="${row.college}"/></td>
            <td><c:out value="${row.birthday}"/></td>
            <td><c:out value="${row.is_good_student}"/></td>
            <td><a href="delete.jsp?id=<c:out value="${row.id}"></c:out>">删除</a></td>
            <td><a href="../edit.jsp?id=<c:out value="${row.id}"></c:out>">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

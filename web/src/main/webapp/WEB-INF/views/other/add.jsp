<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/3/30
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加学生信息</title>
</head>
<body>
<form action="${website}student/new" method="post">
    ID:<input name="id" type="text" /><br><br>
    学号:<input name="studentNum" type="text" /><br><br>
    姓名:<input name="studentName" type="text"/><br><br>
    性别:<input name="sex" type="text"/><br><br>
    年级:<input name="grade" type="text"/><br><br>
    班级:<input name="classNum" type="text"/><br><br>
    学院:<input name="college" type="text"/><br><br>
    生日:<input name="birthday" type="text"/><br><br>
    是否好学生&nbsp&nbsp(1=YES&0=NO):<input name="goodStudent" type="text"/><br><br>
    <input type="submit" value="提交"/><br>
</form>
</body>
</html>

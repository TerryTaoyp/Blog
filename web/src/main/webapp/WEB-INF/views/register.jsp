<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2016/11/11
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<center>
    <form action="${website}user/register" method="post" style="font-size: 24px">
        <input type="hidden" name="isadmin" value="0"><br><br><br><br>
        用户名：<input type="text" name="uname"><br><br>
        密&nbsp;码：<input type="password" name="upwd">
        <input type="submit" value="注册">
    </form>
    <h3>${msg}</h3>
</center>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/4/8
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单</title>
</head>
<body>
<center>
    <form method="post" action="${website}user/new">
        <p style="display: ${p3none}">身&nbsp;份：
            <input type="text" name="isadmin" value="0">
            <h5 style="display: ${p3none}">一般用户选0，管理员用户选1。</h5>
        </p>
        用户名:<input type="text" name="uname"><br>
        密&nbsp;码:<input type="password" name="upwd"><br>
        <%--//passwordAgain:<input type="password" name="password2"><br>--%>
        ${message}
        <input type="submit" value="增加">
    </form>
</center>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2016/11/11
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>写博客</title>
</head>
<body>

    <form action="${wibsite}/blog/new" method="post">
        <input type="hidden" name="uname" value="${sessionScope.uname}">
        名字：<input type="text" name="bname" value="" style="width: 200px"><br><br>
        标签：<input type="text" name="blable" value="" style="width: 200px"><br><br>
        内容:<textarea name="bcontext" style="height: 400px;width: 60%"></textarea><br><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>

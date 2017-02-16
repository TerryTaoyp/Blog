<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2016/11/11
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑博客</title>
</head>
<body>

    <form action="${wibsite}/blog/update/${bid}" method="post" >
        名字：<input type="text" name="bname" value="${blog.bname}" style="width: 200px"><br><br>
        标签：<input type="text" name="blable" value="${blog.blable}" style="width: 200px"><br><br>
        内容:<textarea name="bcontext" style="height: 400px ; width: 66%">${blog.bcontext}</textarea><br><br>
        <input type="submit" value="确定修改">
    </form>

</body>
</html>

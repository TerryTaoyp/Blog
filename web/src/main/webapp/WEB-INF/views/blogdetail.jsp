<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>博客详情</title>
</head>
<body>
<center>
    <div class="header">
        <h1>${blog.bname}</h1>
    </div>
</center>
    <div class="content" style="width: 100%">
        <h4><p>作者：${blog.uname}</p>&nbsp;<p>标签：${blog.blable}</p></h4><br>
        <br><br>
        <div style="width: 70%; float: left" >
            <pre width="40">${blog.bcontext}</pre>
            <div>
                <a href="${website}/blog/tomain">返回主页</a>
            </div>
        </div>
        <div style="width: 29%;float: left">
            <ol>
                <C:forEach items="${wordList}" var="word">
                    <li>${word.uname}:<br>&nbsp;&nbsp;&nbsp;${word.wcontant}</li><br><hr>
                </C:forEach>
            </ol>
            <br><hr><br>
            <form action="${website}/blog/newword/${blog.bname}" method="post" style="display: ${fnone};">
                <input type="hidden" name="bname" value="${blog.bname}">
                <input type="hidden" name="bid" value="${bid}">
                <input type="hidden" name="uname" value="${sessionScope.uname}">
                <textarea style="width: 90% ;height: 50px;" name="wcontant"></textarea><br>
                <input type="submit" value="提交评论">
            </form>
        </div>
    </div>


</body>
</html>

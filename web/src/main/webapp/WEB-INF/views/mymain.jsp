<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Taoyongpan
  Date: 2016/11/10
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tao博客</title>
</head>
<body>
<center>
    <div class="main" style="width: 90%">
        <div class="header" style="height: 80px">
            <h1>我的主页</h1>
        </div>
        <div class="content">
            <div class="left-arrow" style="width: 20%;float: left" >
                <a href="${website}user/tologin" style="display: ${anone}">登录</a> &nbsp;&nbsp;
                <a href="${website}user/toregister" style="display: ${anone}">注册</a>
                <p style="display: ${pnone}">欢迎超级管理员:${sessionScope.uname}</p>
                <p style="display: ${p1none}">欢迎管理员:${sessionScope.uname}</p>
                <p style="display: ${p2none}">欢迎用户:${sessionScope.uname}</p>
                <hr>
                <a href="${website}user/list" style="display: ${ymsg};">用户管理</a>
                <br><br>
                <a href="${website}user/mymain">我的主页</a>
                <br><br>
                <a href="${website}blog/tomain">返回主页</a>
            </div>
            <div class="right-arrow" style="width: 79%;float: left">
                <div>
                    <form  action="${website}blog/querymore" method="post">
                        博客：<input  type="text" name="bname" >
                        作者：<input  type="text" name="uname">
                        标签：<input  type="text" name="blable">
                        <input type="submit" value="搜索">
                    </form>
                </div>

                <table border="1" style="width: 78%">
                    <th>编号</th>
                    <th>名字&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>作者&nbsp;&nbsp;&nbsp;</th>
                    <th>标签&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    <th>&nbsp;&nbsp;&nbsp;</th>
                    <th><a href="${website}blog/newblog">增加</a></th>
                    <th>&nbsp;&nbsp;&nbsp;</th>
                    <c:forEach items="${blogList}"  var="blog" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td><a href="${website}blog/query/${blog.bname}">${blog.bname}</a></td>
                            <td>${blog.uname}</td>
                            <td><a href="${website}user/queryblable/${blog.blable}">${blog.blable}</a></td>
                            <td><a href="${website}blog/delete/${blog.bid}">删除</a></td>
                            <td><a href="${website}blog/newblog">增加</a></td>
                            <td><a href="${website}blog/editblog/${blog.bid}">编辑</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</center>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- **********************************************************************************
*Description: 登录页
*author:      mayuan
*date:        2015.8.25
************************************************************************************************* -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录页</title>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/common/common.css"></c:url>'>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/base/reset.css"></c:url>'>
    <script type="text/javascript" src='<c:url value="/js/site-config.js"></c:url>'></script>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/login_invert.css"></c:url>'>
</head>
<body>
<div class="header">
    <a class="header_log">博客登录系统</a>
</div>
<div class="continer continer_login">
    <h1>Tao博客系统</h1>
    <div class="login">
        <form action="${website}user/login" method="post">
        <div class="login_peo">
            <span></span>
            <input type="text" name="uname" value="" />
        </div>
        <hr/>
        <div class="login_pass">
            <span></span>
            <input type="hidden" name="isadmin" value="0">
             <input type="password" name="upwd" value=""/>
        </div>
            <input type="submit" class="login_icon"  value="login"/>
        </form>
        <h3>${msg1}</h3>
    </div>
    <div class="login_invert"></div>
</div>
</body>
</html>
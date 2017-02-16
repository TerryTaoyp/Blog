<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/3/21
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息修改</title>
</head>
<body>
<center>
  <form method="post" action="${website}user/update/${uid}">
    <input type="hidden" name="isadmin" value="${model.isadmin}"><br>
    <td>姓名&nbsp;&nbsp;： <input name="uname" type="text" size="25" /></td><p>
    <td>密码&nbsp;&nbsp;： <input name="upwd" type="text" size="25" /></td><p>
    <p>
    <p>
      <label>
        <input type="submit" name="Submit" value="更新" />
      </label>
    </p>
  </form>
</center>

</body>
</html>

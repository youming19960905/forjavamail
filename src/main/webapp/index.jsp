<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/4/28
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="/RegistServlet" method="post">
    <table width="600" border="1">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密 码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>昵 称</td>
            <td><input type="text" name="nickname"/></td>
        </tr>
        <tr>
            <td>邮 箱</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="注册"/></td>
        </tr>
    </table>
</form>
</body>
</html>

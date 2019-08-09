<%--
  Created by IntelliJ IDEA.
  User: 26099
  Date: 2019/7/26
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="register" method="post">
    <span>用户名;</span>
    <input type="text"name="username"/>
    <br/>
    <span>密码:</span>
    <input type="password"name="password"/>
    <br/>
    <span>邮箱:</span>
    <input type="email"name="email"/>
    <br/>
    <span>密保问题:</span>
    <input type="text"name="question"/>
    <br/>
    <span>密保答案:</span>
    <input type="text"name="answer"/>
    <br/>
    <input type="submit" value="注册">

</form>
<form action="login" method="get">
    <input type="submit" value="登录">
</form>
</body>
</html>

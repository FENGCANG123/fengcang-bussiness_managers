<%--
  Created by IntelliJ IDEA.
  User: 26099
  Date: 2019/8/6
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userinfoinsert</title>
</head>
<body>
<form action="" method="post">
    <span>用户名;</span>
    <input type="text"name="username"/>
    <br/>
    <span>密码:</span>
    <input type="password"name="password"/>
    <br/>
    <span>邮箱:</span>
    <input type="email"name="email"/>
    <br/>
    <span>电话:</span>
    <input type="text"name="phone"/>
    <br/>
    <span>密保问题:</span>
    <input type="text"name="question"/>
    <br/>
    <span>密保答案:</span>
    <input type="text"name="answer"/>
    <br/>
    <span>用户级别:</span>
    <input type="text"name="role"/>
    <br/>
    <input type="submit" value="注册">


</form>
</body>
</html>

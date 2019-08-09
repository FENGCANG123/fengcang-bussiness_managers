<%--
  Created by IntelliJ IDEA.
  User: 26099
  Date: 2019/8/4
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>修改</title>
</head>
<body>
首页
<form action="" method="post">
    <span>用户名</span>
    <input type="text"name="username" value=${updateuserinfo.username}>
    <br/>
    <span>密码</span>
    <input type="text"name="password" value=${updateuserinfo.password}>
    <br/>
    <span>邮箱:</span>
    <input type="email" name="email" value=${updateuserinfo.email}>
    <br/>
    <span>密保问题:</span>
    <input type="text"name="question" value=${updateuserinfo.question}>
    <br/>
    <span>密保答案:</span>
    <input type="text"name="answer" value=${updateuserinfo.answer}>
    <br/>
    <span>用户级别:</span>
    <input type="text"name="role" value=${updateuserinfo.role}>
    <br/>
    <input type="submit" value="确认修改">
</form>
</body>
</html>

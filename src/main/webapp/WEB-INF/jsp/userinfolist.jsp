<%--
  Created by IntelliJ IDEA.
  User: 26099
  Date: 2019/8/6
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Neuedu
  Date: 2019/8/6
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>

    <table border="1" cellspacing="0" cellpadding="0" width="100%" style="align:center;">
        <thead>
        <th>用户Id</th>
        <th>用户名</th>
        <th>用户密码</th>
        <th>邮箱</th>
        <th>手机</th>
        <th>密保问题</th>
        <th>密保答案</th>
        <th>用户级别</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
        </thead>

        <c:forEach items="${userInfoList}" var="userinfo">

            <tr bgcolor="ff9900" style="font-weight:bold;">
                <th>${userinfo.id}</th>
                <th>${userinfo.username}</th>
                <th>${userinfo.password}</th>
                <th>${userinfo.email}</th>
                <th>${userinfo.phone}</th>
                <th>${userinfo.question}</th>
                <th>${userinfo.answer}</th>
                <th>${userinfo.role}</th>
                <th>${userinfo.createTime}</th>
                <th>${userinfo.updateTime}</th>
                <th>
                    <a href="update/${userinfo.id}" >修改</a>
                    <a href="delete/${userinfo.id}" onclick='return confirm("确定要删除吗?")'>删除</a>
                </th>
            </tr>

        </c:forEach>


    </table>



</head>
<body>
<a href="insert">增添用户</a>



</body>
</html>


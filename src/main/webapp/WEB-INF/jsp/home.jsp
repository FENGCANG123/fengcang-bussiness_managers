<%@ page import="java.util.List" %>
<%@ page import="com.neuedu.pojo.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: 26099
  Date: 2019/7/29
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>HOME</title>
</head>
<body>
<a href="http://localhost:8080/business_manager_war_exploded/user/find">管理用户</a>
<a href="http://localhost:8080/business_manager_war_exploded/user/category/find">管理类别</a>
<a href="http://localhost:8080/business_manager_war_exploded/user/product/find">管理商品</a>
<h1>welcome ${user.username}</h1>
</body>
</html>

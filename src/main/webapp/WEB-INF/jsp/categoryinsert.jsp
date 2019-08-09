<%--
  Created by IntelliJ IDEA.
  User: 26099
  Date: 2019/8/6
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>categoryinsert</title>
    <table border="1" cellspacing="0" cellpadding="0" width="100%" style="align:center;">
        <thead>
        <th>类别Id</th>
        <th>类别名称</th>
        <th>所属父类</th>
        <th>类别状态</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
        </thead>

        <c:forEach items="${categorylist}" var="category">

            <tr bgcolor="ff9900" style="font-weight:bold;">
                <th>${category.id}</th>
                <th>${category.name}</th>
                <th>${category.parentId}</th>
                <th>${category.status}</th>
                <th>${category.createTime}</th>
                <th>${category.updateTime}</th>
                <th>
                    <a href="update/${category.id}" >修改</a>
                    <a href="delete/${category.id}" onclick='return confirm("确定要删除吗?")'>删除</a>
                </th>
            </tr>

        </c:forEach>



    </table>
</head>
<body>
<form action="" method="post">
    <span>name:</span>
    <input type="text"name="name"/>
    <br/>
    <span>status:</span>
    <input type="text" name="status"/>
    <br/>
    <span>sort_order:</span>
    <input type="text"name="sortOrder"/>
    <br/>
    <span>parentId:</span>

    <select id="projectPorperty" name="parentId">
<c:forEach items="${categorylist}" var="category">
        <option name="parentId" value="${category.id}">${category.name}</option>
</c:forEach>
    </select>
    <br/>
    <input type="submit" value="提交">
</form>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: 26099
  Date: 2019/8/4
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>修改</title>
</head>
<body>
<form action="" method="post" enctype="multipart/form-data">
    <span>商品名</span>
    <input type="text"name="name" >
    <br/>
    <span>商品小标题</span>
    <input type="text"name="subtitle" >
    <br/>
    <span>商品类别:</span>
    <select id="projectPorperty" name="categoryId">
        <c:forEach items="${categorylist}" var="category">
            <option name="parentId" value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <br/>
    <span>detail:</span>
    <input type="text"name="detail" >
    <br/>
    <span>价格:</span>
    <input type="text"name="price" >
    <br/>
    <span>stock:</span>
    <input type="text"name="stock" >
    <br/>
    <span>商品状态:</span>
    <input type="text"name="status">
    <br/>
    <span>主图片上传</span>
    <input type="file" name="pic">
    <br/>
    <input type="submit" value="确认增加">
</form>
</body>
</html>
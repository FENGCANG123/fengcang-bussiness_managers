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
        <th>商品Id</th>
        <th>商品名称</th>
        <th>所属类别</th>
        <th>小标题</th>
        <th>主图片</th>
        <th>图片组</th>
        <th>价格</th>
        <th>状态</th>
        <th>操作</th>
        </thead>

        <c:forEach items="${productlist}" var="product">

            <tr bgcolor="ff9900" style="font-weight:bold;">
                <th>${product.id}</th>
                <th>${product.name}</th>
                <th>${product.categoryId}</th>
                <th>${product.subtitle}</th>
                <th><a href="http://img.neuedu.com/${product.mainImage}">主图片</a></th>
                <th><a href="sub/${product.id}">查看图片组</a></th>
                <th>${product.price}</th>
                <th>${product.status}</th>
                <th>
                    <a href="update/${product.id}" >修改</a>
                    <a href="delete/${product.id}" onclick='return confirm("确定要删除吗?")'>删除</a>
                </th>
            </tr>

        </c:forEach>



    </table>



</head>
<body>

<a href="insert">增添类别</a>


</body>
</html>

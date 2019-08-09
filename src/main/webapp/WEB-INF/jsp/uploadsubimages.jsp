<%--
  Created by IntelliJ IDEA.
  User: 26099
  Date: 2019/8/7
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <table border="1" cellspacing="0" cellpadding="0" width="100%" style="align:center;">
        <thead>
        <th>图片组</th>
        </thead>

        <c:forEach items="${newSubImageslist}" var="subimage">

            <tr bgcolor="ff9900" style="font-weight:bold;">
                <th><a href="http://img.neuedu.com/${subimage}">${subimage}</a></th>
                <th>
                    <a href="deleteimage/${subimage}" onclick='return confirm("确定要删除吗?")'>删除</a>
                </th>
            </tr>

        </c:forEach>



    </table>

</head>
<body>
<body>
<a href="setimage">增加图片</a>
<form action="" method="post">
    <input type="submit" value="提交">
</form>
</body>
</body>
</html>

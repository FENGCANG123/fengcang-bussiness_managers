<html>
<#include "common/header.ftl">

<body>
<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
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
                            <th colspan="3">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list pageContext.getCurrentlist() as userinfo>
                        <tr>
                            <th>${userinfo.id}</th>
                            <th>${userinfo.username}</th>
                            <th>${userinfo.password}</th>
                            <th>${userinfo.email}</th>
                            <th>${userinfo.phone}</th>
                            <th>${userinfo.question}</th>
                            <th>${userinfo.answer}</th>
                            <th>${userinfo.role}</th>
                            <td>${userinfo.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${userinfo.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="/business/user/update/${userinfo.id}">修改</a></td>
                            <td><a href="/business/user/delete/${userinfo.id}" onclick='return confirm("确定要删除吗?")'>删除</a></td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 0>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/business/user/find/${currentPage - 1}">上一页</a></li>
                    </#if>

                    <#list pageContext.getPageList() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index+1}</a></li>
                        <#else>
                            <li><a href="/business/user/find/${index}">${index+1}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte pageContext.getTotalPages()-1>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/business/user/find/${currentPage + 1}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
<html>
<#include  "common/header.ftl">

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
                            <th>类目id</th>
                            <th>名字</th>
                            <th>type</th>
                            <th>父类</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list pageContext.getCurrentlist() as category>
                        <tr>
                            <td>${category.id}</td>
                            <td>${category.name}</td>
                            <td>${category.status}</td>
                            <td>${category.parentId}</td>
                            <td>${category.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${category.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="/user/category/update/${category.id}">修改</a></td>
                            <td><a href="/user/category/delete/${category.id}" onclick='return confirm("确定要删除吗?")'>删除</a></td>
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
                            <li><a href="/user/category/find/${currentPage - 1}">上一页</a></li>
                        </#if>

                        <#list pageContext.getPageList() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index+1}</a></li>
                            <#else>
                                <li><a href="/user/category/find/${index}">${index+1}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte pageContext.getTotalPages()-1>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/user/category/find/${currentPage + 1}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
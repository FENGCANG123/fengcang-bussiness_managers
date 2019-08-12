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
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="3">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list pageContext.getCurrentlist() as productInfo>
                        <tr>
                            <td>${productInfo.id}</td>
                            <td>${productInfo.name}</td>
                            <td><img height="100" src="http://img.neuedu.com/${productInfo.mainImage}" alt="http://img.neuedu.com/${productInfo.mainImage}"></td>
                            <td>${productInfo.price}</td>
                            <td>${productInfo.stock}</td>
                            <td>${productInfo.subtitle}</td>
                            <#list categorylist as parentcategory>
                                <#if productInfo.categoryId=parentcategory.id>
                                    <td>${parentcategory.name}</td>
                                </#if>
                            </#list>
                            <td>${productInfo.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>${productInfo.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td><a href="/business/user/product/update/${productInfo.id}">修改</a></td>
                            <td>
                                <#if productInfo.getStatus() == 0>
                                    <a href="/business/user/product/onSale/${productInfo.id}">下架</a>
                                <#else>
                                    <a href="/business/user/product/onSale/${productInfo.id}">上架</a>
                                </#if>
                            </td>
                            <td><a href="/business/user/product/delete/${productInfo.id}" onclick='return confirm("确定要删除吗?")'>删除</a></td>
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
                            <li><a href="/business/user/product/find/${currentPage - 1}">上一页</a></li>
                        </#if>

                        <#list pageContext.getPageList() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index+1}</a></li>
                            <#else>
                                <li><a href="/business/user/product/find/${index}">${index+1}</a></li>
                            </#if>
                        </#list>

                        <#if currentPage gte pageContext.getTotalPages()-1>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/business/user/product/find/${currentPage + 1}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
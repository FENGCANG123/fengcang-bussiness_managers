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
                    <form role="form" method="post" action="">
                        <div class="form-group">
                            <label>名字</label>
                            <input name="name" type="text" class="form-control" value="${(updatecategory.name)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>status</label>
                            <input name="status" type="number" class="form-control" value="${(updatecategory.status)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>sort_order</label>
                            <input name="sortOrder" type="text" class="form-control" value="${(updatecategory.sortOrder)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="parentId" class="form-control">
                                <#list categorylist as category>
                                    <option value="${category.id}"
                                            <#if (updatecategory.parentId)?? &&updatecategory.parentId == category.id>
                                                selected
                                            </#if>
                                    >${category.name}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input  type="text" name="id" value="${(updatecategory.id)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
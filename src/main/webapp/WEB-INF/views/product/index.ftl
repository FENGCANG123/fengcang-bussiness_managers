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
                    <form role="form" method="post" action=""enctype="multipart/form-data">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="name" type="text" class="form-control" value="${(updateProduct.name)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="price" type="text" class="form-control" value="${(updateProduct.price)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="stock" type="number" class="form-control" value="${(updateProduct.stock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="subtitle" type="text" class="form-control" value="${(updateProduct.subtitle)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>主图</label>
                            <div class="">
                                <input id="input-id" type="file"  name="mainpicture" multiple>
                                <p class="help-block">支持jpg、jpeg、png、gif格式，大小不超过10M</p>
                            </div>
                            <img height="90"  src="http://img.neuedu.com/${updateProduct.mainImage}" alt="请上传图片" >
                        </div>
                        <div class="form-group">
                            <label>附图</label>
                            <div class="">
                                <input id="input-id" type="file"  name="picture1" multiple>
                                <p class="help-block">支持jpg、jpeg、png、gif格式，大小不超过1M</p>
                            </div>
                        </div>
                        <#list  newSubImageslist as image>
                            <img height="90" src="http://img.neuedu.com/${image}" alt="http://img.neuedu.com/${image}">
                            <a href="/user/product/deleteimage/${image}"onclick='return confirm("确定要删除吗?")'>x</a>

                        </#list>





<#--                        <div class="form-group">-->
<#--                            <label>图片</label>-->
<#--                            <input id="subImages" name="productIcon" type="text" hidden="hidden" value="${(updateProduct.subImages)!''}"/>-->

<#--                            <div class="file-loading">-->
<#--                                <input id="input-id" type="file">-->
<#--                                <p class="help-block">支持jpg、jpeg、png、gif格式，大小不超过1M</p>-->
<#--                            </div>-->
<#--                        </div>-->




                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryId" class="form-control">
                                <#list categorylist as category>
                                    <option value="${category.id}"
                                            <#if (updateProduct.categoryId)?? || updateProduct.categoryId == category.id>
                                                selected
                                            </#if>
                                        >${category.name}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="id" value="${(updateProduct.id)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/locales/zh.min.js"></script>
<#--<script>-->

<#--    $(function () {-->
<#--        var initialPreview = [];-->
<#--        if ('${(updateProduct.subImages)!""}' != '') {-->

<#--            initialPreview = "<img  src='http://img.neuedu.com/${updateProduct.mainImage}'>"-->

<#--        }-->

<#--        $("#input-id").fileinput({-->
<#--            uploadUrl: '/sell/image/upload',0-->
<#--            language: 'zh',-->
<#--            browseClass: "btn btn-primary btn-block",-->
<#--            showCaption: false,-->
<#--            showRemove: false,-->
<#--            showUpload: false,-->
<#--            allowedFileExtensions: [ 'jpg', 'jpeg', 'png', 'gif' ],-->
<#--            maxFileSize: 100000,-->
<#--            autoReplace: true,-->
<#--            overwriteInitial: true,-->
<#--            maxFileCount: 16,-->
<#--            initialPreview: initialPreview,-->
<#--        });-->
<#--    });-->
<#--    //上传完成设置表单内容-->
<#--    $('#input-id').on('fileuploaded', function(event, data, previewId, index) {-->
<#--        if (data.response.code != 0) {-->
<#--            alert(data.response.msg)-->
<#--            return-->
<#--        }-->
<#--        $('#productIcon').val(data.response.data.fileName)-->
<#--    });-->
<#--</script>-->
</body>
</html>
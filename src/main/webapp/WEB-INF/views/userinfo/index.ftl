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
                            <label>用户名</label>
                            <input name="username" type="text" class="form-control" value="${(updateuserinfo.username)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="text" class="form-control" value="${(updateuserinfo.password)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>电话</label>
                            <input name="phone" type="number" class="form-control" value="${(updateuserinfo.phone)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>邮箱</label>
                            <input name="email" type="email" class="form-control" value="${(updateuserinfo.email)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密保问题</label>
                            <input name="question" type="text" class="form-control" value="${(updateuserinfo.question)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密保答案</label>
                            <input name="answer" type="text" class="form-control" value="${(updateuserinfo.answer)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>用户级别</label>
                            <input name="role" type="text" class="form-control" value="${(updateuserinfo.role)!''}"/>
                        </div>



<#--                        <div class="form-group">-->
<#--                            <label>图片</label>-->
<#--                            <input id="subImages" name="productIcon" type="text" hidden="hidden" value="${(updateProduct.subImages)!''}"/>-->

<#--                            <div class="file-loading">-->
<#--                                <input id="input-id" type="file">-->
<#--                                <p class="help-block">支持jpg、jpeg、png、gif格式，大小不超过1M</p>-->
<#--                            </div>-->
<#--                        </div>-->
                        <input hidden type="text" name="id" value="${(updateuserinfo.id)!''}">
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

<#--            <#list newSubImageslist as image> initialPreview = "<img class='kv-preview-data file-preview-image' src='http://img.neuedu.com/${image}>'",</#list>-->

<#--        }-->

<#--        $("#input-id").fileinput({-->
<#--            uploadUrl: '/sell/image/upload',0 -->
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
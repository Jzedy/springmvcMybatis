<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/layui-v2.2.5/layui/css/layui.css">

    <script src="/static/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="/static/layui-v2.2.5/layui/layui.js"></script>

</head>
<body>
<div class="container">
    <form  type="post" class="form-horizontal" id="searchForm">
        <input type="hidden" name="id" value="${data.id}">
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-lg-3">姓名</label>
            <div class="col-md-9 col-sm-9 col-lg-9 ">
                <input type="text" class="form-control" name="username" value="${data.username}">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-lg-3">密码</label>
            <div class="col-md-9 col-sm-9 col-lg-9 ">
                <input type="text" class="form-control" name="password" value="${data.password}">
            </div>
        </div>
        <div class="row">
            <button class="btn btn-info pull-right" onclick="save()">保存</button>
        </div>
    </form>
</div>
</body>

<script>

    layui.use('layer', function(){
        var layer = layui.layer;
    });

    function save() {
        $.ajax({
            url:'${ctx}/user/saveOrEdit',
            type:'post',
            data:$('#searchForm').serialize(),
            success:function (data) {
                layer.alert("操作成功",function () {
                    window.location.reload();
                })
            }
        })
    }

</script>
</html>

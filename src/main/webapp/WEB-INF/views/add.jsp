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
    hello
</div>
</body>

<script>

    layui.use('layer', function(){
        var layer = layui.layer;
    });

    function add() {
        layer.open({
            type:4,
            content:'${ctx}/user/add'
        })
    }
</script>
</html>

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
        <form action="${ctx}/login" class="form-horizontal" method="post">
            <div class="form-group">
                <label for="username" class="control-label">姓名</label>
                <div class="col-md-9">
                    <input id="username" name="username" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="control-label">密码</label>
                <div class="col-md-9">
                    <input type="password" name="password" id="password" class="form-control">
                </div>
            </div>
            <div class="col-md-12">
                <button type="submit" class="btn btn-info">登录</button>
            </div>
        </form>
    </div>
</body>
</html>

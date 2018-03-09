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
    <form type="post" action="${ctx}/user/findAll" class="form-horizontal">
        <div class="form-group">
            <label for="name">名称:</label>
            <input type="text" name="username" id="name" placeholder="请输入查找名称" value="${username}">
            <button class="btn btn-info">搜索</button>
            <a class="btn btn-info pull-right" onclick="add()">添加</a>
        </div>
        <div class="form-group">
            <table class="table table-responsive">
                <thread>
                    <tr>
                        <th>ID</th>
                        <th>姓名</th>
                        <th>密码</th>
                        <th>编辑</th>
                    </tr>
                </thread>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                            <td>
                                <a class="btn btn-primary" onclick="edit ('${user.id}')">编辑</a>
                                <a class="btn btn-danger" onclick="deleteById('${user.id}')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </form>
</div>
</body>

<script>

    layui.use('layer', function(){
        var layer = layui.layer;
    });

    function add() {
        layer.open({
            type:2,
            title: "添加",
            shade: 0.5,
            area:['40%', '40%'],
            content:'${ctx}/user/addView',
            success:function (layero, index) {
                layer.iframeAuto(index);
            }
        })
    }
    
    function deleteById(id) {
        layer.confirm('确认删除?',{
            btn:['确认','取消']
        },function () {
            $.ajax({
                url: '${ctx}/user/delete',
                data:{id : id},
                type: 'post',
                success: function (data) {
                    var index=parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    location.reload()
                }
            })
        })
    }
    
    function edit(id) {
        layer.open({
            type:2,
            title: "编辑",
            shade: 0.5,
            area:['40%', '40%'],
            content:'${ctx}/user/addView?id='+id
        })
        
    }
</script>
</html>

<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true" %>
<%@ taglib prefix="frame" tagdir="/WEB-INF/tags/frame" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${not empty pageTitle ? pageTitle : 'Jzedy'}</title>
    <frame:css></frame:css>
    <frame:js></frame:js>
</head>
<body>
<div id="wrapper">
    <div id="content-wrapper">
        <%--<jsp:body/>--%>
    </div>
</div>

<script>
    layui.use('layer', function(){
        var layer = layui.layer;
    });
</script>

</body>
</html>
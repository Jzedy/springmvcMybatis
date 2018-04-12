<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true" %>
<%@ taglib prefix="frame" tagdir="/WEB-INF/tags/frame" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <%--<c:if test="${not empty pageTitle}">--%>
            <%--<section class="content-header"><h1>${pageTitle}</h1></section>--%>
        <%--</c:if>--%>
        <section class="content container-fluid">

            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="position: relative;">
                    <jsp:doBody/>
                </div>
            </div>
        </section>
    </div>
</div>

<script>
    layui.use('layer', function(){
        var layer = layui.layer;
    });
</script>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="frame" tagdir="/WEB-INF/tags/frame" %>
<frame:page pageTitle="user列表">
    <form action="${ctx}/page/user"id="searchForm">
        <input type="hidden" name="pageNum" value="${data.pageNum}">
        <input type="hidden" name="pageSize" value="${data.pageSize}">
        <table class="table">
            <tbody class="table-responsive">
            <c:forEach items="${data.contents}" var="content">
                <tr>
                    <c:forEach items="${content}" var="row">
                        <td>${row.value}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
    <frame:pageBar page="${data}" form="searchForm"></frame:pageBar>
</frame:page>

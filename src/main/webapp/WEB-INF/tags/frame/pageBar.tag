<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true" %>
<%@ taglib prefix="frame" tagdir="/WEB-INF/tags/frame" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="page" required="true" type="com.cn.jzedy.page.entity.Page" %>
<%@ attribute name="form" required="true" type="java.lang.String" %>

<c:if test="${page.total>0}">
    <div class="row">
        <div class="col-sm-5">
            <div class="dataTables_info" id="delay-tables_info" role="status" aria-live="polite">${page.pageSize}
                / ${page.totalPages} 页，共${page.total}条
            </div>
        </div>
        <div class="col-sm-7">
            <ul class="pagination">
                <%--<li>--%>
                    <%--<select>--%>
                        <%--<option>10条</option>--%>
                        <%--<option>20条</option>--%>
                        <%--<option>50条</option>--%>
                        <%--<option>100条</option>--%>
                    <%--</select>--%>
                <%--</li>--%>
                <c:choose>
                    <c:when test="${page.first}">
                        <li class="disabled"><a href="javascript:void (0)">首页</a></li>
                        <li class="disabled"><a href="javascript:void (0)">上一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class=""><a href="javascript:pageSearch(1)">首页</a></li>
                        <li class=""><a href="javascript:pageSearch(${page.pageSize-1})">上一页</a></li>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="index" begin="1" end="${page.totalPages}">
                    <c:choose>
                        <c:when test="${index == page.pageSize}">
                            <li class="active"><a href="javascript:pageSearch(${index})">${index}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="javascript:pageSearch(${index})">${index}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:choose>
                    <c:when test="${page.last}">
                        <li class="disabled"><a href="javascript:void (0)">下一页</a></li>
                        <li class="disabled"><a href="javascript:void (0)">末页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class=""><a href="javascript:pageSearch(${page.pageSize+1})">下一页</a></li>
                        <li class=""><a href="javascript:pageSearch(${page.totalPages})">末页</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>

    <script>
        function pageSearch(index) {
            $('#${form} [name="pageSize"]').val(index)
            $('#${form}').submit()
//            window.location.reload()
//            $.ajax(function () {
//
//            })
        }
    </script>
</c:if>
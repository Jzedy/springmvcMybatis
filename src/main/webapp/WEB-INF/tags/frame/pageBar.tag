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
                        <li class=""><a href="javascript:void (0)">首页</a></li>
                        <li class=""><a href="javascript:void (0)">上一页</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>

    <script>

    </script>
</c:if>
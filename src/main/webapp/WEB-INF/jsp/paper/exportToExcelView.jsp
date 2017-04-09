<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>教师论文汇总导出</title>
    <link rel="stylesheet" href="${basePath}/static/paper/style_paper.css"/>
    <link rel="stylesheet" href="${basePath}/static/style_common.css"/>
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.core.css"/>
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.default.css"/>
</head>
<body>
<%--记录选中的论文--%>
<input type="hidden" id="allPaIds" value="${allPaIds}"/>
<div class="tab_space_add">
    <div class="tab_space_add_title"><h1>教师论文汇总导出</h1></div>

    <div class="table_form">
        <table class="table_add_content_title">
            <tr>
                <td class="row_11"><input type="checkbox" id="selectAll" onclick="checkedAll()"><span>全选</span></td>
                <td class="row_1">论文名称</td>               <%--必须录入--%>
                <td class="row_2">刊物名称</td>
                <td class="row_3">刊号</td>             <%--必须录入--%>
                <td class="row_4">页码数</td>
                <td class="row_5">主办单位</td>
                <td class="row_6">发表时间</td>            <%--必须录入--%>
                <td class="row_7">状态</td>
                <td class="row_8">附件</td>
                <td class="row_9">发表人</td>                  <%--必须录入--%>
                <td class="row_10">备注</td>                  <%--选录--%>
            </tr>
        </table>
        <form action="/paper/execuse" method="POST" name="exportForm">
            <%int i=-1;%>
            <c:forEach var="tc" items="${paperInfos}">
                <%i++;%>
                <div class="row fixWidth">
                    <%--操作--%>
                    <div class="row_11">
                        <input type="checkbox" name="paId" value="-${tc.paId}" onclick="selectPaId(<%=i%>,${tc.paId})"/>
                    </div>
                    <%--论文名称--%>
                    <div class="row_1">
                        <span>${tc.paName}</span>
                    </div>
                    <%--刊物名称--%>
                    <div class="row_2">
                        <span>${tc.paPublicationName}</span>
                    </div>
                    <%-- 刊号--%>
                    <div class="row_3">
                        <span>${tc.paPublicationNO}</span>
                    </div>
                    <%--页码数--%>
                    <div class="row_4">
                        <span>${tc.paPageNum}</span>
                    </div>
                    <%--主办单位--%>
                    <div class="row_5">
                        <span>${tc.paHostUnit}</span>
                    </div>
                    <%-- 发表时间--%>
                    <div class="row_6">
                        <span>${tc.paStartTime}</span>
                    </div>
                    <%--状态--%>
                    <div class="row_7">
                        <span>${tc.paState}</span>
                    </div>
                    <%-- 附件路径--%>
                    <div class="row_8">
                        <span>${tc.filePath}</span>
                    </div>
                    <%--发表人--%>
                    <div class="row_9">
                        <span>${tc.teId}</span>
                    </div>
                    <%--备注--%>
                    <div class="row_10">
                        <span>${tc.mark}</span>
                    </div>
                </div>
            </c:forEach>

            <div class="page_row">
                <div class="pageDisplay_re">
                    <span class="pagefontsize">第</span>
                <span><select class="pageSelect_re pagefontsize"  onchange="goNextAllPaper(this.value);">
                    <c:forEach var="p" begin="1" end="${page.pageSize }">
                        <option value="${p }" ${p==page.currentPage?"SELECTED":"" } >${p}</option>
                    </c:forEach>
                </select></span>
                    <span class="pagefontsize"> 页</span>
                </div>
                <div class="page_btn_group_re" onclick="goNextAllPaper('${page.currentPage+1}');">
                    <span> <a>下一页</a></span>
                </div>
                <div class="page_btn_group_re" onclick="goNextAllPaper('${page.currentPage-1}');">
                    <span><a>上一页</a></span>
                </div>
            </div>
            <div class="btn_group" onclick="exportToExcel();">
                <a>导出选中</a>
            </div>
            <div class="btn_group" onclick="exportAllToExcel();">
                <a>全院论文导出</a>
            </div>
        </form>
    </div>
</div>



</body>
<script type="text/javascript" src="${basePath}/static/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${basePath}/static/public_view_control.js"></script>
<script type="text/javascript" src="${basePath}/static/paper/paper_ajax.js"></script>
<script type="text/javascript" src="${basePath}/static/alertify/alertify.js"></script>
</html>
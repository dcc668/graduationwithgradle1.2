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
    <title>科研经费管理</title>
    <link rel="stylesheet" href="${basePath}/static/projectItem/style_projectItemManage.css"/>
    <link rel="stylesheet" href="${basePath}/static/style_common.css"/>
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.core.css"/>
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.default.css"/>
</head>
<body>
<div class="tab_space_add">
    <div class="tab_space_add_title"><h1>科研经费管理</h1></div>
    <div class="table_form">
            <div class="row fixWidth">
                <input type="hidden" name="tc[0].prId" value="项目名称"/>
                <%--项目名称--%>
                <div class="row_1"><span>项目名称</span></div>
                <%-- 负责人工号--%>
                <div class="row_2">负责人(工号)</div>
                <%--课题总额(申请到的金额)--%>
                <div class="row_3">课题总额(万)</div>
                <%-- 预算金额--%>
                <div class="row_4">预算金额</div>
                <%--经费金额--%>
                <div class="row_5">经费金额</div>
            </div>
            <div class="row fixWidth">
                <input type="hidden" name="tc[1].prId"value="${projectInfo.prId}"/>
                <%--项目名称--%>
                <div class="row_1"><span>${projectInfo.prName}</span></div>
                <%-- 负责人工号--%>
                <div class="row_2">${projectInfo.teId}</div>
                <%--课题总额(申请到的金额)--%>
                <div class="row_3">${projectInfo.prUsefulMoney}</div>
                <%-- 预算金额--%>
                <div class="row_4">
                    <div class="col1"><a href="/projectItem/preMoneyItemInfoAddView/${projectInfo.prId}">${projectInfo.prPreMoney}</a></div>
                    <div class="col2"><a href="/projectItem/preMoneyItemInfoAddView/${projectInfo.prId}">&nbsp&nbsp<span>明细>></span></a></div>
                </div>
                <%--经费金额--%>
                <div class="row_5">
                    <div class="col1"><a href="/projectItem/projectItemInfoUpdateView/${projectInfo.prId}">${projectInfo.prMoney}</a></div>
                    <div class="col2"><a href="/projectItem/projectItemInfoUpdateView/${projectInfo.prId}">&nbsp&nbsp<span>明细>></span></a></div>
                </div>
            </div>
            <%int i=1;%>
            <c:forEach var="projectInfo2" items="${projectInfos}">
                <%i++;%>
                <div class="row fixWidth">
                    <input name="tc[<%=i%>].prId" type="hidden" value="${projectInfo2.prId}"/>
                        <%--项目名称--%>
                    <div class="row_1"><span>${projectInfo2.prName}</span></div>
                        <%-- 负责人工号--%>
                    <div class="row_2">${projectInfo2.teId}</div>
                        <%--课题总额(申请到的金额)--%>
                    <div class="row_3">${projectInfo2.prUsefulMoney}</div>
                        <%-- 预算金额--%>
                    <div class="row_4">
                        <div class="col1"><a href="/projectItem/preMoneyItemInfoAddView/${projectInfo2.prId}">${projectInfo2.prPreMoney}</a></div>
                        <div class="col2"><a href="/projectItem/preMoneyItemInfoAddView/${projectInfo2.prId}">&nbsp&nbsp<span>明细>></span></a></div>
                    </div>
                        <%--经费金额--%>
                    <div class="row_5">
                        <div class="col1"><a href="/projectItem/projectItemInfoUpdateView/${projectInfo2.prId}">${projectInfo2.prMoney}</a></div>
                        <div class="col2"><a href="/projectItem/projectItemInfoUpdateView/${projectInfo2.prId}">&nbsp&nbsp<span>明细>></span></a></div>
                    </div>
                </div>
            </c:forEach>
        <div class="page_row">
            <div class="pageDisplay_re">
                <span class="pagefontsize">第</span>
                <span><select class="pageSelect_re pagefontsize"  onchange="goNextPaper(this.value);">
                    <c:forEach var="p" begin="1" end="${page.pageSize }">
                        <option value="${p }" ${p==page.currentPage?"SELECTED":"" } >${p}</option>
                    </c:forEach>
                </select></span>
                <span class="pagefontsize"> 页</span>
            </div>
            <div class="page_btn_group_re" onclick="goNextPaper('${page.currentPage+1}');">
                <span> <a>下一页</a></span>
            </div>
            <div class="page_btn_group_re" onclick="goNextPaper('${page.currentPage-1}');">
                <span><a>上一页</a></span>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${basePath}/static/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${basePath}/static/public_view_control.js"></script>
<script type="text/javascript" src="${basePath}/static/projectItem/projectItemManage_ajax.js"></script>
<script type="text/javascript" src="${basePath}/static/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}/static/alertify/alertify.js"></script>
<script type="text/javascript" src="${basePath}/static/date/calendar.js"></script>
</html>
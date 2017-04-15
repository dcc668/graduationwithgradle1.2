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
    <link rel="stylesheet" href="${basePath}/static/projectitem/style_projectitem.css"/>
    <link rel="stylesheet" href="${basePath}/static/style_common.css"/>
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.core.css"/>
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.default.css"/>
</head>
<body>
<div class="tab_space_add">
    <div class="tab_space_add_title"><h1>科研经费管理</h1></div>
    <div class="table_form">
        <table class="table_add_content_title">
            <tr>
                <td class="row_1">项目名称<span style="color: red;">*</span></td>               <%--必须录入--%>
                <td class="row_2" style="font-size: 11px">负责人(工号)<span style="color: red;">*</span></td>             <%--必须录入--%>
                <td class="row_3" style="font-size: 11px">课题总额(万)<span style="color: red;">*</span></td>
                <td class="row_4">预算金额</td>
                <td class="row_5">经费金额</td>                  <%--必须录入--%>
                <td class="row_6">操作</td>
            </tr>
        </table>
            <div class="row fixWidth">
                <input name="tc[1].prId" type="hidden" value="${projectInfo.prId}"/>
                <%--项目名称--%>
                <div class="row_1">
                    <span>${projectInfo.prName}</span>
                </div>
                <%-- 负责人工号--%>
                <div class="row_2">
                    <span>${projectInfo.teId}"</span>
                </div>
                <%--课题总额(申请到的金额)--%>
                <div class="row_3">
                    <span>${projectInfo.prUsefulMoney}</span>
                </div>
                <%-- 预算金额--%>
                <div class="row_4">
                    <span>${projectInfo.prPreMoney}</span>
                </div></span>
                <%--经费金额--%>
                <div class="row_5">
                    <span><${projectInfo.prMoney}</span>
                </div></span>
                <%--操作--%>
                <div class="row_6">
                    <div class="same add">
                        <a onchange="addRow();"><i class="iconfont">&#xe64d;</i></a>
                    </div>
                    <div class="same delete">
                        <a onchange="removeRow(this);"><i class="iconfont">&#xe625;</i></a>
                    </div>
                </div>
            </div>
            <%int i=1;%>
            <c:forEach var="projectInfo2" items="${projectInfos}">
                <%i++;%>
                <div class="row fixWidth">
                    <input name="tc[<%=i%>].prId" type="hidden" value="${projectInfo2.prId}"/>
                        <%--项目名称--%>
                    <div class="row_1">
                        <input name="tc[<%=i%>].prName" type="text" value="${projectInfo2.prName}"/>
                    </div>
                        <%-- 负责人工号--%>
                    <div class="row_2">
                        <input name="tc[<%=i%>].teId" type="tel" value="${projectInfo2.teId}" onchange="checkIsExists(this);"/>
                    </div>
                        <%--课题总额(申请到的金额)--%>
                    <div class="row_3">
                        <input type="tel" name="tc[<%=i%>].prUsefulMoney" value="${projectInfo2.prUsefulMoney}"/>
                    </div>
                        <%-- 预算金额--%>
                    <div class="row_4">
                        <input type="tel" name="tc[<%=i%>].prPreMoney" value="${projectInfo2.prPreMoney}"/>
                    </div>
                        <%--经费金额--%>
                    <div class="row_5">
                        <input name="tc[<%=i%>].prMoney"  type="tel" value="${projectInfo2.prMoney}"/>
                    </div>
                    <div class="row_6">
                        <div class="same add">
                            <a onchange="addRow();"><i class="iconfont">&#xe64d;</i></a>
                        </div>
                        <div class="same delete">
                            <a onchange="removeRow(this);"><i class="iconfont">&#xe625;</i></a>
                        </div>
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
                <div class="page_btn_group_re" onchange="goNextPaper('${page.currentPage+1}');">
                    <span> <a>下一页</a></span>
                </div>
                <div class="page_btn_group_re" onchange="goNextPaper('${page.currentPage-1}');">
                    <span><a>上一页</a></span>
                </div>
            </div>

    </div>
</div>
</body>
<script type="text/javascript" src="${basePath}/static/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${basePath}/static/public_view_control.js"></script>
<script type="text/javascript" src="${basePath}/static/project/project_ajax.js"></script>
<script type="text/javascript" src="${basePath}/static/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}/static/alertify/alertify.js"></script>
<script type="text/javascript" src="${basePath}/static/date/calendar.js"></script>
</html>
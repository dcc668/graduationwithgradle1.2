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
    <title>支出明细</title>
    <link rel="stylesheet" href="${basePath}/static/projectItem/style_projectItemUpdate.css"/>
    <link rel="stylesheet" href="${basePath}/static/style_common.css"/>
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.core.css"/>
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.default.css"/>
</head>
<body>
<div class="tab_space_add">
    <div class="tab_space_add_title"><h1>支出明细</h1></div>

    <div class="table_form">
        <table class="table_add_content_title">
            <tr>
                <td class="row_1">明细项名称<span style="color: red;">*</span></td>               <%--必须录入--%>
                <td class="row_2">金额</td>
                <td class="row_3" style="font-size: 11px">使用人工号<span style="color: red;">*</span></td>             <%--必须录入--%>
                <td class="row_4" style="font-size: 11px">支出时间<span style="color: red;">*</span></td>             <%--必须录入--%>
                <td class="row_5">用途说明</td>
                <td class="row_6">操作</td>
            </tr>
        </table>
        <%--插入行时，始终插入这一行--%>
        <form name="work_form" method="POST" action="/projectItem/submitProjectInfo">
            <div class="row fixWidth" style="display:none">
                <input name="tc[0].moId" type="hidden" value="0"/>
                <%--明细项名称--%>
                <div class="row_1">
                    <input name="tc[0].itemName" type="text" value=""/>
                </div>
                <%--金额--%>
                <div class="row_2">
                    <input name="tc[0].sumMoney" type="text" value=""/>
                </div>
                <%-- 负责人工号--%>
                <div class="row_3">
                    <input name="tc[0].teId" type="tel" value="${projectItem.teId}" onblur="checkIsExists(this);"/>
                </div>
                <%--支出时间--%>
                <div class="row_4">
                    <input name="tc[0].time" type="text" value="" onclick="calendar.show(this);"/>
                </div>
                <%--用途说明--%>
                <div class="row_5">
                    <input type="text" name="tc[0].mark" value="" />
                </div>
                <%--操作--%>
                <div class="row_6">
                    <div class="same add">
                        <a onclick="addRow();"><i class="iconfont">&#xe64d;</i></a>
                    </div>
                    <div class="same delete">
                        <a onclick="removeRow(this);"><i class="iconfont">&#xe625;</i></a>
                    </div>
                </div>
            </div>
            <div class="row fixWidth">
                <input name="tc[1].moId" type="hidden" value="0"/>
                <%--明细项名称--%>
                <div class="row_1">
                    <input name="tc[1].itemName" type="text" value=""/>
                </div>
                <%--金额--%>
                <div class="row_2">
                    <input name="tc[1].sumMoney" type="text" value=""/>
                </div>
                <%-- 负责人工号--%>
                <div class="row_3">
                    <input name="tc[1].teId" type="tel" value="${projectItem.teId}" onblur="checkIsExists(this);"/>
                </div>
                <%--支出时间--%>
                <div class="row_4">
                    <input name="tc[1].time" type="text" value="" onclick="calendar.show(this);"/>
                </div>
                <%--用途说明--%>
                <div class="row_5">
                    <input type="text" name="tc[1].mark" value="" />
                </div>
                <%--操作--%>
                <div class="row_6">
                    <div class="same add">
                        <a onclick="addRow();"><i class="iconfont">&#xe64d;</i></a>
                    </div>
                    <div class="same delete">
                        <a onclick="removeRow(this);"><i class="iconfont">&#xe625;</i></a>
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
                        <%--项目来源--%>
                    <div class="row_2">
                        <select name="tc[<%=i%>].prSource">
                            <option value="国家级" ${projectInfo2.prSource=="国家级"?"selected":""}>国家级</option>
                            <option value="省部级" ${projectInfo2.prSource=="省部级"?"selected":""}>省部级</option>
                            <option value="市级" ${projectInfo2.prSource=="市级"?"selected":""}>市级</option>
                            <option value="其他" ${projectInfo2.prSource=="其他"?"selected":""}>其他</option>
                        </select>
                    </div>
                        <%-- 负责人工号--%>
                    <div class="row_3">
                        <input name="tc[<%=i%>].teId" type="tel" value="${projectInfo2.teId}" onblur="checkIsExists(this);"/>
                    </div>
                    <div class="row_4">
                        <input name="tc[<%=i%>].members" type="text" value="${projectInfo2.members}" onblur="checkIsExists(this);"/>
                    </div>
                        <%--立项时间--%>
                    <div class="row_5">
                        <input type="text" name="tc[<%=i%>].prStartTime" value="${projectInfo2.prStartTime}" onclick="calendar.show(this);"/>
                    </div>
                        <%--实际完成时间--%>
                    <div class="row_6">
                        <input type="text" name="tc[<%=i%>].prEndTime" value="${projectInfo2.prEndTime}" onclick="calendar.show(this);"/>
                    </div>
                        <%-- 拟定期限(天)--%>
                    <div class="row_7">
                        <input type="tel" name="tc[<%=i%>].prDate" value="${projectInfo2.prDate}"/>
                    </div>
                        <%--课题总额(申请到的金额)--%>
                    <div class="row_8">
                        <input type="tel" name="tc[<%=i%>].prUsefulMoney" value="${projectInfo2.prUsefulMoney}"/>
                    </div>
                        <%-- 预算金额--%>
                    <div class="row_9">
                        <input type="tel" name="tc[<%=i%>].prPreMoney" value="${projectInfo2.prPreMoney}"/>
                    </div>
                        <%--经费金额--%>
                    <div class="row_10">
                        <input name="tc[<%=i%>].prMoney"  type="tel" value="${projectInfo2.prMoney}"/>
                    </div>
                        <%--成果简介--%>
                    <div class="row_11">
                        <input name="tc[<%=i%>].prResultInfo"  type="text" value="${projectInfo2.prResultInfo}"/>
                    </div>
                        <%--状态--%>
                    <div class="row_12">
                        <select name="tc[<%=i%>].prState">
                            <option value="申报处理" ${projectInfo2.prState=="申报处理"?"selected":""}>申报处理</option>
                            <option value="审核通过" ${projectInfo2.prState=="审核通过"?"selected":""}>审核通过</option>
                            <option value="开发中" ${projectInfo2.prState=="开发中"?"selected":""}>开发中</option>
                            <option value="已完成" ${projectInfo2.prState=="已完成"?"selected":""}>已完成</option>
                        </select>
                    </div>
                    <%--操作--%>
                    <div class="row_11">
                        <div class="same add">
                            <a onclick="addRow();"><i class="iconfont">&#xe64d;</i></a>
                        </div>
                        <div class="same delete">
                            <a onclick="removeRow(this);"><i class="iconfont">&#xe625;</i></a>
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
                <div class="page_btn_group_re" onclick="goNextPaper('${page.currentPage+1}');">
                    <span> <a>下一页</a></span>
                </div>
                <div class="page_btn_group_re" onclick="goNextPaper('${page.currentPage-1}');">
                    <span><a>上一页</a></span>
                </div>
            </div>
            <div class="btn_group" onclick="subWorkData();">
                <a>提交</a>
            </div>
        </form>

    </div>
</div>
</body>
<script type="text/javascript" src="${basePath}/static/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${basePath}/static/public_view_control.js"></script>
<script type="text/javascript" src="${basePath}/static/projectItem/projectItemUpdate_ajax.js"></script>
<script type="text/javascript" src="${basePath}/static/alertify/alertify.js"></script>
<script type="text/javascript" src="${basePath}/static/date/calendar.js"></script>
</html>
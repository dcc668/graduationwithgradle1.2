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
    <title>--</title>
    <link rel="stylesheet" href="${basePath}/static/project/style_project.css">
    <link rel="stylesheet" href="${basePath}/static/style_common.css">
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.core.css">
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.default.css">
</head>
<body>
<div class="tab_space_add">
    <div class="tab_space_add_title"><h1>---</h1></div>

    <div class="table_form">
        <table class="table_add_content_title">
            <tr>
                <td class="row_1">项目名称<span style="color: red;">*</span></td>               <%--必须录入--%>
                <td class="row_2">项目来源</td>
                <td class="row_3">负责人<span style="color: red;">*</span></td>             <%--必须录入--%>
                <td class="row_4">立项时间</td>
                <td class="row_5">完成时间</td>
                <td class="row_6">拟定期限</td>            <%--必须录入--%>
                <td class="row_7">课题总额<span style="color: red;">*</span></td>
                <td class="row_8">预算金额</td>
                <td class="row_9">经费金额</td>                  <%--必须录入--%>
                <td class="row_10">成果简介</td>                  <%--选录--%>
                <td class="row_11">状态</td>
                <td class="row_12">操作</td>
            </tr>
        </table>
        <%--插入行时，始终插入这一行--%>
        <form name="work_form" method="POST" action="">
            <div class="row fixWidth" style="display:none;">
                <input name="tc[0].prId" type="hidden" value="0"/>
                <%--项目名称--%>
                <div class="row_1">
                    <input name="tc[0].prName" type="text" value=""/>
                </div>
                <%--项目来源--%>
                <div class="row_2">
                    <input name="tc[0].prSource" type="text" value=""/>
                </div>
                <%-- 负责人工号--%>
                <div class="row_3">
                    <input name="tc[0].teId" type="tel" value=""/>
                </div>
                <%--立项时间--%>
                <div class="row_4">
                    <input type="text" name="tc[0].prStartTime" value="" />
                </div>
                <%--实际完成时间--%>
                <div class="row_5">
                    <input type="text" name="tc[0].prEndTime" value="" />
                </div>
                <%-- 拟定期限(天)--%>
                <div class="row_6">
                    <input type="text" name="tc[0].prDate" value=""/>
                </div>
                <%--课题总额(申请到的金额)--%>
                <div class="row_7">
                    <input type="text" name="tc[0].prUsefulMoney" value=""/>
                </div>
                <%-- 预算金额--%>
                <div class="row_8">
                    <input type="text" name="tc[0].prPreMoney" value=""/>
                </div>
                <%--经费金额--%>
                <div class="row_9">
                    <input name="tc[0].prMoney"  type="tel" value="${paperInfo.teId}"/>
                </div>
                <%--成果简介--%>
                <div class="row_10">
                    <input name="tc[0].prResultInfo"  type="tel" value="${paperInfo.teId}"/>
                </div>
                <%--状态--%>
                <div class="row_11">
                    <select name="tc[0].prState">
                        <option value="申报处理">申报处理</option>
                        <option value="审核通过">审核通过</option>
                        <option value="开发中">开发中</option>
                        <option value="已完成">已完成</option>
                    </select>
                </div>
                <%--操作--%>
                <div class="row_12">
                    <div class="same add">
                        <a onclick="addRow();"><i class="iconfont">&#xe64d;</i></a>
                    </div>
                    <div class="same delete">
                        <a onclick="removeRow(this);"><i class="iconfont">&#xe625;</i></a>
                    </div>
                </div>
            </div>
            <s class="row fixWidth">
                <input name="tc[1].prId" type="hidden" value="-1"/>
                <%--项目名称--%>
                <div class="row_1">
                    <input name="tc[1].prName" type="text" value=""/>
                </div>
                <%--项目来源--%>
                <div class="row_2">
                    <input name="tc[1].prSource" type="text" value=""/>
                </div>
                <%-- 负责人工号--%>
                <div class="row_3">
                    <input name="tc[1].teId" type="tel" value=""/>
                </div>
                <%--立项时间--%>
                <div class="row_4">
                    <input type="text" name="tc[1].prStartTime" value="" />
                </div>
                <%--实际完成时间--%>
                <div class="row_5">
                    <input type="text" name="tc[1].prEndTime" value="" />
                </div>
                <%-- 拟定期限(天)--%>
                <div class="row_6">
                    <input type="text" name="tc[1].prDate" value=""/>
                </div>
                <%--课题总额(申请到的金额)--%>
                <div class="row_7">
                    <input type="text" name="tc[1].prUsefulMoney" value=""/>
                </div>
                <%-- 预算金额--%>
                <div class="row_8">
                    <input type="text" name="tc[1].prPreMoney" value=""/>
                </div>
                <%--经费金额--%>
                <div class="row_9">
                    <input name="tc[1].prMoney"  type="tel" value="${paperInfo.teId}"/>
                </div>
                <%--成果简介--%>
                <div class="row_10">
                    <input name="tc[1].prResultInfo"  type="tel" value="${paperInfo.teId}"/>
                </div>
                <%--状态--%>
                <div class="row_11">
                    <select name="tc[1].prState">
                        <option value="申报处理">申报处理</option>
                        <option value="审核通过">审核通过</option>
                        <option value="开发中">开发中</option>
                        <option value="已完成">已完成</option>
                    </select>
                </div>
                <%--操作--%>
                <div class="row_12">
                    <div class="same add">
                        <a onclick="addRow();"><i class="iconfont">&#xe64d;</i></a>
                    </div>
                    <div class="same delete">
                        <a onclick="removeRow(this);"><i class="iconfont">&#xe625;</i></a>
                    </div>
                </div>
            </s>
            <div class="btn_group" onclick="subWorkData();">
                <a>提交</a>
            </div>
        </form>

    </div>
</div>
</body>
<script type="text/javascript" src="${basePath}/static/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${basePath}/static/public_view_control.js"></script>
<script type="text/javascript" src="${basePath}/static/paper/paper_ajax.js"></script>
<script type="text/javascript" src="${basePath}/static/jquery.form.js"></script>
<script type="text/javascript" src="${basePath}/static/alertify/alertify.js"></script>
<script type="text/javascript" src="${basePath}/static/date/calendar.js"></script>
</html>
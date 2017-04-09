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
    <title>论文录入</title>
    <link rel="stylesheet" href="${basePath}/static/paper/style_paper.css">
    <link rel="stylesheet" href="${basePath}/static/style_common.css">
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.core.css">
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.default.css">
</head>
<body>
<div class="tab_space_add">
    <div class="tab_space_add_title"><h1>论文录入</h1></div>

    <div class="table_form">
        <table class="table_add_content_title">
            <tr>
                <td class="row_1">论文名称<span style="color: red;">*</span></td>               <%--必须录入--%>
                <td class="row_2">刊物名称</td>
                <td class="row_3">刊号<span style="color: red;">*</span></td>             <%--必须录入--%>
                <td class="row_4">页码数</td>
                <td class="row_5">所属学院</td>
                <td class="row_6">发表时间<span style="color: red;">*</span></td>            <%--必须录入--%>
                <td class="row_7">收录情况</td>
                <td class="row_8">附件</td>
                <td class="row_9">发表人</td>                  <%--必须录入--%>
                <td class="row_10">备注</td>                  <%--选录--%>
                <td class="row_11">操作</td>
            </tr>
        </table>
        <%--插入行时，始终插入这一行--%>
        <form name="work_form" method="POST" action="">
            <div class="row fixWidth" style="display:none;">
                <input name="tc[0].paId" type="hidden" value="0"/>
                <%--论文名称--%>
                <div class="row_1">
                    <input name="tc[0].paName" type="text" value=""/>
                </div>
                <%--刊物名称--%>
                <div class="row_2">
                    <input name="tc[0].paPublicationName" type="text" value=" "/>
                </div>
                <%-- 刊号--%>
                <div class="row_3">
                    <input name="tc[0].paPublicationNO" type="text" value=" "/>
                </div>
                <%--页码数--%>
                <div class="row_4">
                    <input type="tel" name="tc[0].paPageNum" value=" " />
                </div>
                <%--所属学院--%>
                <div class="row_5">
                    <select name="tc[0].paHostUnit">
                        <option value="计通学院">计通学院</option>
                        <option value="软件学院">软件学院</option>
                        <option value="土木学院">土木学院</option>
                        <option value="机电学院">机电学院</option>
                        <option value="材料学院">材料学院</option>
                        <option value="经管学院">经管学院</option>
                    </select>
                </div>
                <%-- 发表时间--%>
                <div class="row_6">
                    <input type="text" name="tc[0].paStartTime" onclick="calendar.show(this);"/>
                </div>
                <%--收录情况--%>
                <div class="row_7">
                    <select name="tc[0].paState">
                        <option value="SCI">SCI收录</option>
                        <option value="EI">EI收录</option>
                        <option value="ISTP">ISTP收录</option>
                        <option value="SSCI">SSCI收录</option>
                        <option value="CSCD">CSCD收录</option>
                        <option value="other">其他</option>
                    </select>
                </div>
                <%-- 附件路径--%>
                <div class="row_8">
                    <input type="hidden" name="tc[0].filePath" value=""/>
                    <input type="file" name="file" id="tc[0].fileUpload" style="width: 72px;height: 30px;padding-bottom: 0px;padding-top: 0px;" onchange="fileUpload(this);"/>
                </div>
                <%--发表人--%>
                <div class="row_9">
                    <input name="tc[0].teId"  type="tel" value="${paperInfo.teId}"/>
                </div>
                <%--备注--%>
                <div class="row_10">
                    <input type="text" name="tc[0].mark" value=""/>
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
            <div class="row fixWidth">
                <input name="tc[1].paId" type="hidden" value="-1"/>
                <%--论文名称--%>
                <div class="row_1">
                    <input name="tc[1].paName" type="text" value=""/>
                </div>
                <%--刊物名称--%>
                <div class="row_2">
                    <input name="tc[1].paPublicationName" type="text" value=""/>
                </div>
                <%-- 刊号--%>
                <div class="row_3">
                    <input name="tc[1].paPublicationNO" type="text" value=""/>
                </div>
                <%--页码数--%>
                <div class="row_4">
                    <input type="tel" name="tc[1].paPageNum" value="" />
                </div>
                <%--所属学院--%>
                <div class="row_5">
                    <select name="tc[1].paHostUnit">
                        <option value="计通学院">计通学院</option>
                        <option value="软件学院">软件学院</option>
                        <option value="土木学院">土木学院</option>
                        <option value="机电学院">机电学院</option>
                        <option value="材料学院">材料学院</option>
                        <option value="经管学院">经管学院</option>
                    </select>
                </div>
                <%-- 发表时间--%>
                <div class="row_6">
                    <input type="text" name="tc[1].paStartTime" onclick="calendar.show(this);" />
                </div>
                <%--收录情况--%>
                <div class="row_7">
                    <select name="tc[1].paState">
                        <option value="SCI">SCI收录</option>
                        <option value="EI">EI收录</option>
                        <option value="ISTP">ISTP收录</option>
                        <option value="SSCI">SSCI收录</option>
                        <option value="CSCD">CSCD收录</option>
                        <option value="other">其他</option>
                    </select>
                </div>
                <%-- 附件路径--%>
                <div class="row_8">
                    <input name="tc[1].filePath" value=""type='hidden'}/>
                    <input  name="file" id="tc[1].fileUpload" style="width: 72px;height: 30px;padding-bottom: 0px;padding-top: 0px;" onchange="fileUpload(this);" type='file'/>
                </div>
                <%--发表人--%>
                <div class="row_9">
                    <input name="tc[1].teId"  type="tel" value="${paperInfo.teId}" readonly/>
                </div>
                <%--备注--%>
                <div class="row_10">
                    <input type="text" name="tc[1].mark" value=""/>
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
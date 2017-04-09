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
    <title>教师教学情况录入</title>
    <link rel="stylesheet" href="${basePath}/static/teacher/style_teacher.css">
    <link rel="stylesheet" href="${basePath}/static/style_common.css">
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.core.css">
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.default.css">
</head>
<body>
<div class="tab_space_add">
    <div class="tab_space_add_title"><h1>教学情况录入</h1></div>
    <span class="error_text">填入的信息有误，请确认后重新提交（如：项目名不能为空，人数须大于0）</span>

    <div class="table_form">
        <table class="table_add_content_title">
            <tr>
                <td class="row_1">学期<span style="color: red;">*</span></td>                <%--必须录入--%>
                <td class="row_2">课程类型<span style="color: red;">*</span></td>              <%--必须录入--%>
                <td class="row_3">课程名称<span style="color: red;">*</span></td>              <%--必须录入--%>
                <td class="row_4">总人数</td>
                <td class="row_5">课程学时</td>
                <td class="row_6">班级批次<span style="color: red;">*</span></td>              <%--必须录入--%>
                <td class="row_7">未通过人数</td>
                <td class="row_8">课程学分</td>
                <td class="row_9">双语教学</td>
                <td class="row_10">备注</td>                  <%--选录--%>
                <td class="row_11">操作</td>
            </tr>
        </table>
        <input type="hidden" name="init_co2Language" value="${teaCoInfo.co2Language}"/>
        <%--插入行时，始终插入这一行--%>
        <form name="work_form" method="POST" action="/teacher/submitTeachInfo">
            <div class="row fixWidth" style="display: none">
                <input name="tc[0].tcId" type="hidden" value="0">
                <%--学期--%>
                <div class="row_1">
                    <input class="radio_btn" name="tc[0].term" type="radio" value="春" checked/><label>春</label>
                    <input class="radio_btn" name="tc[0].term" type="radio" value="秋"/><label>秋</label>
                </div>
                <%--课程类型--%>
                <div class="row_2">
                    <select name="tc[0].type">
                        <option value="理论教学">理论教学</option>
                        <option value="课程设计">课程设计</option>
                        <option value="助教">助教</option>
                        <option value="自行上课">自行上课</option>
                    </select>
                </div>
                <%--课程名称--%>
                <div class="row_3">
                    <select name="tc[0].coName" onchange="coNameChanged(this);">
                        <c:forEach var="course" items="${teacher.courses}">
                            <option value="${course.coNO}">${course.coName}</option>
                        </c:forEach>
                    </select>
                </div>
                <%--总人数--%>
                <div class="row_4">
                    <input type="tel" name="tc[0].stuNum" required min="0" value=" " readonly/>
                </div>
                <%--课程学时--%>
                <div class="row_5">
                    <input name="tc[0].coTime" type="tel" readonly="readonly" value=" ">
                </div>
                <%--班级批次--%>
                <div class="row_6">
                    <input type="number" name="tc[0].houseNum" required min="0" value=""/>
                </div>
                <%--未通过人数--%>
                <div class="row_7">
                    <input type="tel" name="tc[0].notPassNum" required min="0" value=" " readonly/>
                </div>
                <%--课程学分--%>
                <div class="row_8">
                    <input type="tel" name="tc[0].coScore" min="0" readonly value=" "/>
                </div>
                <%--双语教学--%>
                <div class="row_9">
                    <input class="radio_btn" name="tc[0].co2Language" value="true" type="radio"/><label>是</label>
                    <input class="radio_btn" name="tc[0].co2Language" value="false" type="radio"/><label>否</label>
                </div>
                <%--备注--%>
                <div class="row_10">
                    <input type="text" name="tc[0].mark" required value=""/>
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
                <input name="tc[1].tcId" type="hidden" value="-1">
                <%--学期--%>
                <div class="row_1">
                    <input class="radio_btn" name="tc[1].term" type="radio" value="春"checked /><label>春</label>
                    <input class="radio_btn" name="tc[1].term" type="radio" value="秋"/><label>秋</label>
                </div>
                <%--课程类型--%>
                <div class="row_2">
                    <select name="tc[1].type">
                        <option value="理论教学">理论教学</option>
                        <option value="课程设计">课程设计</option>
                        <option value="助教">助教</option>
                        <option value="自行上课">自行上课</option>
                    </select>
                </div>
                <%--课程名称--%>
                <div class="row_3">
                    <select name="tc[1].coName" onchange="coNameChanged(this);">
                        <c:forEach var="course" items="${teacher.courses}">
                            <option value="${course.coNO}">${course.coName}</option>
                        </c:forEach>
                    </select>
                </div>
                <%--总人数--%>
                <div class="row_4">
                    <input type="tel" name="tc[1].stuNum" required min="0" value="${teaCoInfo.stuNum}" readonly/>
                </div>
                <%--课程学时--%>
                <div class="row_5">
                    <input name="tc[1].coTime" type="tel" readonly="readonly" value="${teaCoInfo.coTime}">
                </div>
                <%--班级批次--%>
                <div class="row_6">
                    <input type="number" name="tc[1].houseNum" required min="0" value=""/>
                </div>
                <%--未通过人数--%>
                <div class="row_7">
                    <input type="tel" name="tc[1].notPassNum" required min="0" value="${teaCoInfo.notPassNum}"
                           readonly/>
                </div>
                <%--课程学分--%>
                <div class="row_8">
                    <input type="tel" name="tc[1].coScore" min="0" readonly value="${teaCoInfo.coScore}"/>
                </div>
                <%--双语教学--%>
                <div class="row_9">
                    <input class="radio_btn" name="tc[1].co2Language" value="true" ${teaCoInfo.co2Language==true?"checked":""} type="radio" /><label>是</label>
                    <input class="radio_btn" name="tc[1].co2Language" value="false" ${teaCoInfo.co2Language==false?"checked":""} type="radio"/><label>否</label>
                </div>
                <%--备注--%>
                <div class="row_10">
                    <input type="text" name="tc[1].mark" required value=""/>
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
<script type="text/javascript" src="${basePath}/static/teacher/teacher_ajax.js"></script>
<script type="text/javascript" src="${basePath}/static/alertify/alertify.js"></script>
</html>
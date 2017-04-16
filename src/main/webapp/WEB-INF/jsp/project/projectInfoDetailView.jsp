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
</head>
<body>
<div class="tab_space_add">
    <div class="tab_space_add_title"><h1>---</h1></div>
    <div class="table_form">
        <form action="/projectItem/projectItemInfoUpdate" method="post" name="work_form">
            <table class="table_report">
                <tr>
                    <td class="col_1">分类</td>
                    <td class="col_2">费用项目<span style="color: red;">*</span></td>
                    <td class="col_3">金额<span style="color: red;">*</span></td>
                    <td class="col_4">支出时间</td>
                    <td class="col_5">支出人<span style="color: red;">*</span></td>
                    <td class="col_6">用途说明<span style="color: red;">*</span></td>

                    <td class="col_1">分类</td>
                    <td class="col_2">费用项目<span style="color: red;">*</span></td>
                    <td class="col_3">金额<span style="color: red;">*</span></td>
                    <td class="col_4">支出时间</td>
                    <td class="col_5">支出人<span style="color: red;">*</span></td>
                    <td class="col_6">用途说明<span style="color: red;">*</span></td>

                    <td class="col_1">分类</td>
                    <td class="col_2">费用项目<span style="color: red;">*</span></td>
                    <td class="col_3">金额<span style="color: red;">*</span></td>
                    <td class="col_4">支出时间</td>
                    <td class="col_5">支出人<span style="color: red;">*</span></td>
                    <td class="col_6">用途说明<span style="color: red;">*</span></td>
                </tr>
                <!------------第1行---------------->
                <tr>
                    <td class="col_1" rowspan="12">设计类</td>
                    <td class="col_2"><input type="hidden"  name="items[0].itemName" value="办公用品,水"/>办公用品,水</td>
                    <td class="col_3"><input type="tel"  name="items[0].sumMoney"  value="" onfocus="insertValue(this,1,0);"/></td>
                    <td class="col_4"><input type="text"  name="items[0].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[0].teId" value="" onfocus="insertValue(this,2,0);"/></td>
                    <td class="col_6"><input type="text"  name="items[0].mark" value="" onfocus="insertValue(this,0,0);"/></td>

                    <td class="col_1" rowspan="3" >材料费</td>
                    <td class="col_2"><input type="hidden"  name="items[1].itemName" value="水电费"/>水电费</td>
                    <td class="col_3"><input type="tel"  name="items[1].sumMoney" value="" onfocus="insertValue(this,1,1);"/></td>
                    <td class="col_4"><input type="text"  name="items[1].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[1].teId" value="" onfocus="insertValue(this,2,1);"/></td>
                    <td class="col_6"><input type="text"  name="items[1].mark" value="" onfocus="insertValue(this,0,1);"/></td>

                    <td class="col_1" rowspan="3" style="font-size: 12px;">固定资产</td>
                    <td class="col_2"><input type="hidden"  name="items[2].itemName" value="租赁费"/>租赁费</td>
                    <td class="col_3"><input type="tel"  name="items[2].sumMoney" value="" onfocus="insertValue(this,1,2);"/></td>
                    <td class="col_4"><input type="text"  name="items[2].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="text"  name="items[2].teId" value="" onfocus="insertValue(this,2,2);"/></td>
                    <td class="col_6"><input type="text"  name="items[2].mark" value="" onfocus="insertValue(this,0,2);"/></td>
                </tr>
                <!------------第2行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[3].itemName" value="资料,书报,检索"/>资料,书报,检索</td>
                    <td class="col_3"><input type="tel"  name="items[3].sumMoney"  value="" onfocus="insertValue(this,1,3);"/></td>
                    <td class="col_4"><input type="text"  name="items[3].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[3].teId" value="" onfocus="insertValue(this,2,3);"/></td>
                    <td class="col_6"><input type="text"  name="items[3].mark" value="" onfocus="insertValue(this,0,3);"/></td>

                    <td class="col_2"><input type="hidden"  name="items[4].itemName" value="材料费"/>材料费</td>
                    <td class="col_3"><input type="tel"  name="items[4].sumMoney" value="" onfocus="insertValue(this,1,4);"/></td>
                    <td class="col_4"><input type="text"  name="items[4].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[4].teId" value="" onfocus="insertValue(this,2,4);"/></td>
                    <td class="col_6"><input type="text"  name="items[4].mark" value="" onfocus="insertValue(this,0,4);"/></td>

                    <td class="col_2"></td>
                    <td class="col_3"></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>
                </tr>
                <!------------第3行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[5].itemName" value="印刷费，版面"/>印刷费，版面</td>
                    <td class="col_3"><input type="tel"  name="items[5].sumMoney"  value="" onfocus="insertValue(this,1,5);"/></td>
                    <td class="col_4"><input type="text"  name="items[5].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[5].teId" value="" onfocus="insertValue(this,2,5);"/></td>
                    <td class="col_6"><input type="text"  name="items[5].mark" value="" onfocus="insertValue(this,0,5);"/></td>

                    <td class="col_2" style="background: #848484;">材料费小计</td>
                    <td class="col_3"><input id="money1" value="" onfocus="insertValue(this,1,-1);"/></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>

                    <td class="col_2" style="background: #848484;">固定资产小计</td>
                    <td class="col_3"><input id="money2" value="" onfocus="insertValue(this,1,-1);"/></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>
                </tr>
                <!------------第4行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[6].itemName" value="印刷费，版面"/>咨询费,评审</td>
                    <td class="col_3"><input type="tel"  name="items[6].sumMoney"  value="" onfocus="insertValue(this,1,6);"/></td>
                    <td class="col_4"><input type="text"  name="items[6].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[6].teId" value="" onfocus="insertValue(this,2,6);"/></td>
                    <td class="col_6"><input type="text"  name="items[6].mark" value="" onfocus="insertValue(this,0,6);"/></td>

                    <td class="col_1" rowspan="4">外协费</td>
                    <td class="col_2"><input type="hidden"  name="items[7].itemName" value="加工费"/>加工费</td>
                    <td class="col_3"><input type="tel"  name="items[7].sumMoney" value="" onfocus="insertValue(this,1,7);"/></td>
                    <td class="col_4"><input type="text"  name="items[7].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[7].teId" value="" onfocus="insertValue(this,2,7);"/></td>
                    <td class="col_6"><input type="text"  name="items[7].mark" value="" onfocus="insertValue(this,0,7);"/></td>

                    <td class="col_1" rowspan="3">管理费</td>
                    <td class="col_2"><input type="hidden"  name="items[8].itemName" value="管理费"/>管理费</td>
                    <td class="col_3"><input type="tel"  name="items[8].sumMoney" value="" onfocus="insertValue(this,1,8);"/></td>
                    <td class="col_4"><input type="text"  name="items[8].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[8].teId" value="" onfocus="insertValue(this,2,8);"/></td>
                    <td class="col_6"><input type="text"  name="items[8].mark" value="" onfocus="insertValue(this,0,8);"/></td>
                </tr>

                <!------------第5行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[9].itemName" value="邮寄费，话费，网费"/>邮寄费，话费，网费</td>
                    <td class="col_3"><input type="tel"  name="items[9].sumMoney"  value="" onfocus="insertValue(this,1,9);"/></td>
                    <td class="col_4"><input type="text"  name="items[9].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[9].teId" value="" onfocus="insertValue(this,2,9);"/></td>
                    <td class="col_6"><input type="text"  name="items[9].mark" value="" onfocus="insertValue(this,0,9);"/></td>

                    <td class="col_2"><input type="hidden"  name="items[10].itemName" value="协助费"/>协助费</td>
                    <td class="col_3"><input type="tel"  name="items[10].sumMoney" value="" onfocus="insertValue(this,1,10);"/></td>
                    <td class="col_4"><input type="text"  name="items[10].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[10].teId" value="" onfocus="insertValue(this,2,10);"/></td>
                    <td class="col_6"><input type="text"  name="items[10].mark" value="" onfocus="insertValue(this,0,10);"/></td>

                    <td class="col_2"><input type="hidden"  name="items[11].itemName" value="招待费"/>招待费</td>
                    <td class="col_3"><input type="tel"  name="items[11].sumMoney" value="" onfocus="insertValue(this,1,11);"/></td>
                    <td class="col_4"><input type="text"  name="items[11].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[11].teId" value="" onfocus="insertValue(this,2,11);"/></td>
                    <td class="col_6"><input type="text"  name="items[11].mark" value="" onfocus="insertValue(this,0,11);"/></td>
                </tr>
                <!------------第6行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[12].itemName" value="车费，过路费，油费"/>车费，过路费，油费</td>
                    <td class="col_3"><input type="tel"  name="items[12].sumMoney"  value="" onfocus="insertValue(this,1,12);"/></td>
                    <td class="col_4"><input type="text"  name="items[12].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[12].teId" value="" onfocus="insertValue(this,2,12);"/></td>
                    <td class="col_6"><input type="text"  name="items[12].mark" value="" onfocus="insertValue(this,0,12);"/></td>

                    <td class="col_2"><input type="hidden"  name="items[13].itemName" value="维修费"/>维修费</td>
                    <td class="col_3"><input type="tel"  name="items[13].sumMoney" value="" onfocus="insertValue(this,1,13);"/></td>
                    <td class="col_4"><input type="text"  name="items[13].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[13].teId" value="" onfocus="insertValue(this,2,13);"/></td>
                    <td class="col_6"><input type="text"  name="items[13].mark" value="" onfocus="insertValue(this,0,13);"/></td>

                    <td class="col_2" style="background: #848484;">管理费小计</td>
                    <td class="col_3"><input id="money3" onfocus="insertValue(this,1,-1);"/></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>
                </tr>
                <!------------第7行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[14].itemName" value="差旅费"/>差旅费</td>
                    <td class="col_3"><input type="tel"  name="items[14].sumMoney"  value="" onfocus="insertValue(this,1,14);"/></td>
                    <td class="col_4"><input type="text"  name="items[14].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[14].teId" value="" onfocus="insertValue(this,2,14);"/></td>
                    <td class="col_6"><input type="text"  name="items[14].mark" value="" onfocus="insertValue(this,0,14);"/></td>

                    <td class="col_2" style="background: #848484;">外协费小计</td>
                    <td class="col_3"><input id="money4" onfocus="insertValue(this,1,-1);"/></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>

                    <td class="col_1" rowspan="6" >工资</td>
                    <td class="col_2"><input type="hidden"  name="items[15].itemName" value="助研费"/>助研费</td>
                    <td class="col_3"><input type="tel"  name="items[15].sumMoney" value="" onfocus="insertValue(this,1,15);"/></td>
                    <td class="col_4"><input type="text"  name="items[15].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[15].teId" value="" onfocus="insertValue(this,2,15);"/></td>
                    <td class="col_6"><input type="text"  name="items[15].mark" value="" onfocus="insertValue(this,0,15);"/></td>
                </tr>
                <!------------第8行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[16].itemName" value="出国费"/>出国费</td>
                    <td class="col_3"><input type="tel"  name="items[16].sumMoney"  value="" onfocus="insertValue(this,1,16);"/></td>
                    <td class="col_4"><input type="text"  name="items[16].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[16].teId" value="" onfocus="insertValue(this,2,16);"/></td>
                    <td class="col_6"><input type="text"  name="items[16].mark" value="" onfocus="insertValue(this,0,16);"/></td>

                    <td class="col_1" rowspan="3">专用费</td>
                    <td class="col_2"><input type="hidden"  name="items[17].itemName" value="设备费购置"/>设备费购置</td>
                    <td class="col_3"><input type="tel"  name="items[17].sumMoney" value="" onfocus="insertValue(this,1,17);"/></td>
                    <td class="col_4"><input type="text"  name="items[17].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[17].teId" value="" onfocus="insertValue(this,2,17);"/></td>
                    <td class="col_6"><input type="text"  name="items[17].mark" value="" onfocus="insertValue(this,0,17);"/></td>

                    <td class="col_2"><input type="hidden"  name="items[18].itemName" value="科研津贴"/>科研津贴</td>
                    <td class="col_3"><input type="tel"  name="items[18].sumMoney" value="" onfocus="insertValue(this,1,18);"/></td>
                    <td class="col_4"><input type="text"  name="items[18].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[18].teId" value="" onfocus="insertValue(this,2,18);"/></td>
                    <td class="col_6"><input type="text"  name="items[18].mark" value="" onfocus="insertValue(this,0,18);"/></td>
                </tr>
                <!------------第9行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[19].itemName" value="会议费"/>会议费</td>
                    <td class="col_3"><input type="tel"  name="items[19].sumMoney"  value="" onfocus="insertValue(this,1,19);"/></td>
                    <td class="col_4"><input type="text"  name="items[19].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[19].teId" value="" onfocus="insertValue(this,2,19);"/></td>
                    <td class="col_6"><input type="text"  name="items[19].mark" value="" onfocus="insertValue(this,0,19);"/></td>

                    <td class="col_2"><input type="hidden"  name="items[20].itemName" value="其他"/>其他</td>
                    <td class="col_3"><input type="tel"  name="items[20].sumMoney" value="" onfocus="insertValue(this,1,20);"/></td>
                    <td class="col_4"><input type="text"  name="items[20].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[20].teId" value="" onfocus="insertValue(this,2,20);"/></td>
                    <td class="col_6"><input type="text"  name="items[20].mark" value="" onfocus="insertValue(this,0,20);"/></td>

                    <td class="col_2"><input type="hidden"  name="items[21].itemName" value="反聘费"/>反聘费</td>
                    <td class="col_3"><input type="tel"  name="items[21].sumMoney" value="" onfocus="insertValue(this,1,21);"/></td>
                    <td class="col_4"><input type="text"  name="items[21].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[21].teId" value="" onfocus="insertValue(this,2,21);"/></td>
                    <td class="col_6"><input type="text"  name="items[21].mark" value="" onfocus="insertValue(this,0,21);"/></td>
                </tr>
                <!------------第10行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[22].itemName" value="计算，测试，分析费"/>计算，测试，分析费</td>
                    <td class="col_3"><input type="tel"  name="items[22].sumMoney"  value="" onfocus="insertValue(this,1,22);"/></td>
                    <td class="col_4"><input type="text"  name="items[22].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[22].teId" value="" onfocus="insertValue(this,2,22);"/></td>
                    <td class="col_6"><input type="text"  name="items[22].mark" value="" onfocus="insertValue(this,0,22);"/></td>

                    <td class="col_2" style="background: #848484;">专用费小计</td>
                    <td class="col_3"><input id="money5" onfocus="insertValue(this,1,-1);"/></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>

                    <td class="col_2"><input type="hidden"  name="items[23].itemName" value="保密，保健费"/>保密，保健费</td>
                    <td class="col_3"><input type="tel"  name="items[23].sumMoney" value="" onfocus="insertValue(this,1,23);"/></td>
                    <td class="col_4"><input type="text"  name="items[23].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[23].teId" value="" onfocus="insertValue(this,2,23);"/></td>
                    <td class="col_6"><input type="text"  name="items[23].mark" value="" onfocus="insertValue(this,0,23);"/></td>
                </tr>
                <!------------第11行---------------->
                <tr>
                    <td class="col_2"><input type="hidden"  name="items[24].itemName" value="其他"/>其他</td>
                    <td class="col_3"><input type="tel"  name="items[24].sumMoney"  value="" onfocus="insertValue(this,1,24);"/></td>
                    <td class="col_4"><input type="text"  name="items[24].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[24].teId" value="" onfocus="insertValue(this,2,24);"/></td>
                    <td class="col_6"><input type="text"  name="items[24].mark" value="" onfocus="insertValue(this,0,24);"/></td>

                    <td class="col_1" rowspan="2" style="font-size: 12px;">试验费</td>
                    <td class="col_2"><input type="hidden"  name="items[25].itemName" value="试验费"/>试验费</td>
                    <td class="col_3"><input type="tel"  name="items[25].sumMoney" value="" onfocus="insertValue(this,1,25);"/></td>
                    <td class="col_4"><input type="text"  name="items[25].time" value="" onclick="calendar.show(this);"/></td>
                    <td class="col_5"><input type="tel"  name="items[25].teId" value="" onfocus="insertValue(this,2,25);"/></td>
                    <td class="col_6"><input type="text"  name="items[25].mark" value="" onfocus="insertValue(this,0,25);"/></td>

                    <td class="col_2"></td>
                    <td class="col_3"></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>
                </tr>
                <!------------第12行---------------->
                <tr>
                    <td class="col_2" style="background: #848484;">设计费小计</td>
                    <td class="col_3"><input id="money6" value="" onfocus="insertValue(this,1,-1);"/></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>

                    <td class="col_2" style="background: #848484;">试验费小计</td>
                    <td class="col_3"><input id="money7" value="" onfocus="insertValue(this,1,-1);"/></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>

                    <td class="col_2" style="background: #848484;">工资小计</td>
                    <td class="col_3"><input id="money8" value="" onfocus="insertValue(this,1,-1);"/></td>
                    <td class="col_4"></td>
                    <td class="col_5"></td>
                    <td class="col_6"></td>
                </tr>
            </table>
            <table class="table_read">
                <!---------------------------------------------学院审批------------------->
                <tr>
                    <td class="col_read_1" rowspan="2">学院审批</td>
                    <td class="col_read_2">科研项目</td>
                    <td class="col_read_3">设计费</td>
                    <td class="col_read_4">材料费</td>
                    <td class="col_read_5">外协费</td>
                    <td class="col_read_6">专用费</td>
                    <td class="col_read_7">试验费</td>
                    <td class="col_read_8">工资</td>
                    <td class="col_read_9">固定资产</td>
                    <td class="col_read_10">管理费</td>
                    <td class="col_read_11">合计</td>
                </tr>
                <tr>
                    <td class="col_read_2"></td>
                    <td class="col_read_3"></td>
                    <td class="col_read_4"></td>
                    <td class="col_read_5"></td>
                    <td class="col_read_6"></td>
                    <td class="col_read_7"></td>
                    <td class="col_read_8"></td>
                    <td class="col_read_9"></td>
                    <td class="col_read_10"></td>
                    <td class="col_read_11"></td>
                </tr>
                <tr><td colspan="11"><input type="hidden" name="sum" value="0"/>总计:&nbsp&nbsp<span></span></td></tr>
            </table>

            <div class="tab_foot"><span>项目负责人</span></div>
            <div class="btn_group" onclick="subWorkData();">
                <a>提交</a>
            </div>
        </form>
    </div>
</div>

        <!-- modal content -->
        <div id="modal-content" style="display: none">
            <div id="modal-title">输入数据...</div>
            <div id="modal-data">
                <textarea></textarea>
                <input type="button" class="simplemodal-sure" value="确认"/>
                <input type="button" class="simplemodal-close" value="关闭"/>
            </div>
        </div>

<%--<form action="/project/moneyItemInfoAdd" method="POST">--%>
     <%--<input type="hidden"  name="items[0].itemName" value="办公用品,水"/>--%>
     <%--<input type="tel"  name="items[0].sumMoney"  value="111" onfocus="insertValue(this,1,0);"/>--%>
     <%--<input type="text"  name="items[0].time" value="" onclick="calendar.show(this);"/>--%>
     <%--<input type="tel"  name="items[0].teId" value="22" onfocus="insertValue(this,2,0);"/>--%>
     <%--<input type="text"  name="items[0].mark" value="DDD" onfocus="insertValue(this,0,0);"/>--%>

     <%--<input type="hidden"  name="items[1].itemName" value="水电费"/>--%>
     <%--<input type="tel"  name="items[1].sumMoney" value="222" onfocus="insertValue(this,1,1);"/>--%>
     <%--<input type="text"  name="items[1].time" value="" onclick="calendar.show(this);"/>--%>
     <%--<input type="tel"  name="items[1].teId" value="23" onfocus="insertValue(this,2,1);"/>--%>
     <%--<input type="text"  name="items[1].mark" value="FDF" onfocus="insertValue(this,0,1);"/>--%>

    <%--<input type="submit" value="submit"/>--%>
<%--</form>--%>
</body>
<script type="text/javascript" src="${basePath}/static/project/simplemode/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/static/project/simplemode/jquery.simplemodal.js"></script>
<script type="text/javascript" src="${basePath}/static/project/project_ajax.js"></script>
<script type="text/javascript" src="${basePath}/static/date/calendar.js"></script>
</html>





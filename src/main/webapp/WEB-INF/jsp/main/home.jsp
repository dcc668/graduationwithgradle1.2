<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="select" uri="http://www.cxy808.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>主页</title>
<c:set var="checkAll" scope="session">
    <input type="checkbox" name="allbox" onclick="rapidsh.checkAllBox(this.form)" style="margin: 0 0 0 4px" />
</c:set>
<%
String ctx =  request.getContextPath();
%>
<link rel="stylesheet" href="<%=ctx %>/styles/content/settings/style.css" />
<link rel="stylesheet" href="<%=ctx %>/styles/css/min.css" />
<link rel="stylesheet" href="<%=ctx %>/styles/displaytag/css/screen.css" type="text/css"/>
<link rel="stylesheet" href="<%=ctx %>/styles/common.css" type="text/css"/>
</head>
<body>
<div id="head">
    <div class="left">
        <a href="#" class="button profile"><img src="<c:url value="/styles/img/icons/top/huser.png"/>" /></a>
        Hi, 
        <a href="#">${currentUser.username}</a>
        |
        <a href="<c:url value="/main/logout"/>" class="logout">注销</a>
    </div>
    <div class="right">
        <form action="#" id="search" class="search placeholder">
            <label>Looking for something ?</label>
            <input type="text" value="" name="q" class="text" />
            <input type="submit" value="rechercher" class="submit" />
        </form>
    </div>
</div>
                
<div id="sidebar">
    <ul>
        <li>
            <a href="#">
                <img src="<c:url value="/styles/img/icons/menu/inbox.png"/>" />
               	 主面板
            </a>
        </li>
        

     <shiro:hasPermission name="manage:all">
        <li class="current"><a href="systemManage"><img src="<c:url value="/styles/img/icons/menu/layout.png"/>"/>系统管理</a>
            <ul>
                <li ><a href="<c:url value="/teacher/test"/>" target="contentFrame">教师管理</a></li>
                <li><a href="<c:url value="student/manageStudentView"/>" target="contentFrame">学生管理</a></li>
                <li><a href="<c:url value="major/manageMajorView"/>" target="contentFrame">专业管理</a></li>
                <li><a href="<c:url value="reviewer/manageReviewerView"/>" target="contentFrame">评审委员会管理</a></li>
            </ul>
        </li>
    </shiro:hasPermission >
         
     <shiro:hasPermission name="teacher:all">
        <li><a href="#"><img src="<c:url value="/styles/img/icons/menu/layout.png"/>"/>教学情况管理</a>
            <ul>
                <li ><a href="<c:url value="/teacher/teaTeachInfoAddView"/>" target="contentFrame">教师教学情况录入</a></li>
                <li ><a href="<c:url value="/teacher/teaTeachInfoUpdateView"/>" target="contentFrame">教师教学情况更改</a></li>
            </ul>
        </li>
    </shiro:hasPermission >
        <shiro:hasPermission name="teacher:all">
            <li><a href="#"><img src="<c:url value="/styles/img/icons/menu/layout.png"/>"/>论文管理</a>
                <ul>
                    <li ><a href="<c:url value="/paper/paperInfoAddView"/>" target="contentFrame">论文录入</a></li>
                    <li ><a href="<c:url value="/paper/paperInfoUpdateView"/>" target="contentFrame">论文更改</a></li>
                    <li ><a href="<c:url value="/paper/exportToExcelView"/>" target="contentFrame">论文汇总及导出Excel</a></li>
                    <li ><a href="<c:url value="/paper/paperStatistcsView"/>" target="contentFrame">年度论文统计</a></li>
                </ul>
            </li>
        </shiro:hasPermission >

     <shiro:hasPermission name="reviewer:all">
         <li><a href="#"><img src="<c:url value="/styles/img/icons/menu/layout.png"/>"/>科研项目管理</a>
             <ul>
                 <li ><a href="<c:url value="/project/projectInfoAddView"/>" target="contentFrame">科研项目录入</a></li>
                 <li ><a href="<c:url value="/project/projectInfoUpdateView"/>" target="contentFrame">科研项目更改</a></li>
                 <li ><a href="<c:url value="/projectItem/moneyItemInfoAddView"/>" target="contentFrame">科研经费</a></li>
                 <li ><a href="<c:url value="/project/paperStatistcsView"/>" target="contentFrame">年度论文统计</a></li>
             </ul>
        </li>
        <li><a href="#"><img src="<c:url value="/styles/img/icons/menu/layout.png"/>"/>课题评审</a>
            <ul>
                <li><a href="<c:url value="toReview"/>" target="contentFrame">评审入口</a></li>
            </ul>
        </li>
     </shiro:hasPermission>
      <shiro:hasPermission name="teacher:all">
         <li><a href="#"><img src="<c:url value="/styles/img/icons/menu/layout.png"/>"/>下载课题</a>
            <ul>
                <li><a href="<c:url value="fileUploadDownload/downloadFileView"/>" target="contentFrame">下载学生已完成课题</a></li>
            </ul>
        </li>
        
         <li><a href="#"><img src="<c:url value="/styles/img/icons/menu/layout.png"/>"/>教师评分</a>
            <ul>
                <li><a href="<c:url value="teacher/directiveTeaGradeView"/>" target="contentFrame">教师评分入口</a></li>
            </ul>
        </li>
        
        <li><a href="#"><img src="<c:url value="/styles/img/icons/menu/layout.png"/>"/>统计分析</a>
            <ul>
                <li><a href="<c:url value="statisticsShooseView"/>" target="contentFrame">学生选题情况统计</a></li>
                <li><a href="<c:url value="statisticsTitleMarginView"/>" target="contentFrame">选课余量统计</a></li>
            </ul>
        </li>
     </shiro:hasPermission>
    </ul>
</div>
<div style="margin-left: 260px;margin-top: 80px" >
	<iframe  src="" name="contentFrame" id="contentFrameId" width="1090"  height="600" 	frameborder="no" border="0" scrolling="no" allowtransparency="yes"></iframe>
</div>
</body>
<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="<%=ctx %>/scripts/libs/jquery/1.6/jquery.min.js"></script>
<script type="text/javascript" src="<%=ctx %>/scripts/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=ctx %>/scripts/min.js"></script>
<script type="text/javascript" src="<%=ctx %>/styles/content/settings/main.js"></script>
<script type="text/javascript" src="<%=ctx %>/scripts/common.js" ></script>
<script type="text/javascript" src="<%=ctx %>/scripts/ready.js" ></script>

</html>
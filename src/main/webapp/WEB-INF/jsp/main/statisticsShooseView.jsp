<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<div style="margin-left: 240px">
  		<a href="main/statisticsShoose/0" target="contentFrame1">未选课学生</a>
  		<a href="main/statisticsShoose/1" target="contentFrame1">已选课学生</a>
  		<a href="main/statisticsShoose/2" target="contentFrame1">统计比例</a>
  	</div>
			
<div style="margin-left: 160px;margin-top: 18px" >
	<iframe  src="" name="contentFrame1" id="contentFrameId1" width="900"  height="600" 	frameborder="no" border="0" scrolling="no" allowtransparency="yes"></iframe>
</div>

			
  </body>
</html>

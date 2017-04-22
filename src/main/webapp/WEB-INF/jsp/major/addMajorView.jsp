<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
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
  <h2 style="text-align: center;font-family: serif">专业录入</h2>
	<form:form modelAttribute="majorInfo" action="/major/addMajor">
	<div style="margin: 0 auto;width: 214px">
		<label>专业代号</label>
		<form:input path="MajorId"/><br>
		
		<label>专业名称</label>
		<form:input path="majorName"/><br>
		
		<div style="margin-left: 71px;margin-top: 20px">
			<input type="submit" value="录入"/>
		</div>
	</div>
	</form:form>

  </body>
</html>

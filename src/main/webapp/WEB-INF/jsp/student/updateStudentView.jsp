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

	<form:form modelAttribute="studentInfo" action="/student/updateStudent">
		<h2 style="text-align: center;font-family: serif">学生更改</h2>
		<table style="margin: 0 auto;width: 350px">
			<tr>
				<td><label>学号：</label></td>
				<td><form:input path="id"/></td>
				<td rowspan="8">		
						<div style="margin-left: 60">
							<input type="submit" value="更新"/>
						</div>
				</td>
			</tr>
		<tr>
			<td><label>姓名</label></td>
			<td><form:input path="sName"/></td>
		</tr>
		<tr>
			<td><label>密码</label></td>
			<td><form:input path="sPassword"/></td>
		</tr>
		<tr>
			<td><label>性别</label></td>
			<td><form:input path="sSex"/></td>
		</tr>
		<tr>
			<td><label>班级</label></td>
			<td><form:input path="sClass"/></td>
		</tr>
		<tr>
			<td><label>专业代号</label></td>
			<td><form:input path="majorId"/></td>
		</tr>
		<tr>	
			<td><label>电话</label></td>
			<td><form:input path="sTel"/></td>
		</tr>
		<tr>	
			<td><label>E-Mail</label></td>
			<td><form:input path="sMail"/></td>
		</tr>
		<tr>	
			<td><label>QQ</label></td>
			<td><form:input path="sQQ"/></td>
		</tr>
	</table>
	</form:form>

	

  </body>
</html>

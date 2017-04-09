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

	<form:form modelAttribute="titleInfo" action="main/teacher/teaCreateTitle">
		
		<table >
			<tr>
				<td><label>题目号：</label></td>
				<td><form:input path="titleId"/></td>
				<td rowspan="8">		
						<div style="margin-left: 60">
							<input type="submit" value="添加"/>
						</div>
				</td>
			</tr>
			
			<tr>	
				<td><label>题目</label></td>
				<td><form:input path="titleName"/></td>
			</tr>
			
			<tr>
				<td><label>性质</label></td>
				<td><form:input path="titleProperty"/></td>
			</tr>
			<tr>	
				<td><label>类型</label></td>
				<td><form:input path="titleType"/></td>
			</tr>
			<tr>
			
				<td><label>来源</label></td>
				<td><form:input path="titleSource"/></td>
			</tr>
			<tr>	
				<td><label>学期</label></td>
				<td><form:input path="term"/></td>
			</tr>
			<tr>
			
				<td><label>需要几人完成</label></td>
				<td><form:input path="needStuNum"/></td>
			</tr>
			<tr>
				<td><label>立题教师编号</label></td>
				<td><form:input path="tId"/></td>
			</tr>
			<tr>	
				<td><label>专业代号</label></td>
				<td><form:input path="MajorId"/></td>
			</tr>	
		</table>
	</form:form>

	

  </body>
</html>

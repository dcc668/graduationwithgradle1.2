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

	<form:form modelAttribute="teacherStudentInfo" action="main/teacher/directiveTeaGrade">
		<table>
			<tr>
				<td><label>教师编号</label></td>
				<td><form:input path="tId"/></td>
			</tr>
			<tr>
				<td><label>学生编号</label></td>
				<td><form:input path="sId"/></td>
			</tr>	
			<tr>
				<td><label>分数</label></td>
				<td><form:input path="score"/></td>
			</tr>
		</table>
		<div style="margin-left: 70px;margin-top: 30px">
			<input   type="submit" value="添加"/>
		</div>
	</form:form>

	

  </body>
</html>

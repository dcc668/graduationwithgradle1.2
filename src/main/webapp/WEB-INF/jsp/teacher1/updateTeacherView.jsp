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
  <h2 style="text-align: center;font-family: serif">教师更新</h2>
	<form:form modelAttribute="teacherInfo" action="/teacher/updateTeacher">
		
		<table style="margin: 0 auto;width: 350px;border-top: solid 2px black;border-bottom: solid 2px black">
			<tr>
				<td><label>工号：</label></td>
				<td><form:input path="teId"/></td>
				<td rowspan="8">		
						<div style="margin-left: 60">
							<input type="submit" value="更新"/>
						</div>
				</td>
			</tr>
			
			<tr>
				<td><label>姓名：</label></td>
				<td><form:input path="teName"/></td>
			</tr>	
			
			<tr>
				<td><label>登录密码：</label></td>
				<td><form:input path="tePassword"/></td>
			</tr>	
					
			<tr>
				<td><label>性别：</label></td>
				<td><form:input path="teSex"/></td>
			</tr>	
				
			<tr>	
				<td><label>职位：</label></td>
				<td><form:input path="tePosition"/></td>
			</tr>	
			
			<tr>	
				<td><label>电话：</label></td>
				<td><form:input path="teTel"/></td>
			</tr>	
				
			<tr>	
				<td><label>地址：</label></td>
				<td><form:input path="teAddr"/></td>
			</tr>		
			
			<tr>	
				<td><label>E-Mail：</label></td>
				<td><form:input path="teMail"/></td>
			</tr>		
			
			<tr>	
				<td><label>QQ：</label></td>
				<td><form:input path="teQQ"/></td>
			</tr>	
			
		</table>
	</form:form>
  </body>
</html>

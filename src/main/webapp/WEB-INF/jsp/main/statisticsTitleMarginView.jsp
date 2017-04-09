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
  <div style="margin-left: 240px"><h1>选课余量统计</h1></div>
  <div style="margin-left: 160px;margin-top: 30px" >

  			<table >
  			<tr>
  				<th>课题编号</th>
  				<th>课题名称</th>
  				<th>学期</th>
  				<th>需要学生</th>
  				<th>余量</th>
  			</tr>
  	
		        <c:forEach items="${titInfs}" var="titleReviewInfo">
		       	 	<tr>
							<td><span>${titleReviewInfo.titleId}</span></td>
							<td><span>${titleReviewInfo.titleName }</span></td>
							<td><span>${titleReviewInfo.term }</span></td>
							<td><span>${titleReviewInfo.needStuNum }</span></td>
							<td><span>${titleReviewInfo.margin }</span></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
  </body>
</html>

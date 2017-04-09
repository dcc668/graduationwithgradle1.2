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

  
  			<table >
  			<tr>
  				<th>学号</th>
  				<th>姓名</th>
  				<th>专业</th>
  				<th>班级</th>
  				<th>电话</th>
  				<th>题目</th>
  			</tr>
  	
		        <c:forEach items="${stusDone}" var="titleReviewInfo">
		       	 	<tr>
							<td><span>${titleReviewInfo.id }</span></td>
							<td><span>${titleReviewInfo.sName }</span></td>
							<td><span>${titleReviewInfo.majorName }</span></td>
							<td><span>${titleReviewInfo.sClass }</span></td>
							<td><span>${titleReviewInfo.sTel }</span></td>
							<td><span>${titleReviewInfo.titleName }</span></td>
					</tr>
				</c:forEach>
				
			</table>
  </body>
</html>

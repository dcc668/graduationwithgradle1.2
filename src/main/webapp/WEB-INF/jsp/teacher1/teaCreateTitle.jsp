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

  
  			<table border="1">
  			<tr>
  				<th>ID</th>
  				<th>题目ID</th>
  				<th>题目名称</th>
  				<th>评审状态</th>
  				<th>评审建议</th>
  				<th>学期</th>
  				<th>相似度检测</th>
  				<th>操作</th>
  			</tr>
		        <c:forEach items="${triList}" var="titleReviewInfo">
		       	 	<tr>
							<td><span>${titleReviewInfo.trId }</span></td>
							<td><span>${titleReviewInfo.titleId }</span></td>
							<td><span>${titleReviewInfo.titleName }</span></td>
							<td><span>${titleReviewInfo.reviewState }</span></td>
							<td><span>${titleReviewInfo.reviewSuggestion }</span></td>
							<td><span>${titleReviewInfo.term }</span></td>
							<td><span>${titleReviewInfo.titleExamine }</span></td>
							<td><a href="permitPass/${titleReviewInfo.titleId }">准许通过</a></td>
					</tr>
				</c:forEach>
			</table>
  </body>
</html>

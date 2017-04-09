<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<form action="main/fileUploadDownload/downloadFile" method="post" >  
			
<!-- 	   	输入学号：<input type="text" name="fileName"> -->
				<div style="font-weight: bold;font-size: 18px">
				文件名:</div>
	   	<c:forEach items="${fileNames}" var="onefileName">
	   		<fieldset data-role="controlgroup">				
				<label for="radio-choice-1a">${onefileName}</label>
				<input name="fileName" id="radio-choice-1a" value="${onefileName}"
				type="radio" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
			</fieldset>  
	   	</c:forEach>
	   	
	    <input type="submit" value="下载">   
	</form>  
	

  </body>
</html>

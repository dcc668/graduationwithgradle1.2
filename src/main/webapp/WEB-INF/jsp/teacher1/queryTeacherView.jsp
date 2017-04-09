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
	<script type="text/javascript" src="<%=path%>/scripts/jquery-1.9.1.min.js"></script>
  
<script type="text/javascript">
	function del(id){
		  var statu = confirm("你确定删除？");
	        if(!statu){
	            return false;
	        }
		$("#deleteForm").attr("action","main/teacher/deleteTeacher/"+id+"");
		document.forms[0].submit(); 
	}
</script>
  </head>
  <body>
	<form id="deleteForm"action="" method="get">
	</form>
  
  			<table >
  			<tr>
  				<th>工号</th>
  				<th>姓名</th>
  				<th>性别</th>
  				<th>职位</th>
  				<th>电话</th>
  				<th>E-Mail</th>
  				<th>QQ</th>
  				<th colspan="2">操作</th>
  			</tr>
  	
		        <c:forEach items="${teaInfs}" var="titleReviewInfo">
		       	 	<tr>
							<td><span>${titleReviewInfo.tId }</span></td>
							<td><span>${titleReviewInfo.tName }</span></td>
							<td><span>${titleReviewInfo.tSex }</span></td>
							<td><span>${titleReviewInfo.tPosition }</span></td>
							<td><span>${titleReviewInfo.tTel }</span></td>
							<td><span>${titleReviewInfo.tMail }</span></td>
							<td><span>${titleReviewInfo.tQQ }</span></td>
							<td><a href="<c:url value='main/teacher/updateTeacherView/${titleReviewInfo.tId }'/>">更新</a></td> 
<%-- 							<td ><a href="<c:url value='main/teacher/deleteTeacher/${titleReviewInfo.tId }' />">删除</a></td> --%>
<%-- 							<td ><a href="javascript:del1('${titleReviewInfo.tId }')">更新</a></td> --%>
							<td ><a href="javascript:del('${titleReviewInfo.tId }')">删除</a></td>
					</tr>
				</c:forEach>
				
			</table>
  </body>
</html>

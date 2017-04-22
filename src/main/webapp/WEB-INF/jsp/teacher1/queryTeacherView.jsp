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
		$("#deleteForm").attr("action","/teacher/deleteTeacher/"+id+"");
		document.forms[0].submit(); 
	}
</script>
  </head>
  <body>
  <h2 style="text-align: center;font-family: serif">查询更改</h2>
	<form id="deleteForm"action="" method="get">
	</form>
  
  			<table style="margin: 0 auto;width: 680px;border-top: solid 2px black;border-bottom: solid 2px black">
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
							<td><span>${titleReviewInfo.teId }</span></td>
							<td><span>${titleReviewInfo.teName }</span></td>
							<td><span>${titleReviewInfo.teSex }</span></td>
							<td><span>${titleReviewInfo.tePosition }</span></td>
							<td><span>${titleReviewInfo.teTel }</span></td>
							<td><span>${titleReviewInfo.teMail }</span></td>
							<td><span>${titleReviewInfo.teQQ }</span></td>
							<td><a href="<c:url value='/teacher/updateTeacherView/${titleReviewInfo.teId }'/>">更新</a></td>
							<td ><a href="javascript:del('${titleReviewInfo.teId }')">删除</a></td>
					</tr>
				</c:forEach>
				
			</table>
  </body>
</html>

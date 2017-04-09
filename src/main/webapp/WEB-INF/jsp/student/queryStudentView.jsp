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
		$("#deleteForm").attr("action","main/student/deleteStudent/"+id+"");
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
  				<th>密码</th>
  				<th>性别</th>
  				<th>班级</th>
  				<th>专业代码</th>
  				<th>电话</th>
  				<th>E-Mail</th>
  				<th>QQ</th>
  				<th colspan="2">操作</th>
  			</tr>
  	
		        <c:forEach items="${teaInfs}" var="titleReviewInfo">
		       	 	<tr>
							<td><span>${titleReviewInfo.id }</span></td>
							<td><span>${titleReviewInfo.sName }</span></td>
							<td><span>${titleReviewInfo.sPassword }</span></td>
							<td><span>${titleReviewInfo.sSex }</span></td>
							<td><span>${titleReviewInfo.sClass }</span></td>
							<td><span>${titleReviewInfo.majorId }</span></td>
							<td><span>${titleReviewInfo.sTel }</span></td>
							<td><span>${titleReviewInfo.sMail }</span></td>
							<td><span>${titleReviewInfo.sQQ }</span></td>
							<td><a href="<c:url value='main/student/updateStudentView/${titleReviewInfo.id }'/>">更新</a></td> 
<%-- 							<td ><a href="<c:url value='main/student/deleteStudent/${titleReviewInfo.id }' />">删除</a></td> --%>
<%-- 							<td ><a href="javascript:del1('${titleReviewInfo.tId }')">更新</a></td>--%>
							<td ><a  href="javascript:del('${titleReviewInfo.id }')">删除</a></td> 
					</tr>
				</c:forEach>
				
			</table>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="<%=path%>/scripts/jquery-1.9.1.min.js"></script>
  
  <script>
      

        $(document).ready(function(){
        
                  $("#"+"1222").click(function(){
                  		var b=$("a").attr("href");
                  		alert(b);
                  	/*  if(${titleReviewInfo.nowStuNum >=titleReviewInfo.nowStuNum }){
                  		 alert("注意:人数已满,请选择其他课题2"+a);
	                	 $("a").attr("href","main/student/stuChooseTitle/"+a+" ");
                 	 
                  	 }
                  	 if(${titleReviewInfo.nowStuNum <titleReviewInfo.nowStuNum }){
                  		var a=$("a").attr("href");
                  		 alert("注意:人数已满,请选择其他课题1"+a);
                	 	$("a").attr("href","main/student/stuChooseTitleView");
                  		 
                  	 } */
                });

        });

</script>
  
  
  </head>
  
  <body>
  			<table >
  			<tr>
  				<th>题目ID</th>
  				<th>题目名称</th>
  				<th>评审状态</th>
  				<th>学期</th>
  				<th>已选人数</th>
  				<th>需要人数</th>
  				<th>操作</th>
  			</tr>
		        <c:forEach items="${triList}" var="titleReviewInfo">
		       	 	<tr>
							<td><span>${titleReviewInfo.titleId }</span></td>
							<td><span>${titleReviewInfo.titleName }</span></td>
							<td><span>${titleReviewInfo.reviewState }</span></td>
							<td><span>${titleReviewInfo.term }</span></td>
							<td><span>${titleReviewInfo.nowStuNum }</span></td>
							<td><span>${titleReviewInfo.needStuNum }</span></td>
							<td><a href="<c:url value='main/student/stuChooseTitle/${titleReviewInfo.titleId }'/>">选择该题目</a></td> 
					</tr>
				</c:forEach>
			</table>

  </body>
</html>

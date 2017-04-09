<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>教师年度工作填报系统</title>
<jsp:include page="/inc/head.jsp"></jsp:include>  
<script type="text/javascript">
if(top!=this) {
   top.location=this.location;
}
</script>
</head>
<body>
<div id="content" class="login">
<h1><img src="<c:url value='/styles/img/icons/lock-closed.png'/>" />教师年度填报系统</h1>
	<form:form modelAttribute="loginCommand">
	<div><form:errors path="*" element="div" cssClass="notif tip close"/></div>
          <div class="input placeholder">
		      <label for="login">用户名</label>
		      <form:input path="username"/>
		  </div>
		  <div class="input placeholder">
		      <label for="pass">密 码</label>
		      <form:password path="password"/>
	      </div>
<%--           <div class="checkbox">
		      <form:checkbox path="rememberMe"/>
		      <label class="inline" for="remember">Remember me</label>
		  </div> --%>
				<fieldset data-role="controlgroup" id="position">				
									<legend></legend>
									<div style="font-weight: bold;font-size: 18px">
									身份:</div>
									<label for="radio-choice-1a">教师:</label>
									<input name="position" id="radio-choice-1a" value="teacher"
										type="radio" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
									<label for="radio-choice-1b">学生:</label>
									<input name="position" id="radio-choice-1b" value="student"
										type="radio"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
									<label for="radio-choice-1c">评审员:</label>
									<input name="position" id="radio-choice-1c"value="reviewer"  
										type="radio" />
										
									<label for="radio-choice-1d">管理员:</label>
									<input name="position" id="radio-choice-1d"value="manage" 
										type="radio" checked="checked" />&nbsp;&nbsp;&nbsp;&nbsp;
								</fieldset>
          
<%-- 		      学生<form:radiobutton path="userPosition" value="student"/>
		      教师<form:radiobutton path="userPosition" value="teacher"/> --%>
		 <%--      管理员<form:radiobutton path="userPosition"  />  --%>
          <div class="submit">
	      	<input type="submit" value="登 录"/>
		  </div>
   </form:form>
</div>         
</body>
</html>
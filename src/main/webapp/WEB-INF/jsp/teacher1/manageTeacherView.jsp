<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="select" uri="http://www.cxy808.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>RapidSH:Spring-Hibernate Application</title>
<c:set var="checkAll" scope="session">
    <input type="checkbox" name="allbox" onclick="rapidsh.checkAllBox(this.form)" style="margin: 0 0 0 4px" />
</c:set>
<%
String ctx =  request.getContextPath();
%>
<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="<%=ctx %>/scripts/libs/jquery/1.6/jquery.min.js"/></script>
<script type="text/javascript" src="<%=ctx %>/scripts/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>
<link rel="stylesheet" href="<%=ctx %>/styles/content/settings/style.css" />
<link rel="stylesheet" href="<%=ctx %>/styles/css/min.css" />
<script type="text/javascript" src="<%=ctx %>/scripts/min.js"></script>
<script type="text/javascript" src="<%=ctx %>/styles/content/settings/main.js"></script>

<link rel="stylesheet" href="<%=ctx %>/styles/displaytag/css/screen.css" type="text/css"/>
<link rel="stylesheet" href="<%=ctx %>/styles/common.css" type="text/css"/>
<script type="text/javascript" src="<%=ctx %>/scripts/common.js" ></script>
<script type="text/javascript" src="<%=ctx %>/scripts/ready.js" ></script>
</head>
<body>
  	<div style="margin-left: 240px;font-size: 24px;">
  		<a href="addTeacherView" target="contentFrame1">添加</a>
  		<a href="queryTeacherView" target="contentFrame1">查询</a>
  	</div>
			
<div style="margin-left: 160px;margin-top: 18px" >
	<iframe  src="" name="contentFrame1" id="contentFrameId1" width="900"  height="600" 	frameborder="no" border="0" scrolling="no" allowtransparency="yes"></iframe>
</div>

</body>
</html>
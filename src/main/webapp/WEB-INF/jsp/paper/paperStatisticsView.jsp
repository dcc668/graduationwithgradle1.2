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
    
    <title>年度论文统计</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  <input type="hidden" id="years" value="${years}"/>s
  <input type="hidden" id="indexs" value="${idxs}"/>
  <div style="text-align: center;"><h1>年度论文统计</h1></div>
  <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

  </body>
  <script type="text/javascript" src="${basePath}/static/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="${basePath}/static/paper/highcharts.js"></script>
  <script type="text/javascript" src="${basePath}/static/paper/exporting.js"></script>
  <script type="text/javascript" src="${basePath}/static/paper/paper_chart.js"></script>
</html>

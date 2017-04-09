<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	
	<script src="<%=path %>/scripts/Chart.js"></script>
	<meta name = "viewport" content = "initial-scale = 1, user-scalable = no">
		<style>
			canvas{
			}
		</style>
  </head>
  	<body>
  	<div style="margin-top:100 ">
  	<table>
  		<tr>
  			<td style="font-weight: bold;">已选学生：</td>
  			<td>${shooseDone}人</td>
  		</tr>
  		<tr>
  			<td style="font-weight: bold;">未选学生：</td>
  			<td>${shooseNot}人</td>
  		</tr>
  		
  	</table>
  	</div>
  	
  	<div style="margin-left: 300;margin-top: 0 ;position: relative;">
		<canvas id="canvas" height="200" width="200"></canvas>
	</div>

	<script>

		var a=${shooseDone};
		var b=${shooseNot};
		var pieData = [
				{
					value: a,
					color:"#F38630"
					,text: "已选"
				},
				{
					value : b,
					color : "#E0E4CC"
					,text: "未选"
				}
	
			];

	var myPie = new Chart(document.getElementById("canvas").getContext("2d")).Pie(pieData);
	
	</script>
	</body>
  
  
</html>

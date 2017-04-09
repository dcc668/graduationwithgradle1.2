<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Success</title>
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.core.css">
    <link rel="stylesheet" href="${basePath}/static/alertify/alertify.default.css">
</head>
<body>
<h1>Failure....</h1>
<h1>${msg}</h1>
</body>
<script type="text/javascript" src="${basePath}/static/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${basePath}/static/alertify/alertify.js"></script>
<script type="text/javascript">
    $(function(){
        alertify.set({
            labels : {
                ok     : "确认",
                cancel : "取消"
            },
            delay : 2000,
            buttonReverse : false,
            buttonFocus   : "ok"
        });
        alertify.alert("操作失敗");
    });

</script>


</html>

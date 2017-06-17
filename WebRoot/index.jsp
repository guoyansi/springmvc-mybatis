<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	
  </head>
  
  <body>
    <button onclick="goPage()">跳转到view里面</button>
  </body>
  <script type="text/javascript">
  	function goPage(){
  		window.location.href="<%=path%>/gysDemo/page.do?id=3";
  	}
  </script>
</html>

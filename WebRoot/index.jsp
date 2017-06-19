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
	 <link rel="stylesheet" type="text/css" href="<%=path %>/resource/lazy/face/4/css/base.css">
	 <script type="text/javascript" src="<%=path %>/resource/lazy/js/jquery-2.1.4.min.js"></script>
  </head>
  
  <body>
    <button onclick="goPage()">跳转到view里面</button>
    <img src="<%=path %>/yzm.do?_=new Date().getTime()"  style="cursor: pointer;" onclick="getYzm($(this))"/>
  </body>
  <script type="text/javascript">
  	function goPage(){
  		window.location.href="<%=path%>/gysDemo/page.do?id=3";
  	}
  	function getYzm(obj){
  		obj.attr("src","<%=path %>/yzm.do?_="+new Date().getTime());
  	}
  </script>
</html>

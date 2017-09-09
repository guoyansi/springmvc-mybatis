<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../common/meta.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>测试ajax</title>
    <link rel="stylesheet" type="text/css" href="${path }/resource/lazy/ui/load/load.css">
	<script type="text/javascript" src="${path }/resource/lazy/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="${path }/resource/lazy/js/bridge26.js"></script>
	<script type="text/javascript" src="${path }/resource/lazy/js/tools.js"></script>
	<script type="text/javascript" src="${path }/resource/lazy/ui/load/load.js"></script>
  </head>
  
  <body>
  <button onclick="startAjax();">ajax测试加载效果</button>
  <button onclick="ajaxList();">ajax测试传递list</button>
  </body>
  <script type="text/javascript">
  	function startAjax(){
  		bg.ajax({
  			load:true,
  			loadText:"加载中...",
  			fail:true,
  			always:false,
  			url:"${path}/gysDemo/testAjax",
  			success:function(data){
  				console.log(data);
  			}
  		});
  	}
  	/*
  	ajax传递带有list格式的数据,需要添加
  	contentType:"application/json",
  	已经把参数转换成list格式
  	*/
  	function ajaxList(){
  		var data={name:"guoyansi",jobs:[]};
  		data.jobs.push("乒乓球");
  		data.jobs.push("羽毛球");
  		data.jobs.push("篮球");
  		console.log(data);
  		bg.ajax({
  			url:"${path}/gysDemo/ajaxList",
  			data:JSON.stringify(data),
  			contentType:"application/json",
  			success:function(data){
  				console.log(data);
  			}
  		});
  	}
  </script>
</html>

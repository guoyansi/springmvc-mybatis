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
	 <script type="text/javascript" src="<%=path %>/resource/lazy/js/bridge24.js"></script>
  </head>
  
  <body>
    <button onclick="goPage()">跳转到view里面</button>
    <button onclick="upload()">上传文件</button>
    <button onclick="ajaxHttp1()">ajax请求返回map</button>
    <button onclick="ajaxHttp2()">ajax请求返回string</button>
    <img src="<%=path %>/yzm.do?_=new Date().getTime()"  style="cursor: pointer;" onclick="getYzm($(this))"/>
  </body>
  <script type="text/javascript">
  	function goPage(){
  		window.location.href="<%=path%>/gysDemo/page.do?id=3";
  	}
  	function getYzm(obj){
  		obj.attr("src","<%=path %>/yzm.do?_="+new Date().getTime());
  	}
  	function upload(){
		bg.upload({
			url:"<%=path %>/gysDemo/uploadM2.do",//上传路径
			name:"files",//file name值
			ext:["mp3"],//扩展名
			count:-1,//上传个数,-1不限制
			size:-1,//上传大小,-1不限制,单位是M
			multiple:true,//批量上传
			extFilter:true,//开启系统的扩展名过滤
			start:function(){alert("start");},
			checkFiles:function(files,val){
				console.log("checkFiles");
				console.log(files);
				return true;
			},
			end:function(){},
			data:{},//上传时 携带的参数
			success:function(data){//上传成功
				console.log("结果:");
				console.log(data);
			},
			error:function(msg){//上传失败
				console.error(msg);
			}
		})
	}
  	function ajaxHttp1(){
  		$.ajax({
  			url:"<%=path%>/gysDemo/ajaxHttp1.do",
  			type:"post",
  			data:JSON.stringify({name:"郭延思",age:26}),
  			contentType:"application/json",
  			success:function(data){
  				console.log(data);
  			},
  			error:function(){
  				console.error("error");
  			}
  		});
  	}
  	function ajaxHttp2(){
  		$.ajax({
  			url:"<%=path%>/gysDemo/ajaxHttp2.do",
  			type:"post",
  			data:JSON.stringify({name:"郭延思",age:26}),
  			contentType:"application/json",
  			success:function(data){
  				console.log(data);
  			},
  			error:function(){
  				console.error("error");
  			}
  		});
  	}
  </script>
</html>

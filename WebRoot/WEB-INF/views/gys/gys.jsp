<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色</title>
   <link rel="stylesheet" type="text/css" href="<%=path %>/resource/css/gys.css">
  </head>
  
  <body>
   <h1>角色</h1>
   <%-- <ul>
   	<c:forEach items="${list }" var="role">
		<li>ID:${role.id };name:${role.roleName };note:${role.note }</li>   		
   	</c:forEach>
   </ul> --%>
   ${res.status };${res.msg}
  </body>
</html>

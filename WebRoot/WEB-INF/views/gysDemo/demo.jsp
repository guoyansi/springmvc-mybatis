<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="/gys/dict" %>
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
   <h1>列表</h1>
    <select>
    	<c:forEach items="${dictList }" var="item">
    		<option value="${item.dict_value }">${item.dict_name }</option>
    	</c:forEach>
    </select>
    <hr />
    <select>
    	<d:option dictCode="1001" selected="3"></d:option>
    </select>
    <div>code:1001;value=1 ;性别:<d:dict dictCode="1001" dictValue="3"></d:dict></div>
   <ul>
   	<c:forEach items="${list }" var="role">
		<li>ID:${role.id };name:${role.roleName };note:${role.note }</li>   		
   	</c:forEach>
   </ul>
   ${res.status };${res.msg}
   <div style="color:red;">ID:${bean.id };name:${bean.roleName };note:${bean.note }</div>
  </body>
</html>

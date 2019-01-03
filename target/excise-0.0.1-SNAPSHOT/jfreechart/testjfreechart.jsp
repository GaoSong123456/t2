<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testjfreechart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div><a href="${pageContext.request.contextPath}/zhu.action">柱状图</a><img src="${pageContext.request.contextPath}/make/${zhu}"></div>
    <div><a href="${pageContext.request.contextPath}/line.action">折线图</a><img src="${pageContext.request.contextPath}/make/${line}"></div>
    <div><a href="${pageContext.request.contextPath}/pie.action">饼图</a><img src="${pageContext.request.contextPath}/make/${pie}"></div>
  </body>
</html>

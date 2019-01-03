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
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	  $(function(){
	     $("#btn").click(function(){
	        
	       $(location).attr('href', '${pageContext.request.contextPath}/Department/toAdd.action');
	         
	    });
	    
	    $("#btn2").click(function(){
	        
	       $(location).attr('href', '${pageContext.request.contextPath}/Department/getAllEmployeeInDepartment.action');
	         
	    })

	    
	  })
	</script>
  </head>
  
  <body>
    <input type="button" id="btn" value="添加">
    <input type="button" id="btn2" value="查看所有部门下的员工">
   <table>
    <tr>
      <td>部门编号</td>
      <td>部门名称</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="department">
     
     <tr>
      <td>${department.id}</td>
      <td>${department.name}</td>
      <td><a href="${pageContext.request.contextPath}/Department/toUpdate.action?id=${department.id}">编辑</a>
          <a href="${pageContext.request.contextPath}/Department/deleteById.action?id=${department.id}">删除</a>
      </td>
     </tr>
    </c:forEach>
   </table>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
	 var id=$("#t1").val();
	 var str="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q0=\"http://impl.service.gs.com/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><q0:getDepartment><arg0>"+id+"</arg0> </q0:getDepartment></soapenv:Body></soapenv:Envelope>";
	 $.ajax({
         type:"post",
         data:str,
         contentType:"application/json",
         url:"http://localhost/cxf//DepartmentServiceImpl",
         success:function(res){  
             var re = res.getElementsByTagName("return")[0];
             if(re!=null){
	             var name=re.getElementsByTagName("name")[0];
	             var n=name.textContent;
	             alert(n);
             }
             else{
               alert("对不起，没有查到相关信息");
             }
             
          },
         error:function(err){
             alert(err.responseText);  //出错信息
            }   
        });
        
        }) 
      })
    </script>

  </head>
  
  <body>
         请输入部门编号：<input type="text" id="t1"><input type="button" id="btn" value="提交">
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  	
<frameset rows=105,* cols="*" >
  
  <frame name=ads marginWidth=0 marginHeight=0 
 frameBorder=0 noResize scrolling=no longDesc="">

	<frameset rows=675 cols=120,* frameborder="yes">
	  	<frame name=list marginWidth=0 
		marginHeight=0 src="<%=path%>/left.jsp" 
		frameBorder=0 noResize scrolling=yes longDesc="">
		
		<frame name=main marginWidth=0 
		marginHeight=0 src="<%=path%>/postdata.jsp" 
		frameBorder=0 noResize scrolling=yes longDesc="">
		
		
	</frameset>

  <noframes>  
  <body>   
  </body>
  </noframes>
  
</frameset>
  
</html>

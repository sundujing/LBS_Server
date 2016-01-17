<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.STYLE4 
{
	font-size: 13px;
	font-family: "宋体";
	color: BLACK;
	line-height: 16pt;
}
body
{ 
	font-family: Georgia, serif; 
	background:top center no-repeat #c4c4c4; 
	color: #3a3a3a; 
}
.button
{ 
	background:repeat-x top center; 
	border: 1px solid #999;
	-moz-border-radius: 5px; 
	padding: 5px; color: black; 
	font-weight: bold;
	-webkit-border-radius: 5px; 
	font-size: 20px;  
	width: 70px; 
}
.button:hover
{
	background: white; 
	color: black; 
}
</style>
	
	
<script type="text/javascript">

function login()
{
	var th =document.form1;
	if(th.username.value=="")
	{
		alert("用户名不能为空");
		th.username.focus();
		return;
	}
	if(th.pswd.value=="")
	{
		alert("密码不能为空");
		th.pswd.focus();
		return;
	}
	th.action="<%=path%>/servlet/LoginAction?action_flag=login";
	th.submit();
}

</script>
  </head>
  
  <body>
    <center><font color="black" size="10">基于位置的推荐系统</font></center>
	
	<form action="" method="post" name="form1" >
	<center><br><br><br><br>
	<table>
	<tr>
		<td>
		<table>
		<tr>
			<td><font color="black"><b>用户名:&nbsp;</b><td>
			<input type="text" name="username" id="username" style="width:120">
			<br></td></tr>
					
		<tr>
			<td><font color="black"><b>密&nbsp;&nbsp;码:</b><td>
			<input type="password" name="pswd" id="password" style="width:120">
			<br></td></tr>
			
			
		<tr height="20">
			<td></td>
		</tr>
		
		<tr align="center">
		
			<td><input type="submit" class="button" value="登录" onclick="login()"></td>
			<td><input type="reset" class="button" value="重置"></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=path%>/pass.jsp">没有账号？请注册</a></td>
		</tr>
			
		</table>
		</td>
	</tr>
	</table>
	</center>
	</form>
	
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type=text/css>
		.neon 
		{
			FILTER: glow(color=#002E60,strength=3)
		}
		DIV 
		{
			WIDTH: 70px
		}
		BODY 
		{
			MARGIN: 0px
		}
		BODY 
		{
			MARGIN-TOP: 0px; 
			SCROLLBAR-FACE-COLOR: #005fc5; 
			FONT-SIZE: 12px; 
			BACKGROUND: #ffffff; 
			SCROLLBAR-HIGHLIGHT-COLOR: #799ae1; 
			SCROLLBAR-SHADOW-COLOR: #799ae1; 
			SCROLLBAR-3DLIGHT-COLOR: #005fc5; 
			SCROLLBAR-ARROW-COLOR: #ffffff; 
			SCROLLBAR-TRACK-COLOR: #aabfec; 
			SCROLLBAR-DARKSHADOW-COLOR: #799ae1
		}
	</style>


<script type="text/javascript">
function dosubmit()
{
	var th =document.form1;
	if(th.username.value=="")
	{
		alert("用户名不能为空");
		th.username.focus();
		return;
	}
	if(th.age.value=="")
	{
		alert("年龄不能为空");
		th.age.focus();
		return;
	}
	if(th.pswd.value=="")
	{
		alert("密码不能为空");
		th.pswd.focus();
		return;
	}
	th.action="<%=path%>/servlet/RegisterAction";
	th.submit();
}
</script>
  </head>
  
  <body>
<form action="" name="form1" method="post">
<table height=470 cellSpacing=0 cellPadding=0 width=580 align=center border=0>
  <tbody>
  <tr>
    <td colSpan=3 height=9></td>
  </tr>
  
    <td vAlign=top align=right width=743 height=452>
    <table cellSpacing=0 cellPadding=0 width=556 border=0>
    
      <!--DWLayoutTable-->
      <tbody>
        <tr>
          <td vAlign=bottom width=548 height=27> <span class="lbt">用户注册</span></td>
          <td width=8 rowSpan=3>&nbsp;</td>
        </tr>
        
        <tr>
          <td class=unnamed1 vAlign=top height=9>
          <table width="99%" border=0 cellPadding=4 cellSpacing=1 bgColor=#0867b3>
            <tbody>
              <tr bgColor=#ffffff height=20>
                <td width=20% >用户名</td>
                <td width=75% valign="top" noWrap><input class=text2 maxLength=20 
            		size=18 name="username" minLength="1"></td>
                <td width=5% noWrap><span >*</span></td>
              </tr>
              <tr bgColor=#ffffff height=20>
                <td height="4" noWrap><span>年&nbsp;&nbsp;龄</span></td>
                <td height="4" valign="top" noWrap><input class=text2 maxLength=20 
            		size=18 name="age" minLength="1"></td>
                <td height="4" noWrap><span >*</span></td>
              </tr>
              <tr bgColor=#ffffff height=20>
                <td height="2" noWrap><span>密码 </span></td>
                <td height="2" valign="top" noWrap><input  type="password" class=text2 maxLength=20 
            		size=18 name="pswd" minLength="1"></td>
                <td height="2" noWrap><span >*</span></td>
              </tr>
            </tbody>
          </table>
          <br>
          </td>
        </tr>
        
         <td height=20 align="left"> *项必填填写！</td>
        
        <tr>    
          <td height=20 align="center"><a href="javascript:dosubmit();" >确定</a>&nbsp;
          		<a href="<%=path %>/index.jsp" >返回</a></td>
          <td></td>
        </tr>
      </tbody>
      
    </table>
    </td>
  </tbody>
</table>
</form>

  </body>
</html>

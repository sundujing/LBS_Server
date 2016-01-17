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
<style type=text/css>
	.neon 
	{
		FILTER: glow(color = #002E60, strength = 3)
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
		SCROLLBAR-FACE-COLOR: #005FC5;
		FONT-SIZE: 12px;
		BACKGROUND: #FFFFFF;
		SCROLLBAR-HIGHLIGHT-COLOR: #799AE1;
		SCROLLBAR-SHADOW-COLOR: #799AE1;
		SCROLLBAR-3DLIGHT-COLOR: #005FC5;
		SCROLLBAR-ARROW-COLOR: #FFFFFF;
		SCROLLBAR-TRACK-COLOR: #AABFEC;
		SCROLLBAR-DARKSHADOW-COLOR: #799AE1
	}
</style>
	
<link href="<%=path%>/images/duan_1.css" type=text/css rel=stylesheet>
	
<style type="text/css">
<!--
	.STYLE1 
	{
		color: #FF0000;
		font-size: 12px;
	}
	.STYLE7 
	{
		COLOR: #003366;
		font-size: 12px;
	}
	.lbt
	{
		font-size: 40px;
		width: 500px;
		color: blue;
	}
	.lbt2
	{
		font-size: 20px;
	}
	.href
	{
		font-size: 25px;
	}
	
-->
</style>
	
<script type="text/JavaScript">
<!--
function MM_preloadImages() 
{ //v3.0
	var d=document; if(d.images)
	{ 
		if(!d.MM_p) d.MM_p=new Array();
		var i,j = d.MM_p.length,a = MM_preloadImages.arguments; 
		for(i=0; i<a.length; i++)
		{
	    	if (a[i].indexOf("#")!=0)
	    	{ 
	    		d.MM_p[j]=new Image; 
	    		d.MM_p[j++].src=a[i];
	    	}
    	}
    }
}
//-->
</script>

  </head>
  
  <body bgColor=#FFFFFF>
	<td>
	<table width="100%" height="100%" border="0" cellpadding="0"
				cellspacing="0" bgcolor="#005FC6">
		<td bgcolor="#005FC6">
		<table width=100% border=0 align=center cellPadding=0 cellSpacing=0
						bgcolor="#FFFFFF">
			<tbody>
			<tr>
				<td>
				<table height=426 cellSpacing=0 cellPadding=0 width=580
										align=center border=0>
					<tbody>
					<tr>
						<td colSpan=3 height=9></td>
					</tr>
					<tr>
						<td vAlign=top width=8 
							background="<%=path%>/images/dhpddw.gif" rowSpan=2>
							<!--DWLayoutEmptyCell--> 
							&nbsp;
						</td>
						<td width=743 background="<%=path%>/images/h-1.gif" height=9>
						</td>
						<td width=9 height=9>
							<img height=9 src="<%=path%>/images/jiao.gif" width=9>
						</td>
					</tr>
					<tr>
						<td vAlign=top align=right width=743 height=408>
						<table cellSpacing=0 cellPadding=0 width=556 border=0>
							<!--DWLayoutTable-->
							<tbody>
							<tr>
								<td vAlign=bottom width=548 height=27>
									<img height=10 src="<%=path%>/images/jt2.gif" width=10>
									<div align="center">
										<marquee class=lbt direction="left"><b>欢迎使用推荐系统！</b></marquee>
									</div>
								</td>
								<td width=8 rowSpan=3>&nbsp;
								</td>
							</tr>
							
							
							<tr>
								<td class=unnamed1 vAlign=top height=9>
									<!--DWLayoutEmptyCell-->
									&nbsp;
									<br><br><br><br>
									<span class=lbt2>点击产品信息，进入管理页面！</span>
								</td>
							</tr>
							<tr>
								<td height=27 colspan="2" vAlign=top>
									<!--DWLayoutEmptyCell-->
									&nbsp;
									<br>
									<a class="href" href="<%=path%>/servlet/ProductAction?action_flag=list&pageNum=1"
								target="main" class=yd >产品信息</a>
								
								</td>
							</tr>
							<tr>
								<td height=20>&nbsp;</td>
								<td></td>
							</tr>
							</tbody>
						</table>
						</td>
					</tr>
					</tbody>
					
				</table>
				</td>
			</tr>
			</tbody>
			
		</table>
		&nbsp;
		</td>
	</table>
	</td>
  </body>
	
</html>


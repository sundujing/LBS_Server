<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.dbutil.product.util.*"%>
<%
	String path = request.getContextPath();
	String proname = (String) request.getAttribute("proname");
	proname = (proname == null ? "" : proname);
	String bcategory = (String) request.getAttribute("bcategory");
	bcategory = (bcategory == null ? "" : bcategory);
	String scategory = (String) request.getAttribute("scategory");
	scategory = (scategory == null ? "" : scategory);
	List<Map<String, Object>> list = (List<Map<String, Object>>) request
			.getAttribute("listproduct");
	DividePage pUtil = (DividePage) request.getAttribute("pUtil");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>后台管理系统</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<META content="" name=keywords>
		<META content=name=description>
		<STYLE type=text/css>
.neon {
	FILTER: glow(color =     #002E60, strength =     3)
}

DIV {
	WIDTH: 70px
}

BODY {
	MARGIN: 0px
}

BODY {
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
</STYLE>
		<LINK href="<%=path%>/images/duan_1.css" type=text/css rel=stylesheet>
		<META content="MSHTML 6.00.2800.1106" name=GENERATOR>
		<style type="text/css">
<!--
.STYLE7 {
	COLOR: #003366;
	font-size: 12px;
}
-->
</style>
		<script type="text/javascript">
	function search()
	{
	var th=document.form1;
	th.action="<%=path%>/servlet/ProductAction?action_flag=list";
	th.submit();
	}
	function first()
	{
	var th=document.form1;
	th.action="<%=path%>/servlet/ProductAction?action_flag=list&pageNum=1";
	th.submit();
	}
	function forward()
	{
	var th=document.form1;
	th.action="<%=path%>/servlet/ProductAction?action_flag=list&pageNum=<%=pUtil.getcurrentPage() - 1%>";
	th.submit();
	}
	function next()
	{
	var th=document.form1;
	th.action="<%=path%>/servlet/ProductAction?action_flag=list&pageNum=<%=pUtil.getcurrentPage() + 1%>";
	th.submit();
	}
	function end()
	{
	var th=document.form1;
	th.action="<%=path%>/servlet/ProductAction?action_flag=list&pageNum=<%=pUtil.getPageCount()%>";
	th.submit();
	}
	function changePage(currentPage)
	{
	var th=document.form1;
	th.action="<%=path%>/servlet/ProductAction?action_flag=list&pageNum="+currentPage;
	th.submit();
	}
	function selectAll(flag)
	{
	var ids = document.getElementsByName("ids");
	for(var i=0;i<ids.length;i++)
	{ids[i].checked=flag;
	}
	}
	function getSelectCount()
	{
	var count = 0;
	var ids=document.getElementsByName("ids");
	for(var i=0;i<ids.length;i++)
	{
	if(ids[i].checked)
	{
	count++;
	}
	}
	return count;
	}
	function getSelectValue()
	{
	var ids=document.getElementsByName("ids");
	for(var i=0;i<ids.length;i++)
	{if(ids[i].checked)
	{return ids[i].value;
	}
	}
	}
	function del()
	{
	var th=document.form1;
	if(getSelectCount()<1)
	{
	alert("至少要选中一个选项");
	return;
	}
	th.action="<%=path%>/servlet/ProductAction?action_flag=del";
	th.submit();
	}
	function view()
	{
		var th=document.form1;
		if(getSelectCount()<1)
		{
			alert("至少要选中一个选项");
			return;
		}
		if(getSelectCount()>1)
		{
			alert("仅能选中一个选项");
			return;
		}
		th.action="<%=path%>/servlet/ProductAction?action_flag=view&OID="+getSelectValue();
		th.submit();
	}
	
	function update()
	{
		var th=document.form1;
		if(getSelectCount()<1)
		{
			alert("至少要选中一个选项");
			return;
		}
		if(getSelectCount()>1)
		{
			alert("仅能选中一个选项");
			return;
		}
		th.action="<%=path%>/servlet/ProductAction?action_flag=update1&OID="+getSelectValue();
		th.submit();
	}
	</script>
	</HEAD>
	<BODY>
		<form action="" name="form1" method="post">
			<TABLE height=433 cellSpacing=0 cellPadding=0 width=580 align=center
				border=0>
				<TBODY>
					<TR>
						<TD colSpan=3 height=9></TD>
					</TR>


					<TR>
						<TD vAlign=top align=right width=739 height=415>
							<TABLE cellSpacing=0 cellPadding=0 width=556 border=0>
								<!--DWLayoutTable-->
								<TBODY>
									<TR>
										<TD vAlign=bottom width=548 height=27>

											<span class="lbt">商家管理模块&gt;&gt;商家信息_查询</span>
										</TD>
										<TD width=8 rowSpan=3>
											&nbsp;
										</TD>
									</TR>
									<TR>
										<TD background="<%=path%>/images/ht.gif" height=22></TD>
									</TR>
									<TR>
										<TD class=unnamed1 vAlign=top height=9>
											<TABLE width="99%" border=0 cellPadding=4 cellSpacing=1
												bgColor=#0867b3>
												<TBODY>
													<TR bgColor=#ffffff height=20>
														<TD>
															商家名称
														</TD>
														<TD width=31% noWrap>
															<span> <INPUT class=text2 maxLength=20 size=18
																	name="proname" minLength="1" value="<%=proname%>">
															</span>
														</TD>

													</TR>
													<TR bgColor=#ffffff height=20>
														<TD>
															大类别
														</TD>
														<TD width=31% noWrap>
															<span> <INPUT class=text2 maxLength=20 size=18
																	name="bcategory" minLength="1" value="<%=bcategory%>">
															</span>
														</TD>

													</TR>
													<TR bgColor=#ffffff height=20>
														<TD>
															小类别
														</TD>
														<TD width=31% noWrap>
															<span> <INPUT class=text2 maxLength=20 size=18
																	name="scategory" minLength="1" value="<%=scategory%>">
															</span>
														</TD>

													</TR>

												</TBODY>
											</TABLE>
											<br>
										</TD>
									</TR>
									<TR>
										<TD height=27 colspan="2" align="center" vAlign=top>
											<a href="javascript:search();">查询 </a>&nbsp;
											<a href="<%=path%>/product/2_1_5tj.jsp">添加</a>
										</TD>
									</TR>
									<TR>
										<TD height=94 vAlign=top>
											<span class="lbt">查询结果</span>
											<br>
											<br>
											<TABLE width="99%" border=0 cellPadding=4 cellSpacing=1
												bgColor=#0867b3>
												<!--DWLayoutTable-->
												<TBODY>
													<TR bgColor=#ffffff height=20>
														<TD width=24 height="20" align="center" noWrap
															class="STYLE7">
															<input type="checkbox" name="checkall" value=""
																onclick="javascript:selectAll(this.checked);">
														</TD>
														<TD width=70 align="center" noWrap>
															商家名称
														</TD>
														<TD width=128 align="center" noWrap>
															大类别
														</TD>
														<TD width=128 align="center" noWrap>
															小类别
														</TD>
														<TD width=60 align="center" noWrap>
															纬度
														</TD>
														<TD width=60 align="center" noWrap>
															经度
														</TD>
													</TR>
													<%
														if (!list.isEmpty())
														{
															for (Map<String, Object> map : list)
															{
													%>
													<TR bgColor=#ffffff height=2>
														<TD height="28" align="center" valign="top" noWrap>
															<input name="ids" type="checkbox" class="text2"
																value="<%=map.get("OID")%>">
														</TD>
														<TD align="center" valign="middle" noWrap>
															<span class="foot3"><%=map.get("proname")%></span>
														</TD>
														<TD align="center" valign="middle" noWrap class="foot3"><%=map.get("bcategory")%></TD>
														<TD align="center" valign="middle">
															<span class="foot3"><%=map.get("scategory")%></span>
														</TD>
														<TD align="center" valign="middle">
															<span class="foot3"><%=map.get("latitude")%></span>
														</TD>
														<TD align="center" valign="middle">
															<span class="foot3"><%=map.get("longitude")%></span>
														</TD>

													</TR>
													<%
														}
														}
													%>
												</TBODY>
											</TABLE>
											<br>

											<a href="javascript:del();">删除</a>&nbsp;
											<a href="javascript:view();">查看</a>&nbsp;
											<a href="javascript:update();">修改</a>
											<br>
											<table width="99%" border=0 cellpadding=4 cellspacing=1
												bgcolor=#0867b3>
												<!--DWLayoutTable-->
												<tbody>
													<tr bgcolor=#ffffff height=20>
														<td height="20" align="center" valign="middle" nowrap>
															<span>共<%=pUtil.getPageCount()%>页</span>&nbsp;
															<a href="javascript:first();" class="dh2">首页</a>&nbsp;
															<a href="javascript:forward();" class="dh2">上一页</a>&nbsp;
															<a href="javascript:next();" class="dh2">下一页</a>&nbsp;
															<a href="javascript:end();" class="dh2">尾页</a>&nbsp;
															<span>跳转到</span>
															<select name="select" class="text2" style="WIDTH: 40px"
																onchange="changePage(this.value)">
																<%
																	int len = pUtil.getPageCount();
																	for (int i = 1; i <= len; i++)
																	{
																%>
																<option value="<%=i%>"
																	<%=(i == pUtil.getcurrentPage() ? "selected" : "")%>>
																	<%=i%>
																</option>
																<%
																	}
																%>
															</select>
														</td>
													</tr>
												</tbody>
											</table>
										</TD>
										<TD></TD>
									</TR>
									<TR>
										<TD height=20>
											&nbsp;
										</TD>
										<TD></TD>
									</TR>
								</TBODY>
							</TABLE>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
		</form>

	</BODY>
</HTML>

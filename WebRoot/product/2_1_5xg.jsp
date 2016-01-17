<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META 
content="" 
name=keywords>
<META content= name=description>
<STYLE type=text/css>
.neon {
	FILTER: glow(color=#002E60,strength=3)
}
DIV {
	WIDTH: 70px
}
BODY {
	MARGIN: 0px
}
BODY {
	MARGIN-TOP: 0px; SCROLLBAR-FACE-COLOR: #005fc5; FONT-SIZE: 12px; BACKGROUND: #ffffff; SCROLLBAR-HIGHLIGHT-COLOR: #799ae1; SCROLLBAR-SHADOW-COLOR: #799ae1; SCROLLBAR-3DLIGHT-COLOR: #005fc5; SCROLLBAR-ARROW-COLOR: #ffffff; SCROLLBAR-TRACK-COLOR: #aabfec; SCROLLBAR-DARKSHADOW-COLOR: #799ae1
}
</STYLE>
<LINK href="<%=path %>/images/duan_1.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2800.1106" name=GENERATOR>
<style type="text/css">
<!--
.STYLE7 {COLOR: #003366; font-size: 12px;}
-->
</style>
<script type="text/JavaScript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
</HEAD>
<BODY bgColor=#ffffff onLoad="MM_preloadImages('<%=path %>/images/tj_2.jpg','<%=path %>/images/xg_2.jpg','<%=path %>/images/fh_2.jpg')">
<TABLE height=409 cellSpacing=0 cellPadding=0 width=580 align=center border=0>
  <TBODY>
  <TR>
    <TD colSpan=3 height=9></TD></TR>
  <TR>
    <TD vAlign=top width=12 background="<%=path %>/images/dhpddw.gif" rowSpan=2>&nbsp;</TD>
    <TD width=739 background="<%=path %>/images/h-1.gif" height=9></TD>
    <TD width=9 height=9><IMG height=9 src="<%=path %>/images/jiao.gif" width=9></TD></TR>
  <TR>
    <TD vAlign=top align=right width=739 height=391><TABLE cellSpacing=0 cellPadding=0 width=556 border=0>
      <!--DWLayoutTable-->
      <TBODY>
        <TR>
          <TD vAlign=bottom width=548 height=27><IMG height=10 
            src="<%=path %>/images/jt2.gif" width=10> <span class="lbt">商家信息管理&gt;&gt;商家信息管理_修改</span></TD>
          <TD width=8 rowSpan=3>&nbsp;</TD>
        </TR>
        <TR>
          <TD background="<%=path %>/images/ht.gif" height=22></TD>
        </TR>
        <TR>
          <TD class=unnamed1 vAlign=top 
            height=9><br>
              <TABLE width="99%" 
        border=0 cellPadding=4 cellSpacing=1 bgColor=#0867b3>
                <TBODY>
                  <TR bgColor=#ffffff height=20>
                    <TD width=13% align="center"  noWrap class="STYLE7">编号</TD>
                    <TD width=31% noWrap><span class="foot3">00000000</span></TD>
                    <TD width=18% align="center" noWrap><span class="STYLE7">姓名</span></TD>
                    <TD width=38% noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME392 minLength="1">
                    </span></TD>
                  </TR>
                  <TR bgColor=#ffffff height=20>
                    <TD width=13% align="center"  noWrap class="STYLE7">性别</TD>
                    <TD width=31% noWrap><input name="radiobutton" type="radio" class="text2" value="radiobutton">
                        <span class="foot3">男 </span>
                        <input name="radiobutton" type="radio" class="text2" value="radiobutton">
                        <span class="foot3">女</span></TD>
                    <TD align="center" noWrap><span class="STYLE7">学历</span></TD>
                    <TD noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME3102 minLength="1">
                    </span></TD>
                  </TR>
                  <TR bgColor=#ffffff height=20>
                    <TD height="0" align="center" noWrap><span class="STYLE7">外语1</span></TD>
                    <TD height="0" valign="middle" noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME332 minLength="1">
                    </span></TD>
                    <TD height="0" align="center" noWrap><span class="STYLE7">级别</span></TD>
                    <TD height="0" noWrap><select style="WIDTH: 80px" name="select2" class="text2">
                        <option value="8">-请选择-</option>
                        <option value="1">一级</option>
                        <option value="0">二级</option>
                        <option>三级</option>
                        <option>四级</option>
                        <option>其它</option>
                    </select></TD>
                  </TR>
                  <TR bgColor=#ffffff height=20>
                    <TD height="-1" align="center" noWrap><span class="STYLE7">外语2</span></TD>
                    <TD height="-1" valign="middle" noWrap><span class="STYLE7">
                      <input class=text2  maxlength=20 
            size=18 name=USERNAME3113 minlength="1">
                    </span></TD>
                    <TD height="-1" align="center" noWrap><span class="STYLE7">级别</span></TD>
                    <TD height="-1" noWrap><select style="WIDTH: 80px" name="select" class="text2">
                        <option value="8">-请选择-</option>
                        <option value="1">一级</option>
                        <option value="0">二级</option>
                        <option>三级</option>
                        <option>四级</option>
                        <option>其它</option>
                    </select></TD>
                  </TR>
                  <TR bgColor=#ffffff height=20>
                    <TD height="0" align="center" noWrap><span class="STYLE7">善长技术</span></TD>
                    <TD height="0" valign="middle" noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME342 minLength="1">
                    </span></TD>
                    <TD height="0" align="center" noWrap><span class="STYLE7">工作年限</span></TD>
                    <TD height="0" noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME3122 minLength="1">
                    </span></TD>
                  </TR>
                  <TR bgColor=#ffffff height=20>
                    <TD height="-1" align="center" noWrap><span class="STYLE7">职位</span></TD>
                    <TD height="-1" valign="middle" noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME352 minLength="1">
                    </span></TD>
                    <TD height="-1" align="center" noWrap><span class="STYLE7">合同终止日</span></TD>
                    <TD height="-1" noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME3132 minLength="1">
                    </span></TD>
                  </TR>
                  <TR bgColor=#ffffff height=20>
                    <TD height="-1" align="center" noWrap><span class="STYLE7">电话</span></TD>
                    <TD height="-1" valign="middle" noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME362 minLength="1">
                    </span></TD>
                    <TD height="-1" align="center" noWrap><span class="STYLE7">手机</span></TD>
                    <TD height="-1" noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME3142 minLength="1">
                    </span></TD>
                  </TR>
                  <TR bgColor=#ffffff height=20>
                    <TD height="-1" align="center" noWrap><span class="STYLE7">E-mail</span></TD>
                    <TD height="-1" valign="middle" noWrap><span class="STYLE7">
                      <INPUT class=text2  maxLength=20 
            size=18 name=USERNAME372 minLength="1">
                    </span></TD>
                    <TD height="-1" align="center" noWrap><span class="STYLE7">状态</span></TD>
                    <TD height="-1" noWrap><select style="WIDTH: 80px" name="select" class="text2">
                        <option value="8">-请选择-</option>
                        <option value="1">外派</option>
                        <option value="0">在职</option>
                        <option>离职</option>
                    </select></TD>
                  </TR>
                  <TR bgColor=#ffffff height=20>
                    <TD height="-1" align="center" noWrap><span class="STYLE7">简历</span></TD>
                    <TD height="-1" colspan="3" valign="middle" noWrap><input name="file" type="file" class="text2" size="18">
                      <span class="redred">无简历</span></TD>
                  </TR>
                </TBODY>
              </TABLE>
              <br></TD>
        </TR>
        <TR>
          <TD height=27 colspan="2" align="center" vAlign=top><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image3','','<%=path %>/images/ok_2.jpg',1)"><img src="<%=path %>/images/ok_1.jpg" name="Image3" width="60" height="22" border="0"></a>  <a href="<%=path %>/baseControl/2_1_5.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image4','','<%=path %>/images/fh_2.jpg',1)"><img src="<%=path %>/images/fh_1.jpg" name="Image4" width="60" height="22" border="0"></a></TD>
        </TR>
        <TR>
          <TD height=16 vAlign=top><!--DWLayoutEmptyCell-->&nbsp;</TD>
          <TD></TD>
        </TR>
        <TR>
          <TD height=13>&nbsp;</TD>
          <TD></TD>
        </TR>
      </TBODY>
    </TABLE></TD>
    <TD width=9 background="<%=path %>/images/s-1.gif"></TD></TR></TBODY></TABLE>

</BODY></HTML>


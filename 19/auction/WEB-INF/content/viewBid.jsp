<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2012, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title>�������ȫ������</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr>
<td>
<br />
<table width="80%" align="center" cellpadding="0" cellspacing="1" style="border:1px solid black">
  <tr>
    <td colspan="4" ><div class="mytitle">�������ȫ������</div></td> 
  </tr>
  <tr  height="30">
    <th>��Ʒ��</th>
    <th>����۸�</th>
    <th>����ʱ��</th>
    <th>������</th>
  </tr>
<s:iterator value="bids" id="bid" status="st">
<tr  height="24" <s:if test="#st.odd">
	style="background-color:#dddddd"</s:if>
	<s:else>style="background-color:#eeeeee"</s:else>>
	<td><s:property value="item"/></td>
	<td><s:property value="price"/></td>
	<td><s:property value="bidDate"/></td>
	<td><s:property value="user"/></td>
</tr>
</s:iterator>
</table>
</td>
</tr>
</table>
</body>
</html>
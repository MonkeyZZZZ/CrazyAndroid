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
	<title>��Ʒ��ϸ��Ϣ</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr>
<td>
<table width="80%" align="center" cellpadding="0" 
	cellspacing="1" style="border:1px solid black">
<tr bgcolor="#e1e1e1" >
	<td colspan="2"><div class="mytitle">���������Ʒ��ϸ��Ϣ</div></td> 
</tr>
<tr height="24">
	<td>��Ʒ��</td>
	<td><s:property value="item.name"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����</td>
	<td><s:property value="item.desc"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ��ע</td>
	<td><s:property value="item.remark"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����</td>
	<td><s:property value="item.kind"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ������</td>
	<td bgcolor="#FFFFFF"><s:property value="item.owner"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ���ļ�</td>
	<td><s:property value="item.initPrice"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ��߼�</td>
	<td><s:property value="item.maxPrice"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����ʱ��</td>
	<td><s:property value="item.addTime"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����ʱ��</td>
	<td><s:property value="item.endTime"/></td>
</tr>
<tr  height="32">
	<td colspan="2">&nbsp;</td>
</tr>
<tr  height="24">
	<td colspan="2">
	���������Ȥ�������Ʒ���ۣ�������۸���ύ��
	��ע�⣬���ļ۸�Ӧ������Ʒ����߼�
	<s:actionerror/>
	</td>
</tr>
<tr  height="32">
	<td colspan="2">
	<div align="center">
	<s:form action="bid">
		<input type="hidden" name="itemId" 
			value="<s:property value='item.id'/>"/>
		<input type="hidden" name="maxPrice"
			value="<s:property value='item.maxPrice'/>"/>
		<s:textfield name="bid.bidPrice" label="���ļ�"/>
		<s:textfield name="vercode" label="��֤��"/>
		<s:submit value="����"/>
	</s:form>
	��֤�룺<img name="d" src="auth.jpg">
	</div>
	</td>
</tr>
</table>
</body>
</html>
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
	<title>��ҵ����Java EE������</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr>
<td >
<h3>�������û����������¼ϵͳ</h3>
<div align="center">
<!-- ���Action�Ĵ�����ʾ -->
<s:actionerror cssClass="error"/>
<s:form action="proLogin">
	<s:textfield name="username" label="�û���"/>
	<s:textfield name="password" label="����"/>
	<s:textfield name="vercode" label="��֤��"/>
	<s:submit value="��¼"/>
</s:form>
��֤�룺<img name="d" src="auth.jpg">
</div>
</td>
</tr>
</table>
</body>
</html>
package org.crazyit.auction.action.interceptor;

import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.*;
import java.util.Map;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class AuthorityInterceptor extends AbstractInterceptor
{
	// �����û�����
	public String intercept(ActionInvocation invocation)
		throws Exception
	{
		// ȡ�ø����û���HTTP Session
		Map session = ActionContext.getContext().getSession();
		Object userId = session.get("userId");
		// ����û�Session��userId����Ϊnull�����û���δ��¼
		if (userId == null)
		{
			return "login";
		}
		// ���򣬼���ִ��Ŀ��Action��execute����
		else
		{
			return invocation.invoke();
		}
	}
}
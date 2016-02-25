package org.crazyit.auction.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2011-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@WebFilter(urlPatterns="/android/*")
public class Authority implements Filter
{
	public void init(FilterConfig config)
		throws ServletException {}

    public void doFilter(ServletRequest request,
		ServletResponse response, FilterChain chain)
		throws IOException , ServletException
	{
		HttpServletRequest hrequest = (HttpServletRequest)request;
		// ��ȡHttpSession����
		HttpSession session = hrequest.getSession(true);
		Integer userId = (Integer)session.getAttribute("userId");
		// ����û��Ѿ���¼�����û����ڵ�¼
		if ((userId != null && userId > 0)
			|| hrequest.getRequestURI().endsWith("/login.jsp"))
		{
			// �����С�����
			chain.doFilter(request , response);
		}
		else
		{
			response.setContentType("text/html; charset=GBK");
			// ���ɴ�����ʾ��
			response.getWriter().println("����û�е�¼ϵͳ�����ȵ�¼ϵͳ��");
		}
	}

	public void destroy(){}
}
package org.crazyit.auction.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.crazyit.auction.servlet.base.BaseServlet;
import org.crazyit.auction.service.AuctionManager;
import java.io.*;
import org.json.*;

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
@WebServlet(urlPatterns="/android/login.jsp")
public class LoginServlet extends BaseServlet
{
    public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		// ��ȡϵͳ��ҵ���߼����
		AuctionManager auctionManager = (AuctionManager)getCtx().getBean("mgr");
		// ��֤�û���¼
		int userId = auctionManager.validLogin(user , pass);
		response.setContentType("text/html; charset=GBK");
		// ��¼�ɹ�
		if (userId > 0)
		{
			request.getSession(true).setAttribute("userId" , userId);
		}
		try
		{
			// ����֤��userId��װ��JSONObject
			JSONObject jsonObj = new JSONObject()
				.put("userId" , userId);
			// �����Ӧ
			response.getWriter().println(jsonObj.toString());
		}
		catch (JSONException ex)
		{
			ex.printStackTrace();
		}
	}
}
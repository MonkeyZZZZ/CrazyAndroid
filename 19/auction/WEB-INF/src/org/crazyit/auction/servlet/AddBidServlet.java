package org.crazyit.auction.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.crazyit.auction.servlet.base.BaseServlet;
import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.domain.Bid;
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
@WebServlet(urlPatterns="/android/addBid.jsp")
public class AddBidServlet extends BaseServlet
{
    public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		// ��ȡuserId
		Integer userId = (Integer)request.getSession(true)
			.getAttribute("userId");
		request.setCharacterEncoding("gbk");
		// ��ȡ�������
		String itemId = request.getParameter("itemId");
		String bidPrice = request.getParameter("bidPrice");
		// ��ȡҵ���߼����
		AuctionManager auctionManager = (AuctionManager)getCtx().getBean("mgr");
		// ����ҵ�񷽷�����Ӿ���
		int bidId = auctionManager.addBid(Integer.parseInt(itemId)
			, new Bid(Double.parseDouble(bidPrice))
			, userId);
		response.setContentType("text/html; charset=GBK");
		// ���۳ɹ�
		if (bidId > 0)
		{
			response.getWriter().println("��ϲ�������۳ɹ�!");
		}
		else
		{
			response.getWriter().println("�Բ��𣬾���ʧ��!");
		}
	}
}
package org.crazyit.auction.action;

import java.util.*;
import com.opensymphony.xwork2.ActionContext;

import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.domain.*;
import org.crazyit.auction.exception.AuctionException;
import org.crazyit.auction.action.base.BaseAction;

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
public class AddKindAction extends BaseAction
{
	private Kind kind;
	private String vercode;

	public String execute()throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		session.put("rand" , null);
		if (vercode.equals(ver2))
		{
			mgr.addKind(kind);
			return SUCCESS;
		}
		else
		{
			addActionError("��֤�벻ƥ��,����������");
			return INPUT;
		}
	}

	// kind��setter��getter����
	public void setKind(Kind kind)
	{
		this.kind = kind;
	}
	public Kind getKind()
	{
		return this.kind;
	}

	// vercode��setter��getter����
	public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		return this.vercode;
	}
}
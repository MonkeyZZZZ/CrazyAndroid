package org.crazyit.auction.action;

import com.opensymphony.xwork2.ActionContext;

import java.util.*;
import org.crazyit.auction.service.AuctionManager;
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
public class LoginAction extends BaseAction
{
	private String username;
	private String password;
	private String vercode;

	@Override
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String )session.get("rand");
		// ���Session�е������֤���ַ�����
		session.put("rand" , null);
		if (vercode.equals(ver2))
		{
			Integer userId = mgr.validLogin(username,password);
			if (userId != null && userId > 0)
			{
				session.put("userId" , userId);
				return SUCCESS;
			}
			else
			{
				addActionError("�û���/���벻ƥ��");
				return "failure";
			}
		}
		else
		{
			addActionError("��֤�벻ƥ��,����������");
			return "failure";
		}
	}
	// username��setter��getter����
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}

	// password��setter��getter����
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
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
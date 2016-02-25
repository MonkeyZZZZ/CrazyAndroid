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
public class AddItemAction extends BaseAction
{
	private Item item;
	private int avail;
	private int kindId;
	private String vercode;
	// �����û������execute����
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		// ǿ��ϵͳ�����ɵ������֤��ʧЧ
		session.put("rand" , null);
		Integer userId = (Integer)session.get("userId");
		// ����û��������֤����ϵͳ�����������֤����ͬ
		if (vercode.equals(ver2))
		{
			// �����û�ѡ����Чʱ��ѡ�ָ��ʵ�ʵ���Чʱ��
			switch(avail)
			{
				case 6 :
					avail = 7;
					break;
				case 7 :
					avail = 30;
					break;
				case 8 :
					avail = 365;
					break;
			}
			// �����Ʒ
			mgr.addItem(item ,avail , kindId, userId);
			return SUCCESS;
		}
		else
		{
			addActionError("��֤�벻ƥ��,����������");
			return INPUT;
		}
	}

	// item��setter��getter����
	public void setItem(Item item)
	{
		this.item = item;
	}
	public Item getItem()
	{
		return this.item;
	}

	// avail��setter��getter����
	public void setAvail(int avail)
	{
		this.avail = avail;
	}
	public int getAvail()
	{
		return this.avail;
	}

	// kindId��setter��getter����
	public void setKindId(int kindId)
	{
		this.kindId = kindId;
	}
	public int getKindId()
	{
		return this.kindId;
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
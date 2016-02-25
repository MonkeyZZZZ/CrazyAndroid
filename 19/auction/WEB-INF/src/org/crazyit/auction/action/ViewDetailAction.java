package org.crazyit.auction.action;

import java.util.*;
import com.opensymphony.xwork2.*;

import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.exception.AuctionException;
import org.crazyit.auction.action.base.BaseActionInterface;
import org.crazyit.auction.domain.*;
import org.crazyit.auction.business.*;

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
public class ViewDetailAction extends BaseActionInterface
{
	// ��װ�û��������������
	private int itemId;
	private ItemBean item;
	// ��װϵͳ������ʾ������
	private String errMsg;
	// �����û�����
	public String execute()throws Exception
	{
		if (itemId <= 0)
		{
			setErrMsg("��ѡ����ƷID����һ����Ч����ƷID��");
			return ERROR;
		}
		else
		{
			setItem(mgr.getItem(itemId));
			return SUCCESS;
		}
	}

	// itemId��setter��getter����
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public int getItemId()
	{
		 return this.itemId;
	}

	// item��setter��getter����
	public void setItem(ItemBean item)
	{
		this.item = item;
	}
	public ItemBean getItem()
	{
		 return this.item;
	}

	// errMsg��setter��getter����
	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}
	public String getErrMsg()
	{
		 return this.errMsg;
	}
}
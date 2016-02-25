package org.crazyit.auction.dao.impl;

import java.util.*;

import org.crazyit.common.dao.impl.*;

import org.crazyit.auction.domain.*;
import org.crazyit.auction.business.*;
import org.crazyit.auction.dao.*;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class AuctionUserDaoHibernate
	extends BaseDaoHibernate4<AuctionUser> implements AuctionUserDao
{

	/**
	 * �����û�������������û�
	 * @param username ��ѯ������û���
	 * @param pass ��ѯ���������
	 * @return ָ���û����������Ӧ���û�
	 */
	public AuctionUser findUserByNameAndPass(String username , String pass)
	{
		// ִ��HQL��ѯ
		List<AuctionUser> ul = (List<AuctionUser>)find(
			"from AuctionUser au where au.username=?0 and au.userpass=?1" ,
			username , pass);
		// ���ز�ѯ�õ��ĵ�һ��AuctionUser����
		if (ul.size() == 1)
		{
			return (AuctionUser)ul.get(0);
		}
		return null;
	}
}
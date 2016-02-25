package org.crazyit.auction.service;

import java.util.List;

import org.crazyit.auction.business.*;
import org.crazyit.auction.dao.*;
import org.crazyit.auction.domain.*;
import org.crazyit.auction.exception.AuctionException;

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
public interface AuctionManager
{
	/**
	 * ����Ӯȡ�߲�ѯ��Ʒ
	 * @param winerId Ӯȡ�ߵ�ID
	 * @return Ӯȡ�߻�õ�ȫ����Ʒ
	 */
	List<ItemBean> getItemByWiner(Integer winerId)
		throws AuctionException;

	/**
	 * ��ѯ���ĵ�ȫ����Ʒ
	 * @return ȫ��������Ʒ
	 */
	List<ItemBean> getFailItems()throws AuctionException;

	/**
	 * �����û�����������֤��¼�Ƿ�ɹ�
	 * @param username ��¼���û���
 	 * @param pass ��¼������
	 * @return ��¼�ɹ������û�ID�����򷵻�-1
	 */
	int validLogin(String username , String pass)
		throws AuctionException;

	/**
	 * ��ѯ�û���ȫ������
	 * @param userId �����û���ID
	 * @return �û���ȫ������
	 */
	List<BidBean> getBidByUser(Integer userId)
		throws AuctionException;

	/**
	 * �����û�����Ŀǰ���������е�ȫ����Ʒ
	 * @param userId �����ߵ�ID
	 * @return ���ڵ�ǰ�û��ġ����������е�ȫ����Ʒ��
	 */
	List<ItemBean> getItemsByOwner(Integer userId)
		throws AuctionException;

	/**
	 * ��ѯȫ������
	 * @return ϵͳ��ȫ��ȫ������
	 */
	List<KindBean> getAllKind() throws AuctionException;

	/**
	 * �����Ʒ
	 * @param item ��������Ʒ
	 * @param avail ��Ч����
	 * @param kindId ��Ʒ����ID
	 * @param userId ����ߵ�ID
	 * @return ������Ʒ������
	 */
	int addItem(Item item, int avail , int kindId , Integer userId)
		throws AuctionException;

	/**
	 * �������
	 * @param kind ����������
	 * @return �������������
	 */
	int addKind(Kind kind) throws AuctionException;

	/**
	 * ���ݲ�Ʒ���࣬��ȡ���������е�ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	List<ItemBean> getItemsByKind(int kindId) throws AuctionException;

	/**
	 * ��������id��ȡ������
	 * @param kindId ����id;
	 * @return �����������
	 */
	String getKind(int kindId) throws AuctionException;

	/**
	 * ������Ʒid����ȡ��Ʒ
	 * @param itemId ��Ʒid;
	 * @return ָ��id��Ӧ����Ʒ
	 */
	ItemBean getItem(int itemId) throws AuctionException;

	/**
	 * �����µľ��ۣ����Ծ����û����ʼ�֪ͨ
	 * @param itemId ��Ʒid;
	 * @param bid ����
	 * @param userId �����û���ID
	 * @return �����������ۼ�¼��ID
	 */
	int addBid(int itemId , Bid bid ,Integer userId)
		throws AuctionException;

	/**
	 * ����ʱ�����޸���Ʒ��Ӯȡ��
	 */
	void updateWiner()throws AuctionException;
}
package org.crazyit.auction.service.impl;

import org.apache.log4j.Logger;

import java.util.*;

import org.crazyit.auction.business.*;
import org.crazyit.auction.dao.*;
import org.crazyit.auction.domain.*;
import org.crazyit.auction.exception.AuctionException;
import org.crazyit.auction.service.AuctionManager;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

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
public class AuctionManagerImpl implements AuctionManager
{
	static Logger log = Logger.getLogger(
		AuctionManagerImpl.class.getName());
	// �����Ǹ�ҵ���߼������������DAO���
	private AuctionUserDao userDao;
	private BidDao bidDao;
	private ItemDao itemDao;
	private KindDao kindDao;
	private StateDao stateDao;
	// ҵ���߼���������ʼ�������������Bean
	private MailSender mailSender;
	private SimpleMailMessage message;
	// Ϊҵ���߼��������ע��DAO��������setter����
	public void setUserDao(AuctionUserDao userDao)
	{
		this.userDao = userDao;
	}
	public void setBidDao(BidDao bidDao)
	{
		this.bidDao = bidDao;
	}
	public void setItemDao(ItemDao itemDao)
	{
		this.itemDao = itemDao;
	}
	public void setKindDao(KindDao kindDao)
	{
		this.kindDao = kindDao;
	}
	public void setStateDao(StateDao stateDao)
	{
		this.stateDao = stateDao;
	}
	// Ϊҵ���߼����ע�������ʼ�����Bean��setter����
	public void setMailSender(MailSender mailSender)
	{
		this.mailSender = mailSender;
	}
	public void setMessage(SimpleMailMessage message)
	{
		this.message = message;
	}

	/**
	 * ����Ӯȡ�߲�ѯ��Ʒ
	 * @param winerId Ӯȡ�ߵ�ID
	 * @return Ӯȡ�߻�õ�ȫ����Ʒ
	 */
	public List<ItemBean> getItemByWiner(Integer winerId) throws AuctionException
	{
		try
		{
			List<Item> items = itemDao.findItemByWiner(winerId);
			List<ItemBean> result = new ArrayList<>();
			for (Iterator<Item> it = items.iterator() ; it.hasNext() ; )
			{
				ItemBean ib = new ItemBean();
				initItem(ib , it.next());
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯ�û���Ӯȡ����Ʒ�����쳣,������");
		}
	}

	/**
	 * ��ѯ���ĵ�ȫ����Ʒ
	 * @return ȫ��������Ʒ
	 */
	public List<ItemBean> getFailItems() throws AuctionException
	{
		try
		{
			List<Item> items = itemDao.findItemByState(3);
			List<ItemBean> result = new ArrayList<>();
			for (Iterator<Item> it = items.iterator() ; it.hasNext() ; )
			{
				ItemBean ib = new ItemBean();
				initItem(ib , it.next());
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯ������Ʒ�����쳣,������");
		}
	}

	/**
	 * �����û�����������֤��¼�Ƿ�ɹ�
	 * @param username ��¼���û���
 	 * @param pass ��¼������
	 * @return ��¼�ɹ������û�ID�����򷵻�-1
	 */
	public int validLogin(String username , String pass) throws AuctionException
	{
		try
		{
			AuctionUser u = userDao.findUserByNameAndPass(username , pass);
			if (u != null)
			{
				return u.getId();
			}
			return -1;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�����û���¼�����쳣,������");
		}
	}

	/**
	 * ��ѯ�û���ȫ������
	 * @param userId �����û���ID
	 * @return �û���ȫ������
	 */
	public List<BidBean> getBidByUser(Integer userId) throws AuctionException
	{
		try
		{
			List<Bid> l = bidDao.findByUser(userId);
			List<BidBean> result = new ArrayList<>();
			for ( int i = 0 ; i < l.size() ; i++ )
			{
				Bid bid = l.get(i);
				BidBean bb = new BidBean();
				initBid(bb, bid);
				result.add(bb);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("����û���ȫ�����۳����쳣,������");
		}
	}

	/**
	 * �����û�����Ŀǰ���������е�ȫ����Ʒ
	 * @param userId �����ߵ�ID
	 * @return ���ڵ�ǰ�û��ġ����������е�ȫ����Ʒ��
	 */
	public List<ItemBean> getItemsByOwner(Integer userId) throws AuctionException
	{
		try
		{
			List<ItemBean> result = new ArrayList<>();
			List<Item> items = itemDao.findItemByOwner(userId);
			for (Iterator<Item> it = items.iterator() ; it.hasNext() ; )
			{
				ItemBean ib = new ItemBean();
				initItem( ib ,it.next());
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯ�û����е���Ʒ�����쳣,������");
		}
	}

	/**
	 * ��ѯȫ������
	 * @return ϵͳ��ȫ��ȫ������
	 */
	public List<KindBean> getAllKind() throws AuctionException
	{
		List<KindBean> result = new ArrayList<>();
		try
		{
			List<Kind> kl = kindDao.findAll(Kind.class);
			for (Kind k : kl )
			{
				result.add(new KindBean(k.getId(),
					k.getKindName(), k.getKindDesc()));
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯȫ����������쳣,������");
		}
	}

	/**
	 * �����Ʒ
	 * @param item ��������Ʒ
	 * @param avail ��Ч����
	 * @param kindId ��Ʒ����ID
	 * @param userId ����ߵ�ID
	 * @return ������Ʒ������
	 */
	public int addItem(Item item , int avail , int kind , Integer userId)
		throws AuctionException
	{
		try
		{
			Kind k = kindDao.get(Kind.class , kind);
			AuctionUser owner = userDao.get(AuctionUser.class , userId);
			// ����Item������
			item.setAddtime(new Date());
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE , avail);
			item.setEndtime(c.getTime());
			item.setMaxPrice(item.getInitPrice());
			item.setItemState(stateDao.get(State.class , 1));
			item.setKind(k);
			item.setOwner(owner);
			// �־û�Item����
			itemDao.save(item);
			return item.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�����Ʒ�����쳣,������");
		}
	}

	/**
	 * �������
	 * @param kind ����������
	 * @return �������������
	 */
	public int addKind(Kind kind)
		throws AuctionException
	{
		try
		{
			kindDao.save(kind);
			return kind.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�����������쳣,������");
		}
	}

	/**
	 * ���ݲ�Ʒ���࣬��ȡ���������е�ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	public List<ItemBean> getItemsByKind(int kindId) throws AuctionException
	{
		List<ItemBean> result = new ArrayList<>();
		try
		{
			List<Item> items = itemDao.findItemByKind(kindId);
			for (Iterator<Item> it = items.iterator() ; it.hasNext() ; )
			{
				ItemBean ib = new ItemBean();
				initItem(ib , it.next());
				result.add(ib);
			}
			return result;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("���������ȡ��Ʒ�����쳣,������");
		}
	}

	/**
	 * ��������id��ȡ������
	 * @param kindId ����id;
	 * @return �����������
	 */
	public String getKind(int kindId) throws AuctionException
	{
		try
		{
			Kind  k = kindDao.get(Kind.class , kindId);
			if (k != null)
			{
				return k.getKindName();
			}
			return null;
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("��������id��ȡ�������Ƴ����쳣,������");
		}
	}

	/**
	 * ������Ʒid����ȡ��Ʒ
	 * @param itemId ��Ʒid;
	 * @return ָ��id��Ӧ����Ʒ
	 */
	public ItemBean getItem(int itemId)
		throws AuctionException
	{
		try
		{
			Item item = itemDao.get(Item.class , itemId);
			ItemBean ib = new ItemBean();
			initItem(ib , item);
			return ib;
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("������Ʒid��ȡ��Ʒ��ϸ��Ϣ�����쳣,������");
		}
	}

	/**
	 * �����µľ��ۣ����Ծ����û����ʼ�֪ͨ
	 * @param itemId ��Ʒid;
	 * @param bid ����
	 * @param userId �����û���ID
	 * @return �����������ۼ�¼��ID
	 */
	public int addBid(int itemId , Bid bid , Integer userId)
		throws AuctionException
	{
		try
		{
			AuctionUser au = userDao.get(AuctionUser.class , userId);
			Item item = itemDao.get(Item.class , itemId);
			if (bid.getBidPrice() > item.getMaxPrice())
			{
				item.setMaxPrice(bid.getBidPrice());
				itemDao.save(item);
			}
			// ����Bid���������
			bid.setBidItem(item);
			bid.setBidUser(au);
			bid.setBidDate(new Date());
			// �־û�Bid����
			bidDao.save(bid);
			// ׼�������ʼ�
			SimpleMailMessage msg = new SimpleMailMessage(this.message);
			msg.setTo(au.getEmail());
			msg.setText("Dear "
				+ au.getUsername()
				+ ", лл����뾺�ۣ���ľ��۵���Ʒ����: "
				+ item.getItemName());
			mailSender.send(msg);
			return bid.getId();
		}
		catch(Exception ex)
		{
			log.debug(ex.getMessage());
			ex.printStackTrace();
			throw new AuctionException("�����û����۳����쳣,������");
		}
	}

	/**
	 * ����ʱ�����޸���Ʒ��״̬��Ӯȡ��
	 */
	public void updateWiner()throws AuctionException
	{
		try
		{
			List itemList = itemDao.findItemByState(1);
			for (int i = 0 ; i < itemList.size() ; i++ )
			{
				Item item = (Item)itemList.get(i);
				if (!item.getEndtime().after(new Date()))
				{
					// ����ָ����Ʒ����߾�������ѯ�û�
					AuctionUser au = bidDao.findUserByItemAndPrice(
						item.getId() , item.getMaxPrice());
					// �������Ʒ����߾����߲�Ϊnull
					if (au != null)
					{
						// ���þ�������ΪӮȡ��
						item.setWiner(au);
						// �޸���Ʒ��״̬��Ϊ����Ӯȡ��
						item.setItemState(stateDao.get(State.class , 2));
						itemDao.save(item);
					}
					else
					{
						// ���ø���Ʒ��״̬Ϊ�����ġ�
						item.setItemState(stateDao.get(State.class , 3));
						itemDao.save(item);
					}
				}
			}
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("����ʱ�����޸���Ʒ��״̬��Ӯȡ�߳����쳣,������");
		}
	}

	/**
	 * ��һ��Bid����ת����BidBean����
	 * @param bb BidBean����
	 * @param bid Bid����
	 */
	private void initBid(BidBean bb , Bid bid)
	{
		bb.setId(bid.getId().intValue());
		if (bid.getBidUser() != null )
			bb.setUser(bid.getBidUser().getUsername());
		if (bid.getBidItem() != null )
			bb.setItem(bid.getBidItem().getItemName());
		bb.setPrice(bid.getBidPrice());
		bb.setBidDate(bid.getBidDate());
	}

	/**
	 * ��һ��Item POת����ItemBean��VO
	 * @param ib ItemBean��VO
	 * @param item Item��PO
	 */
	private void initItem(ItemBean ib , Item item)
	{
		ib.setId(item.getId());
		ib.setName(item.getItemName());
		ib.setDesc(item.getItemDesc());
		ib.setRemark(item.getItemRemark());
		if (item.getKind() != null)
			ib.setKind(item.getKind().getKindName());
		if (item.getOwner() != null)
			ib.setOwner(item.getOwner().getUsername());
		if (item.getWiner() != null)
			ib.setWiner(item.getWiner().getUsername());
		ib.setAddTime(item.getAddtime());
		ib.setEndTime(item.getEndtime());
		if (item.getItemState() != null)
			ib.setState(item.getItemState().getStateName());
		ib.setInitPrice(item.getInitPrice());
		ib.setMaxPrice(item.getMaxPrice());
	}
}
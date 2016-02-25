package org.crazyit.auction.domain;

import java.util.*;

import javax.persistence.*;

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
@Entity
@Table(name="auction_user")
public class AuctionUser
{
	// ��ʶ����
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// �û�������
	private String username;
	// ��������
	private String userpass;
	// �����ʼ�����
	private String email;

	// ����������������Ʒʵ��
	@OneToMany(targetEntity=Item.class ,
		mappedBy="owner")
	private Set<Item> itemsByOwner = new HashSet<Item>();
	// ����Ӯȡ�߹�������Ʒʵ��
	@OneToMany(targetEntity=Item.class ,
		mappedBy="winer")
	private Set<Item> itemsByWiner = new HashSet<Item>();
	// ���û��������ȫ������
	@OneToMany(targetEntity=Bid.class ,
		mappedBy="bidUser")
	private Set<Bid> bids = new HashSet<Bid>();

	// �޲����Ĺ�����
	public AuctionUser()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public AuctionUser(Integer id , String username
		, String userpass , String email)
	{
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.email = email;
	}

	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
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

	// userpass��setter��getter����
	public void setUserpass(String userpass)
	{
		this.userpass = userpass;
	}
	public String getUserpass()
	{
		return this.userpass;
	}

	// email��setter��getter����
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}

	// itemsByOwner��setter��getter����
	public void setItemsByOwner(Set<Item> itemsByOwner)
	{
		this.itemsByOwner = itemsByOwner;
	}
	public Set<Item> getItemsByOwner()
	{
		return this.itemsByOwner;
	}

	// itemsByWiner��setter��getter����
	public void setItemsByWiner(Set<Item> itemsByWiner)
	{
		this.itemsByWiner = itemsByWiner;
	}
	public Set<Item> getItemsByWiner()
	{
		return this.itemsByWiner;
	}

	// bids��setter��getter����
	public void setBids(Set<Bid> bids)
	{
		this.bids = bids;
	}
	public Set<Bid> getBids()
	{
		return this.bids;
	}
}
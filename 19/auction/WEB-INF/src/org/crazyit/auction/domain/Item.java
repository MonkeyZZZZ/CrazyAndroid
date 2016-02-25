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
@Table(name="item")
public class Item
{
	// ��ʶ����
	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// ��ƷRemark
	@Column(name="item_remark")
	private String itemRemark;
	// ��Ʒ����
	@Column(name="item_name")
	private String itemName;
	// ��Ʒ����
	@Column(name="item_desc")
	private String itemDesc;
	// ��Ʒ���ʱ��
	private Date addtime;
	// ��Ʒ��������ʱ��
	private Date endtime;
	// ��Ʒ�����ļ�
	@Column(name="init_price")
	private double initPrice;
	// ��Ʒ����߼�
	@Column(name="max_price")
	private double maxPrice;
	// ����Ʒ��������
	@ManyToOne(targetEntity=AuctionUser.class)
	@JoinColumn(name="owner_id", nullable=false)
	private AuctionUser owner;
	// ����Ʒ����������
	@ManyToOne(targetEntity=Kind.class)
	@JoinColumn(name="kind_id", nullable=false)
	private Kind kind;
	// ����Ʒ��Ӯȡ��
	@ManyToOne(targetEntity=AuctionUser.class)
	@JoinColumn(name="winer_id", nullable=true)
	private AuctionUser winer;
	// ����Ʒ������״̬
	@ManyToOne(targetEntity=State.class)
	@JoinColumn(name="state_id", nullable=false)
	private State itemState;
	// ����Ʒ��Ӧ��ȫ�����ۼ�¼
	@OneToMany(targetEntity=Bid.class ,
		mappedBy="bidItem")
	private Set<Bid> bids = new HashSet<Bid>();

	// �޲����Ĺ�����
	public Item()
	{
	}
	// ��ʼ��ȫ���������ԵĹ�����
	public Item( String itemName , String itemDesc
		, String itemRemark , double initPrice)
	{
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemRemark = itemRemark;
		this.initPrice = initPrice;
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

	// itemRemark��setter��getter����
	public void setItemRemark(String itemRemark)
	{
		this.itemRemark = itemRemark;
	}
	public String getItemRemark()
	{
		return this.itemRemark;
	}

	// itemName��setter��getter����
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	public String getItemName()
	{
		return this.itemName;
	}

	// itemDesc��setter��getter����
	public void setItemDesc(String itemDesc)
	{
		this.itemDesc = itemDesc;
	}
	public String getItemDesc()
	{
		return this.itemDesc;
	}

	// addtime��setter��getter����
	public void setAddtime(Date addtime)
	{
		this.addtime = addtime;
	}
	public Date getAddtime()
	{
		return this.addtime;
	}

	// endtime��setter��getter����
	public void setEndtime(Date endtime)
	{
		this.endtime = endtime;
	}
	public Date getEndtime()
	{
		return this.endtime;
	}

	// initPrice��setter��getter����
	public void setInitPrice(double initPrice)
	{
		this.initPrice = initPrice;
	}
	public double getInitPrice()
	{
		return this.initPrice;
	}

	// maxPrice��setter��getter����
	public void setMaxPrice(double maxPrice)
	{
		this.maxPrice = maxPrice;
	}
	public double getMaxPrice()
	{
		return this.maxPrice;
	}

	// owner��setter��getter����
	public void setOwner(AuctionUser owner)
	{
		this.owner = owner;
	}
	public AuctionUser getOwner()
	{
		return this.owner;
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

	// winer��setter��getter����
	public void setWiner(AuctionUser winer)
	{
		this.winer = winer;
	}
	public AuctionUser getWiner()
	{
		return this.winer;
	}

	// itemState��setter��getter����
	public void setItemState(State itemState)
	{
		this.itemState = itemState;
	}
	public State getItemState()
	{
		return this.itemState;
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
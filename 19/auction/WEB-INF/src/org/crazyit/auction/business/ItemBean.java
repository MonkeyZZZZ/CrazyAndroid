package org.crazyit.auction.business;

import java.io.Serializable;
import java.util.Date;

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
public class ItemBean
{
	private Integer id;
	private String name;
	private String desc;
	private String remark;
	private String kind;
	private String owner;
	private String winer;
	private String state;
	private double initPrice;
	private double maxPrice;
	private Date addTime;
	private Date endTime;

	// �޲����Ĺ�����
	public ItemBean()
	{
	}
	// ��ʼ��ȫ�����ԵĹ�����
	public ItemBean(Integer id , String name , String desc , String remark,
		String kind , String owner , String winer , String state ,
		double initPrice , double maxPrice , Date addTime , Date endTime)
	{
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.remark = remark;
		this.kind = kind;
		this.owner = owner;
		this.winer = winer;
		this.state = state;
		this.initPrice = initPrice;
		this.maxPrice = maxPrice;
		this.addTime = addTime;
		this.endTime = endTime;
	}

	// id���Ե�setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// name���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// desc���Ե�setter��getter����
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		return this.desc;
	}

	// remark���Ե�setter��getter����
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}

	// kind���Ե�setter��getter����
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	public String getKind()
	{
		return this.kind;
	}

	// owner���Ե�setter��getter����
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	public String getOwner()
	{
		return this.owner;
	}

	// winer���Ե�setter��getter����
	public void setWiner(String winer)
	{
		this.winer = winer;
	}
	public String getWiner()
	{
		return this.winer;
	}

	// state���Ե�setter��getter����
	public void setState(String state)
	{
		this.state = state;
	}
	public String getState()
	{
		return this.state;
	}

	// initPrice���Ե�setter��getter����
	public void setInitPrice(double initPrice)
	{
		this.initPrice = initPrice;
	}
	public double getInitPrice()
	{
		return this.initPrice;
	}

	// maxPrice���Ե�setter��getter����
	public void setMaxPrice(double maxPrice)
	{
		this.maxPrice = maxPrice;
	}
	public double getMaxPrice()
	{
		return this.maxPrice;
	}

	// addTime���Ե�setter��getter����
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}
	public Date getAddTime()
	{
		return this.addTime;
	}

	// endTime���Ե�setter��getter����
	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}
	public Date getEndTime()
	{
		return this.endTime;
	}

}
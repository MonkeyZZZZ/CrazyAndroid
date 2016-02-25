package org.crazyit.app.domain;

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
public class User
{
	private Integer id;
	private String name;
	private String gender;
	private double height;

	//�޲����Ĺ�����
	public User()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public User(Integer id , String name , String gender , double height)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.height = height;
	}

	//id���Ե�setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	//name���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	//gender���Ե�setter��getter����
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getGender()
	{
		return this.gender;
	}

	//height���Ե�setter��getter����
	public void setHeight(double height)
	{
		this.height = height;
	}
	public double getHeight()
	{
		return this.height;
	}
	//��дtoString() ����
	public String toString()
	{
		return "Person[name=" + name + ",gender=" + gender
			+ ",height=" + height + "]";
	}

}
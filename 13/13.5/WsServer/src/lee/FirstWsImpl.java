package org.crazyit.app.ws.impl;

import org.crazyit.app.domain.User;
import org.crazyit.app.ws.FirstWs;

import java.util.*;
import javax.jws.WebService;

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
// ����Web Services�ӿڵ�ʵ���࣬Web Services������
@WebService(endpointInterface = "org.crazyit.app.ws.FirstWs",
            serviceName = "firstWs")
public class FirstWsImpl implements FirstWs
{
	@Override
	public List<User> getUserList(String base)
	{
		System.out.println("---����getUserList����---" + base);
		List<User> result = new ArrayList<User>();
		result.add(new User(1 , base + "crazyit" , "123" , 173));
		result.add(new User(2 , base + "leegang" , "456" , 178));
		return result;
	}
}
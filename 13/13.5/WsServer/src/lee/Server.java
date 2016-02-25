package lee;

import org.crazyit.app.ws.FirstWs;
import org.crazyit.app.ws.impl.FirstWsImpl;
import javax.xml.ws.Endpoint;
import org.apache.cxf.interceptor.*;
import org.apache.cxf.jaxws.EndpointImpl;
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
public class Server
{
	public static void main(String[] args)
	{
		System.out.println("����������");
		// ����Web Services�����ṩ���ʵ��
		FirstWsImpl implementor = new FirstWsImpl();
		String address = "http://192.168.1.88:9999/crazyit";
		// ��ָ��Web Services�����ṩ��Ķ��󷢲���Web Services
		EndpointImpl ep = (EndpointImpl)Endpoint.publish(
			address , implementor);
		// �������CXF�Դ��������������ڸ���SOAP��Ϣ
		ep.getServer().getEndpoint()
			.getInInterceptors().add(new LoggingInInterceptor());
		ep.getServer().getEndpoint()
			.getOutInterceptors().add(new LoggingOutInterceptor());
	}
}


import java.net.*;
import java.io.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class SimpleServer
{
	public static void main(String[] args)
		throws IOException
	{
		// ����һ��ServerSocket�����ڼ����ͻ���Socket����������
		ServerSocket ss = new ServerSocket(30000);  // ��
		// ����ѭ�����Ͻ������Կͻ��˵�����
		while (true)
		{
			// ÿ�����ܵ��ͻ���Socket�����󣬷�������Ҳ��Ӧ����һ��Socket
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			os.write(" ���ã����յ��˷�����������ף����\n"
				.getBytes("utf-8"));
			// �ر���������ر�Socket
			os.close();
			s.close();
		}
	}
}

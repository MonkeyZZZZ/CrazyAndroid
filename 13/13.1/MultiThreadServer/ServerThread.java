import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
// ������ÿ���߳�ͨ�ŵ��߳���
public class ServerThread implements Runnable
{
	// ���嵱ǰ�߳��������Socket
	Socket s = null;
	// ���߳��������Socket����Ӧ��������
	BufferedReader br = null;
	public ServerThread(Socket s)
		throws IOException
	{
		this.s = s;
		// ��ʼ����Socket��Ӧ��������
		br = new BufferedReader(new InputStreamReader(
			s.getInputStream() , "utf-8"));   // ��
	}
	public void run()
	{
		try
		{
			String content = null;
			// ����ѭ�����ϴ�Socket�ж�ȡ�ͻ��˷��͹���������
			while ((content = readFromClient()) != null)
			{
				System.out.println("---" + Arrays.toString(content.getBytes("utf-8")));
				System.out.println("---" + content);
				// ����socketList�е�ÿ��Socket��
				// ��������������ÿ��Socket����һ��
				for (Iterator<Socket> it = MyServer.socketList.iterator(); it.hasNext(); )
				{
					Socket s = it.next();
					try{

						OutputStream os = s.getOutputStream();
						os.write((content + "\n").getBytes("utf-8"));
					}
					catch(SocketException e)
					{
						e.printStackTrace();
						// ɾ����Socket��
						it.remove();
						System.out.println(MyServer.socketList);
					}
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	// �����ȡ�ͻ������ݵķ���
	private String readFromClient()
	{
		try
		{
			return br.readLine();
		}
		// �����׽���쳣��������Socket��Ӧ�Ŀͻ����Ѿ��ر�
		catch (IOException e)
		{
			e.printStackTrace();
			// ɾ����Socket��
			MyServer.socketList.remove(s);  // ��
		}
		return null;
	}
}

package org.crazyit.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity
{
	Button send;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 获取程序界面中的按钮
		send = (Button) findViewById(R.id.send);
		send.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// 创建Intent对象
				Intent intent = new Intent();
				// 设置Intent的Action属性
				intent.setAction("org.crazyit.action.CRAZY_BROADCAST");
				intent.putExtra("msg", "简单的消息");
				// 发送广播
				sendBroadcast(intent);
			}
		});
	}
}



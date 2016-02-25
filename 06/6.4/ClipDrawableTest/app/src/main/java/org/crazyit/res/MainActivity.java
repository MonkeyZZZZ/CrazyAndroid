package org.crazyit.res;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ImageView imageview = (ImageView) findViewById(R.id.image);
		// 获取图片所显示的ClipDrawable对象
		final ClipDrawable drawable = (ClipDrawable)
				imageview.getDrawable();
		final Handler handler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				// 如果该消息是本程序所发送的
				if (msg.what == 0x1233)
				{
					// 修改ClipDrawable的level值
					drawable.setLevel(drawable.getLevel() + 200);
				}
			}
		};
		final Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				Message msg = new Message();
				msg.what = 0x1233;
				// 发送消息，通知应用修改ClipDrawable对象的level值。
				handler.sendMessage(msg);
				// 取消定时器
				if (drawable.getLevel() >= 10000)
				{
					timer.cancel();
				}
			}
		}, 0, 300);
	}
}

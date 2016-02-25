package org.crazyit.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		// 获取应用程序中的previous按钮
		Button previous = (Button) findViewById(R.id.previous);
		// 获取应用程序中的close按钮
		Button close = (Button) findViewById(R.id.close);
		// 为previous按钮绑定事件监听器
		previous.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// 获取启动当前Activity的上一个Intent
				Intent intent = new Intent(SecondActivity.this,
						MainActivity.class);
				// 启动intent对应的Activity
				startActivity(intent);
			}
		});
		// 为close按钮绑定事件监听器
		close.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View source)
			{
				// 获取启动当前Activity的上一个Intent
				Intent intent = new Intent(SecondActivity.this,
						MainActivity.class);
				// 启动intent对应的Activity
				startActivity(intent);
				// 结束当前Activity
				finish();
			}
		});
	}
}


package org.crazyit.event;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity
{
	EditText ori;
	EditText navigation;
	EditText touch;
	EditText mnc;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 获取应用界面中的界面组件
		ori = (EditText)findViewById(R.id.ori);
		navigation = (EditText)findViewById(R.id.navigation);
		touch = (EditText)findViewById(R.id.touch);
		mnc = (EditText)findViewById(R.id.mnc);
		Button bn = (Button)findViewById(R.id.bn);
		bn.setOnClickListener(new OnClickListener()
		{
			// 为按钮绑定事件监听器
			@Override
			public void onClick(View source)
			{
				// 获取系统的Configuration对象
				Configuration cfg = getResources().getConfiguration();
				String screen = cfg.orientation ==
					Configuration.ORIENTATION_LANDSCAPE
					? "横向屏幕": "竖向屏幕";
				String mncCode = cfg.mnc + "";
				String naviName = cfg.orientation ==
					Configuration.NAVIGATION_NONAV
					? "没有方向控制" :
					cfg.orientation == Configuration.NAVIGATION_WHEEL
						? "滚轮控制方向" :
						cfg.orientation == Configuration.NAVIGATION_DPAD
						? "方向键控制方向" : "轨迹球控制方向";
				navigation.setText(naviName);
				String touchName = cfg.touchscreen ==
					Configuration.TOUCHSCREEN_NOTOUCH
					? "无触摸屏" : "支持触摸屏";
				ori.setText(screen);
				mnc.setText(mncCode);
				touch.setText(touchName);
			}
		});
	}
}


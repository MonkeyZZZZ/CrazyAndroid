
package org.crazyit.ui;

import org.crazyit.ui.R;

import android.app.Activity;
import android.os.Bundle;

public class OtherActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// 设置该Activity显示的页面
		setContentView(R.layout.other);
	}
}


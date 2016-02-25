package org.crazyit.res;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity
{
	// 获取系统定义的数组资源
	String[] texts;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		texts = getResources().getStringArray(R.array.string_arr);
		// 创建一个BaseAdapter对象
		BaseAdapter ba = new BaseAdapter()
		{
			@Override
			public int getCount()
			{
				// 指定一共包含9个选项
				return texts.length;
			}
			@Override
			public Object getItem(int position)
			{
				// 返回指定位置的文本
				return texts[position];
			}
			@Override
			public long getItemId(int position)
			{
				return position;
			}
			// 重写该方法，该方法返回的View将作为的GridView的每个格子
			@Override
			public View getView(int position
				, View convertView, ViewGroup parent)
			{
				TextView text = new TextView(MainActivity.this);
				Resources res = MainActivity.this.getResources();
				// 使用尺度资源来设置文本框的高度、宽度
				text.setWidth((int) res.getDimension(R.dimen.cell_width));
				text.setHeight((int) res.getDimension(R.dimen.cell_height));
				// 使用字符串资源设置文本框的内容
				text.setText(texts[position]);
				TypedArray icons = res.obtainTypedArray(R.array.plain_arr);
				// 使用颜色资源来设置文本框的背景色
				text.setBackground(icons.getDrawable(position));
				text.setTextSize(20);
				return text;
			}
		};
		GridView grid = (GridView) findViewById(R.id.grid01);
		// 为GridView设置Adapter
		grid.setAdapter(ba);
	}
}

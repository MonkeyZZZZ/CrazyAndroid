package org.crazyit.net;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class MyObject
{
	Context mContext;
	MyObject(){}
	MyObject(Context c)
	{
		mContext = c;
	}
	// 该方法将会暴露给JavaScript脚本调用
	@JavascriptInterface
	public void showToast(String name)
	{
		Toast.makeText(mContext, name + "，您好！"
				, Toast.LENGTH_LONG).show();
	}
	// 该方法将会暴露给JavaScript脚本调用
	@JavascriptInterface
	public void showList()
	{
		// 显示一个普通的列表对话框
		new AlertDialog.Builder(mContext)
				.setTitle("图书列表")
				.setIcon(R.drawable.ic_launcher)
				.setItems(new String[]{"疯狂Java讲义"
						, "疯狂Android讲义" , "轻量级Java EE企业应用实战"} , null)
				.setPositiveButton("确定", null)
				.create()
				.show();
	}
}


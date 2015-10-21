package com.example.cityguide;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.os.Build;

public class WebUrl extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_url);

		Bundle extras= getIntent().getExtras();
		String val1=extras.getString("abc");
		android.app.ActionBar ab = getActionBar();
		ab.setTitle(""+val1);
		WebView wb=(WebView)findViewById(R.id.webView1);
		wb.loadUrl("http://"+val1);
	}

}

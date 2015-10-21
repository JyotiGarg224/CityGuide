package com.example.cityguide;

import java.util.List;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Build;

public class SearchItem extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_item);
		android.app.ActionBar ab = getActionBar();
		ab.setTitle("Search Result");
		Intent i=getIntent();
		i.getBundleExtra("abc");
		
		ListView lv=(ListView)findViewById(R.id.listView1);
        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),(List<PlacesRegis>) i));
        
        
	}

}

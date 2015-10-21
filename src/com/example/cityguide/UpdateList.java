package com.example.cityguide;

import java.util.List;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Build;

public class UpdateList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_list);

		android.app.ActionBar ab = getActionBar();
		ab.setTitle("All Places");
		DatabaseHelper dbh=new DatabaseHelper(getApplicationContext()); 
		List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster");
		
		ListView lv=(ListView)findViewById(R.id.listView1);
        lv.setAdapter(new PropertyUpdateAdapter(getApplicationContext(),objects));
        
	}

}

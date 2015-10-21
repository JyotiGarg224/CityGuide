package com.example.cityguide;

import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;

public class CategoryList extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category_list);
		Bundle extras= getIntent().getExtras();
		String val1=extras.getString("abc");
		boolean issearch=extras.getBoolean("isSearch");
		String val2=Home.tv1.getText().toString();
		String val3=Home.tv2.getText().toString();
		String val4=Home.tv3.getText().toString();
		String val5=Home.tv4.getText().toString();
		String val6=Home.tv5.getText().toString();
		String val7=Home.tv6.getText().toString();
		String val8=Home.tv7.getText().toString();
		String val9=Home.tv8.getText().toString();
		String val10=Home.tv9.getText().toString();
		DatabaseHelper dbh=new DatabaseHelper(getApplicationContext());
		if(issearch==true)
		{	
			List <PlacesRegis>plist=dbh.getSearchResult(val1);
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),plist));
	        return;
		}
		if(val1.equals(val2))
		{
			android.app.ActionBar ab = getActionBar();
			ab.setTitle(""+val1);
			 
			List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster where col_pcategory='"+val2+"'");
			
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),objects));
	        
		}
		if(val1.equals(val3))
		{
			android.app.ActionBar ab = getActionBar();
			ab.setTitle(""+val1);
			 
			List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster where col_pcategory='"+val3+"'");
			
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),objects));
	        
		}
		if(val1.equals(val4))
		{
			android.app.ActionBar ab = getActionBar();
			ab.setTitle(""+val1);
			 
			List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster where col_pcategory='"+val4+"'");
			
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),objects));
	        
		}
		if(val1.equals(val5))
		{
			android.app.ActionBar ab = getActionBar();
			ab.setTitle(""+val1);
			 
			List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster where col_pcategory='"+val5+"'");
			
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),objects));
	        
		}
		if(val1.equals(val6))
		{
			android.app.ActionBar ab = getActionBar();
			ab.setTitle(""+val1);
			 
			List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster where col_pcategory='"+val6+"'");
			
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),objects));
	        
		}
		if(val1.equals(val7))
		{
			android.app.ActionBar ab = getActionBar();
			ab.setTitle(""+val1);
			 
			List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster where col_pcategory='"+val7+"'");
			
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),objects));
	        
		}
		if(val1.equals(val8))
		{
			android.app.ActionBar ab = getActionBar();
			ab.setTitle(""+val1);
			 
			List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster where col_pcategory='"+val8+"'");
			
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),objects));
	        
		}
		if(val1.equals(val9))
		{
			android.app.ActionBar ab = getActionBar();
			ab.setTitle(""+val1);
			 
			List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster where col_pcategory='"+val9+"'");
			
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),objects));
	        
		}
		if(val1.equals(val10))
		{
			android.app.ActionBar ab = getActionBar();
			ab.setTitle(""+val1);
			 
			List<PlacesRegis> objects=dbh.getAllProperties("select * from PropertyMaster where col_pcategory='"+val10+"'");
			
			ListView lv=(ListView)findViewById(R.id.listView1);
	        lv.setAdapter(new PropertyCustomerAdapter(getApplicationContext(),objects));
	        
		}
			
	}

}

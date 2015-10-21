package com.example.cityguide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.PopupMenu;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends ActionBarActivity {
	public static ImageButton ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12;
	public static TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
	DatabaseHelper dbh=null;
	SQLiteDatabase db=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		 ib2=(ImageButton)findViewById(R.id.imageButton2);
		 ib3=(ImageButton)findViewById(R.id.imageButton3);
		 ib4=(ImageButton)findViewById(R.id.imageButton4);
		 ib5=(ImageButton)findViewById(R.id.imageButton5);
		 ib6=(ImageButton)findViewById(R.id.imageButton6);
		 ib7=(ImageButton)findViewById(R.id.imageButton7);
		 ib8=(ImageButton)findViewById(R.id.imageButton8);
		 ib9=(ImageButton)findViewById(R.id.imageButton9);
		 ib10=(ImageButton)findViewById(R.id.imageButton10);
		 ib12=(ImageButton)findViewById(R.id.searchitem);
		 
		 tv1=(TextView)findViewById(R.id.textView1); 
		  tv2=(TextView)findViewById(R.id.textView2);
		  tv3=(TextView)findViewById(R.id.TextView03);
		 tv4=(TextView)findViewById(R.id.TextView02);
		  tv5=(TextView)findViewById(R.id.TextView01);
		 tv6=(TextView)findViewById(R.id.textView3);
		 tv7=(TextView)findViewById(R.id.textView4);
		  tv8=(TextView)findViewById(R.id.textView5);
		 tv9=(TextView)findViewById(R.id.textView6);
		ib11=(ImageButton)findViewById(R.id.admin);
		
		
		ib4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url1=tv1.getText().toString();
				Intent i = new Intent(Home.this,CategoryList.class);
				
				i.putExtra("abc", url1);
				 Home.this.startActivity(i);
				
		}
				});
		
		ib7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url1=tv2.getText().toString();
				Intent i = new Intent(Home.this,CategoryList.class);
				
				i.putExtra("abc", url1);
				 Home.this.startActivity(i);
				
		}
				});
		
		
		ib2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url1=tv3.getText().toString();
				Intent i = new Intent(Home.this,CategoryList.class);
				
				i.putExtra("abc", url1);
				 Home.this.startActivity(i);
				
		}
				});
		
		ib5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url1=tv4.getText().toString();
				Intent i = new Intent(Home.this,CategoryList.class);
				
				i.putExtra("abc", url1);
				 Home.this.startActivity(i);
				
		}
				});
		
		ib6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url1=tv5.getText().toString();
				Intent i = new Intent(Home.this,CategoryList.class);
				
				i.putExtra("abc", url1);
				 Home.this.startActivity(i);
				
		}
				});
		
		ib3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url1=tv6.getText().toString();
				Intent i = new Intent(Home.this,CategoryList.class);
				
				i.putExtra("abc", url1);
				 Home.this.startActivity(i);
				
		}
				});
		
		ib9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url1=tv7.getText().toString();
				Intent i = new Intent(Home.this,CategoryList.class);
				
				i.putExtra("abc", url1);
				 Home.this.startActivity(i);
				
		}
				});
		
		ib8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url1=tv8.getText().toString();
				Intent i = new Intent(Home.this,CategoryList.class);
				
				i.putExtra("abc", url1);
				 Home.this.startActivity(i);
				
		}
				});
		
		ib10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String url1=tv9.getText().toString();
				Intent i = new Intent(Home.this,CategoryList.class);
				
				i.putExtra("abc", url1);
				 Home.this.startActivity(i);
				
		}
				});
		
		
		
		ib11.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 PopupMenu popup=new PopupMenu(Home.this, ib11);
				 popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
				 
				 popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						Intent mainIntent = new Intent(Home.this,Login.class);
		                Home.this.startActivity(mainIntent);
						return true;
					}
				});
				 popup.show();
			}
		});
		final PlacesRegis pb=new PlacesRegis();
		
		
		
		ib12.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				EditText et1=(EditText)findViewById(R.id.editText1);
				final String search=et1.getText().toString();
				try{
					
						Intent i = new Intent(Home.this,CategoryList.class);
						i.putExtra("abc", search);
						i.putExtra("isSearch", true);
						Home.this.startActivity(i);	
					
					
				}
				catch(Exception ex)
				{
					Toast.makeText(getApplicationContext(), ""+ex, Toast.LENGTH_LONG).show();
				}
				
				
		}
				});

	}

}

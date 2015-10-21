package com.example.cityguide;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.PopupMenu;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class PropertyDetailActivity extends ActionBarActivity {
	String propertyname;
	PlacesRegis pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_detail);
		Intent i=getIntent();
		propertyname=i.getStringExtra("pname");
		android.app.ActionBar ab = getActionBar();
		ab.setTitle(""+propertyname);
		DatabaseHelper dbh=new DatabaseHelper(getApplicationContext());
		List<PlacesRegis>items=dbh.getAllProperties("select * from PropertyMaster where col_pname='"+propertyname+"'");
		if(items!=null)
			pb=items.get(0);
		Button b1=(Button)findViewById(R.id.button1);
		Button b2=(Button)findViewById(R.id.button2);
		Button b3=(Button)findViewById(R.id.button3);
		TextView tv1=(TextView)findViewById(R.id.pname);
		TextView tv2=(TextView)findViewById(R.id.paddress);
		final TextView tv3=(TextView)findViewById(R.id.pcontact);
		final TextView tv4=(TextView)findViewById(R.id.email);
		TextView tv5=(TextView)findViewById(R.id.desc);
		
		final TextView tv7=(TextView)findViewById(R.id.web);
		RatingBar rb=(RatingBar)findViewById(R.id.ratingBar1);
		ImageView iv=(ImageView)findViewById(R.id.imageView1);
		tv1.setText(propertyname);
		tv2.setText(pb.getpAddress());
		tv3.setText(pb.getpContact());
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view)
			{
				String url1=tv3.getText().toString();
				Intent mainIntent = new Intent(PropertyDetailActivity.this,SendingMssg.class);
				mainIntent.putExtra("abc", url1);
				startActivity(mainIntent);
				
			}
		});
		tv4.setText(pb.getpEmail());
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String url1=tv4.getText().toString();
				Intent mainIntent = new Intent(PropertyDetailActivity.this,SendingEmail.class);
				mainIntent.putExtra("abc", url1);
				startActivity(mainIntent);
				
			}
		});
		tv5.setText(pb.getpDesc());
		
		tv7.setText(pb.getpWebURL());
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String url1=tv7.getText().toString();
				Intent mainIntent = new Intent(PropertyDetailActivity.this,WebUrl.class);
				mainIntent.putExtra("abc", url1);
				startActivity(mainIntent);

				
			}
		});

		rb.setRating((float)pb.getRating());
		rb.setEnabled(false);
		byte imgarr[]=pb.getPimage();
 		Bitmap bitmap=BitmapFactory.decodeByteArray(imgarr,0,imgarr.length);
 		iv.setImageBitmap(bitmap);
	}
	
	}



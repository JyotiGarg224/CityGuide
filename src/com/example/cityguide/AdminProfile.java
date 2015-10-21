
package com.example.cityguide;



import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Build;

public class AdminProfile extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_profile);

		ImageButton ib1=(ImageButton)findViewById(R.id.home);
		ib1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
		 Intent mainIntent = new Intent(AdminProfile.this,Home.class);
            AdminProfile.this.startActivity(mainIntent);
	}
});
		ImageButton ib2=(ImageButton)findViewById(R.id.pass);
		ib2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		 Intent mainIntent = new Intent(AdminProfile.this,ChangePassword.class);
		 AdminProfile.this.startActivity(mainIntent);
		
	}
});
		ImageButton ib3=(ImageButton)findViewById(R.id.register);
		ib3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		 Intent mainIntent = new Intent(AdminProfile.this,PlaceRegistration.class);
		 AdminProfile.this.startActivity(mainIntent);
		
	}
});
		ImageButton ib4=(ImageButton)findViewById(R.id.update);
		ib4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		 Intent mainIntent = new Intent(AdminProfile.this,UpdateList.class);
		 AdminProfile.this.startActivity(mainIntent);
		
	}
});
		ImageButton ib5=(ImageButton)findViewById(R.id.delete);
		ib5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		 Intent mainIntent = new Intent(AdminProfile.this,Delete.class);
		 AdminProfile.this.startActivity(mainIntent);
		
	}
});
		ImageButton ib6=(ImageButton)findViewById(R.id.imageButton1);
		ib6.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		 Intent mainIntent = new Intent(getApplicationContext(),PropertyListViewActivity.class);
		 startActivity(mainIntent);
		
	}
});
		TextView tv=(TextView)findViewById(R.id.textView1);
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
				Intent i= new Intent(getApplicationContext(),Home.class);
				
			}
		});
	}

}

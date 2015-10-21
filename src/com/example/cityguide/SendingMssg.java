package com.example.cityguide;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class SendingMssg extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sending_mssg);

		final EditText et1=(EditText)findViewById(R.id.editText1);
		final Button b1=(Button)findViewById(R.id.button1);
		final Button b2=(Button)findViewById(R.id.button2);
		b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//Getting intent and PendingIntent instance  
				
				Intent intent=new Intent(getApplicationContext(),null);  
				PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);  
				//Get the SmsManager instance and call the sendTextMessage method to send message                 
				SmsManager sms=SmsManager.getDefault();
				Bundle extras= getIntent().getExtras();
				String val1=extras.getString("abc");
				sms.sendTextMessage(val1, null, et1.getText().toString(), pi,null); 
				Toast.makeText(getApplicationContext(),"Mssg Send successfully!",Toast.LENGTH_LONG).show();
				
				}
		});
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Bundle extras= getIntent().getExtras();
				String val1=extras.getString("abc");
				Intent ci=new Intent(Intent.ACTION_CALL);
				ci.setData(Uri.parse("tel:"+val1));
				startActivity(ci);
				
			}
		});
	}

}

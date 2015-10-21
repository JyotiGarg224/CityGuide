package com.example.cityguide;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class SendingEmail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sending_email);
		final EditText etData=(EditText)findViewById(R.id.etMailBody);
		final EditText sub=(EditText)findViewById(R.id.sub);
		Button b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Bundle extras= getIntent().getExtras();
				String val1=extras.getString("abc");
				Intent email = new Intent(Intent.ACTION_SEND);  
				email.putExtra(Intent.EXTRA_EMAIL, new String[]{ val1 });  
				email.putExtra(Intent.EXTRA_SUBJECT,  sub.getText().toString());  
				email.putExtra(Intent.EXTRA_TEXT, etData.getText().toString());
				//need this to prompts email client only  
				email.setType("message/rfc822");  
				startActivity(Intent.createChooser(email, "Choose an Email client :"));  
		  

				
				
			}
		});
		
	}

}

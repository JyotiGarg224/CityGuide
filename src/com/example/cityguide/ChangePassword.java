package com.example.cityguide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class ChangePassword extends Activity {
	
	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	

	// Values for email and password at the time of the login attempt.
	
	private String password;
	private EditText mPassword;
	private EditText mPasswordView;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);
		
		Button b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					EditText oldpassword=(EditText)findViewById(R.id.editText1);
					EditText newpassword=(EditText)findViewById(R.id.editText2);
					
					if(oldpassword.getText().toString().equals(""))
					{
						oldpassword.setError("Pls fill old password");
						oldpassword.requestFocus();
					}
					else if(newpassword.getText().toString().equals(""))
					{
						newpassword.setError("Please fill new password");
						newpassword.requestFocus();
					}
					else 
						{		SharedPreferences pref=getSharedPreferences("mypref2", Context.MODE_PRIVATE);
								String pass=pref.getString("password","");
								if(oldpassword.getText().toString().equals(pass))
								{
									Editor edit=pref.edit();
									edit.putString("password", newpassword.getText().toString());
									edit.commit();
									Toast.makeText(getApplicationContext(), "Password changed Successfully", Toast.LENGTH_LONG).show();
									
								}
								else
									Toast.makeText(getApplicationContext(), "Password change error.", Toast.LENGTH_LONG).show();
						}
			Intent i=new Intent(ChangePassword.this,AdminProfile.class);
			ChangePassword.this.startActivity(i);
			finish();
			}
		});
	}
}

package com.example.cityguide;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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

public class Delete extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		final EditText et1=(EditText)findViewById(R.id.editText1);
		Button b1=(Button)findViewById(R.id.button1);
		final DatabaseHelper db=new DatabaseHelper(getApplicationContext());
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				PlacesRegis pb=new PlacesRegis();
				pb.setpName(et1.getText().toString());	
				db.remove(pb);
				Toast.makeText(getApplicationContext(),"removed successfully!",Toast.LENGTH_LONG).show();
				et1.setText("");
				
			}
		});

		
	}

}

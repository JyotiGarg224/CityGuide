package com.example.cityguide;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.example.cityguide.PlaceRegistration.Details;
import com.example.cityguide.PlaceRegistration.Image;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.os.Build;

public class Update extends Activity {
	PlacesRegis pb;
	EditText et1,et2,et3,et4,et5,et6,et7;
	Button b1,b2;
	ImageView iv;
	RatingBar rb;
	public static final int RESULT_LOAD_IMG = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);
		Bundle extras= getIntent().getExtras();
		String propertyname=extras.getString("pname");
		android.app.ActionBar ab = getActionBar();
		ab.setTitle(""+propertyname);
		
		et1=(EditText)findViewById(R.id.names);
		 et2=(EditText)findViewById(R.id.address);
		 et3=(EditText)findViewById(R.id.category);
		 et4=(EditText)findViewById(R.id.contact);
		et5=(EditText)findViewById(R.id.email);
		 et6=(EditText)findViewById(R.id.web);
		 et7=(EditText)findViewById(R.id.descp);
		 b1=(Button)findViewById(R.id.button1);
		 b2=(Button)findViewById(R.id.button2);
		 iv=(ImageView)findViewById(R.id.imageView1);
		 rb=(RatingBar)findViewById(R.id.ratingBar1);
		 
		final DatabaseHelper dbh=new DatabaseHelper(getApplicationContext());
		List<PlacesRegis>items=dbh.getAllProperties("select * from PropertyMaster where col_pname='"+propertyname+"'");
		if(items!=null)
			pb=items.get(0);
		et1.setText(propertyname);
		et1.setEnabled(false);
		et2.setText(pb.getpAddress());
		et4.setText(pb.getpContact());
		et5.setText(pb.getpEmail());
		et7.setText(pb.getpDesc());
		et3.setText(pb.getpCategory());
		et6.setText(pb.getpWebURL());
		rb.setRating((float)pb.getRating());
		byte imgarr[]=pb.getPimage();
 		Bitmap bitmap=BitmapFactory.decodeByteArray(imgarr,0,imgarr.length);
 		iv.setImageBitmap(bitmap);
 		
 		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// Create intent to Open Image applications like Gallery, Google Photos 
				Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI); 
				// Start the Intent 
				//galleryIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivityForResult(galleryIntent, Image.RESULT_LOAD_IMG);
				
			}
			
		});
 		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
 		
 		pb=new PlacesRegis();
 		pb.setpName(et1.getText().toString());
		pb.setpAddress(et2.getText().toString());
		pb.setpContact(et4.getText().toString());
		pb.setpEmail(et5.getText().toString());
		pb.setpDesc(et7.getText().toString());
		pb.setRating(rb.getRating());
		pb.setpCategory(et3.getText().toString());
		pb.setpWebURL(et6.getText().toString());
		iv.setDrawingCacheEnabled(true);
		iv.buildDrawingCache();
		Bitmap bitmap1=iv.getDrawingCache();
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		bitmap1.compress(Bitmap.CompressFormat.JPEG,100,bos);
		
		
		pb.setPimage(bos.toByteArray());
		
			dbh.update(pb);
			Toast.makeText(getApplicationContext(),"update successfully!",Toast.LENGTH_LONG).show();

			}
			
			
		});
		
	}
	 public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    	if(requestCode==Image.RESULT_LOAD_IMG&&resultCode==Activity.RESULT_OK&&data!=null)
	    		iv.setImageURI(data.getData());
	    	else
	    		Toast.makeText(getApplicationContext(), "Else Part of Onactivity result",Toast.LENGTH_LONG).show();
	    	
	    }	
}

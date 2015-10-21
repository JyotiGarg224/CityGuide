package com.example.cityguide;

import java.io.ByteArrayOutputStream;

import com.example.cityguide.R;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.TabListener;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;
 
public class PlaceRegistration extends FragmentActivity implements
        ActionBar.TabListener {
 
    private ViewPager viewPager;
    private CustomPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "Details", "Image"};
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_registration);
 
        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new CustomPagerAdapter(this.getSupportFragmentManager(), getApplicationContext());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
 
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
 
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
 
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }
 
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }
    public static class Image extends Fragment {
    	public static final int RESULT_LOAD_IMG = 0;
    	ImageView iv=null;
    	public View onCreateView(LayoutInflater inflater, ViewGroup container,
    			Bundle savedInstanceState) {
    		
    		final View image= inflater.inflate(R.layout.image, container,false);
    		iv=(ImageView)image.findViewById(R.id.img_image);
    		Button btn=(Button)image.findViewById(R.id.btnImgUpload);
    		btn.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View arg0) {
    				// Create intent to Open Image applications like Gallery, Google Photos 
    				Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI); 
    				// Start the Intent 
    				//galleryIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    				startActivityForResult(galleryIntent, Image.RESULT_LOAD_IMG);
    				
    			}
    			
    		});
    		final RatingBar rb=(RatingBar)image.findViewById(R.id.ratingBar1);
    		Button b1=(Button)image.findViewById(R.id.button1);
    		b1.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View view) {
    					PlacesRegis pb=new PlacesRegis();
    					
    					pb.setpAddress(Details.e3.getText().toString());
    					pb.setpCategory(Details.e2.getText().toString());
    					pb.setpContact(Details.e4.getText().toString());
    					pb.setpDesc(Details.e7.getText().toString());
    					pb.setpEmail(Details.e5.getText().toString());
    					
    					ImageView iv=(ImageView)image.findViewById(R.id.img_image);
    					iv.setDrawingCacheEnabled(true);
    					iv.buildDrawingCache();
    					Bitmap bitmap=iv.getDrawingCache();
    					ByteArrayOutputStream bos=new ByteArrayOutputStream();
    					bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos);
    					
    					
    					pb.setPimage(bos.toByteArray());
    					
    					pb.setpName(Details.e1.getText().toString());
    					pb.setpWebURL(Details.e6.getText().toString());
    					pb.setRating(rb.getRating());
    					
    					DatabaseHelper dbh=new DatabaseHelper(getActivity().getApplicationContext());
    					dbh.addProperty(pb);
    					Toast.makeText(image.getContext(), "Property Registered Successfully",Toast.LENGTH_LONG).show();
    					
    				}
    				
    				
    				});
    		return image;
    		
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if(requestCode==Image.RESULT_LOAD_IMG&&resultCode==Activity.RESULT_OK&&data!=null)
    		iv.setImageURI(data.getData());
    	else
    		Toast.makeText(getActivity(), "Else Part of Onactivity result",Toast.LENGTH_LONG).show();
    	
    }	 
    }
	public static class Details extends Fragment {
		DatabaseHelper dbhelper=null;
		EditText et1,et2,et3,et4,et5,et6,et7;
		Button b1;
		public static EditText e1,e2,e3,e4,e5,e6,e7;
	
	
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			final View details = inflater.inflate(R.layout.details, container,false);
			dbhelper=new DatabaseHelper(details.getContext());
			 et1=(EditText)details.findViewById(R.id.names);
			 et2=(EditText)details.findViewById(R.id.category);
			 et3=(EditText)details.findViewById(R.id.address);
			 et4=(EditText)details.findViewById(R.id.contact);
			et5=(EditText)details.findViewById(R.id.email);
			 et6=(EditText)details.findViewById(R.id.web);
			 et7=(EditText)details.findViewById(R.id.descp);
			
			 setEt(et1,et2,et3,et4,et5,et6,et7);
			return details;
		}
		public void setEt(EditText a,EditText b,EditText c,EditText d,EditText e,EditText f,EditText g) {
		    e1 = a;
		    e2 = b;
		    e3 = c;
		    e4 = d;
		    e5 = e;
		    e6 = f;
		    e7 = g;
		  
		}   
	}
	public class CustomPagerAdapter extends FragmentStatePagerAdapter {
		
		protected Context mContext;
	
		public CustomPagerAdapter(android.support.v4.app.FragmentManager fm,
				Context context) {
			super(fm);
			mContext = context;
		}
	
		public android.support.v4.app.Fragment getItem(int arg0) {
			switch(arg0)
			{
			case 0: return new Details();
			case 1: return new Image();
			
			}
			return null;
		}
	
		@Override
		public int getCount() {
			return 2;
		}
	
	}
}
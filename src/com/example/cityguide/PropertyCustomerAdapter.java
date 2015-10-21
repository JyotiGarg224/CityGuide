package com.example.cityguide;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public  class PropertyCustomerAdapter extends BaseAdapter {
	Context context;
    List<PlacesRegis> itemsList=null;
    int i=0;
    public PropertyCustomerAdapter(Context context,
			List<PlacesRegis> objects) {
    	super();
    	this.context=context;
		this.itemsList=objects;  
		// TODO Auto-generated constructor stub
	}
   

	/*************  CustomAdapter Constructor *****************/
 
 
    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {
         return itemsList.size();
    }
 
    public PlacesRegis getItem(int position) {
        return itemsList.get(position);
    }
 
    public long getItemId(int position) {
        return position;
    }
     
  
 
    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {
         if(convertView==null){
       	  LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       	  convertView=inflater.inflate(R.layout.property_item, null);		
         }
		TextView tv=(TextView)convertView.findViewById(R.id.textView1);
		ImageView iv=(ImageView)convertView.findViewById(R.id.imageView1);
		
		PlacesRegis pb=itemsList.get(position);
		
		tv.setText(pb.getpName());
		byte imgarr[]=pb.getPimage();
		Bitmap bitmap=BitmapFactory.decodeByteArray(imgarr,0,imgarr.length);
		iv.setImageBitmap(bitmap);
		tv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(android.view.View arg0) {
				Intent i=new Intent(context,PropertyDetailActivity.class);
				TextView tv1=(TextView)arg0;
				//Toast.makeText(context, tv1.getText(), Toast.LENGTH_LONG).show();
				i.putExtra("pname",tv1.getText().toString());
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(i);// TODO Auto-generated method stub
				
			}
		});
		
		return convertView;
    }
     
}


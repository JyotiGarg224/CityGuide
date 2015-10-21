package com.example.cityguide;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.inputmethodservice.Keyboard.Key;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
Context context;
	public DatabaseHelper(Context context)
	{	super(context,"dbcity",null,3);
		this.context=context;
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		try
		{ 
		String qry="create table PropertyMaster(col_pname text primary key,col_pimage BLOB,col_paddress text,col_pcontact text,col_pemail text,col_pdesc text,col_prating double,col_pcategory text,col_pweburl text)";
		db.execSQL(qry);
		}
		catch(Exception ex)
		{
			Toast.makeText(context, ""+ex, Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		try{
			db.execSQL("drop table if exists PropertyMaster");
			onCreate(db);
		}
		catch(Exception ex)
		{
			Toast.makeText(context, ""+ex, Toast.LENGTH_LONG).show();
		}	
	}
	public void addProperty(PlacesRegis pb)
	{	try{
		SQLiteDatabase db=getWritableDatabase();
		ContentValues row=new ContentValues();
		row.put("col_pname",pb.getpName());
		row.put("col_pimage", pb.getPimage());
		row.put("col_paddress",pb.getpAddress());
		row.put("col_pcontact",pb.getpContact());
		row.put("col_pemail",pb.getpEmail());
		row.put("col_pdesc",pb.getpDesc());
		row.put("col_prating",pb.getRating());
		row.put("col_pcategory",pb.getpCategory());
		row.put("col_pweburl",pb.getpWebURL());
		
		db.insert("PropertyMaster", null, row);
		
		db.close();
	}
	catch(Exception ex)
	{
		Toast.makeText(context, ""+ex, Toast.LENGTH_LONG).show();
	}
	}
	public List<PlacesRegis> getAllProperties(String qry)
	{	
		List<PlacesRegis> plist=new ArrayList<PlacesRegis>();
		try{
		SQLiteDatabase db=getReadableDatabase();
		Cursor cursor=db.rawQuery(qry,null);
		PlacesRegis pb;
		if(cursor!=null)
		{
			while(cursor.moveToNext()){ 
					pb=new PlacesRegis();
					pb.setpName(cursor.getString(0));
					pb.setPimage(cursor.getBlob(1));
					pb.setpAddress(cursor.getString(2));
					pb.setpContact(cursor.getString(3));
					pb.setpEmail(cursor.getString(4));
					pb.setpDesc(cursor.getString(5));
					pb.setRating(cursor.getDouble(6));
					pb.setpCategory(cursor.getString(7));
					pb.setpWebURL(cursor.getString(8));
					plist.add(pb);
			}
		}
		}
	catch(Exception ex)
	{
		Toast.makeText(context, ""+ex, Toast.LENGTH_LONG).show();
	}
		return plist;
		
	}
	public Cursor getAllPropertiesCursor()
	{	
		List<PlacesRegis> plist=new ArrayList<PlacesRegis>();
		try{
				SQLiteDatabase db=getReadableDatabase();
				Cursor cursor=db.rawQuery("select * from PropertyMaster",null);
				return cursor;
		}
	catch(Exception ex)
	{
		Toast.makeText(context, ""+ex, Toast.LENGTH_LONG).show();
	}
		return null;
		
	}
	public int remove(PlacesRegis pb)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		
		return db.delete("PropertyMaster", "col_pname=?",new String[]{String.valueOf(pb.getpName())});
		
	}
	public int update(PlacesRegis pb)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues row=new ContentValues();
		
		row.put("col_pname",pb.getpName());
		row.put("col_pimage", pb.getPimage());
		row.put("col_paddress",pb.getpAddress());
		row.put("col_pcontact",pb.getpContact());
		row.put("col_pemail",pb.getpEmail());
		row.put("col_pdesc",pb.getpDesc());
		row.put("col_prating",pb.getRating());
		row.put("col_pcategory",pb.getpCategory());
		row.put("col_pweburl",pb.getpWebURL());
		return db.update("PropertyMaster", row, "col_pname=?",new String[]{String.valueOf(pb.getpName())});	
	}
	public List<PlacesRegis> getSearchResult(String search)
	{	SQLiteDatabase db=getReadableDatabase();
	List<PlacesRegis> plist=new ArrayList<PlacesRegis>();
		Cursor cur=db.rawQuery("select * from PropertyMaster",null);
		if(cur!=null)
		{
			while(cur.moveToNext()){ 
				for(int i=0;i<9;i++)
				{	if(i==1)
						continue;
					if(cur.getString(i).trim().toLowerCase().indexOf(search.toLowerCase().trim())!=-1)
					{	PlacesRegis pb=new PlacesRegis();
						pb.setpName(cur.getString(0));
						pb.setPimage(cur.getBlob(1));
						pb.setpAddress(cur.getString(2));
						pb.setpContact(cur.getString(3));
						pb.setpEmail(cur.getString(4));
						pb.setpDesc(cur.getString(5));
						pb.setRating(cur.getDouble(6));
						pb.setpCategory(cur.getString(7));
						pb.setpWebURL(cur.getString(8));
						plist.add(pb);
						break;
					}
				}
			}
			return plist;
		}
		return null;
	}
	
}


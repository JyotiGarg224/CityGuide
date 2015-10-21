package com.example.cityguide;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentStatePagerAdapter;

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

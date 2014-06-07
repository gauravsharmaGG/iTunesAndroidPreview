package com.besaba.srmu.adapter;

import com.besaba.srmu.CustomizedListView;
import com.besaba.srmu.GamesFragment;
import com.besaba.srmu.MoviesFragment;
import com.besaba.srmu.TopRatedFragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Games fragment activity
			return new GamesFragment();
		case 1:
			// Movies fragment activity
			return new MoviesFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 2;
	}


	
}

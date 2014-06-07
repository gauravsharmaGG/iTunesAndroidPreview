package com.besaba.srmu;

import com.besaba.srmu.R;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.besaba.srmu.CustomizedListView;

public class GamesFragment extends Fragment {

	private FragmentTabHost mTabHost;
	private ViewPager viewPager;
	private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

   
	Bundle bundle = new Bundle();
	
	
	//EditText mEdit = (EditText)getActivity().findViewById(R.id.editText1);
	// EditText mEdit2  = (EditText)getActivity().findViewById(R.id.editText2);
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_games, container, false);
		 ImageButton button = (ImageButton) rootView.findViewById(R.id.button1);
		 button.setOnClickListener(onClick);
		 
		 return rootView;
		
			 
	}
	

	private OnClickListener onClick = new OnClickListener() {
		public void onClick(View rootView) {
			
			
			
			RotateAnimation anim = new RotateAnimation(0, 360, 0, 360);
			ImageButton button = (ImageButton) rootView.findViewById(R.id.button1);
			 anim.setDuration(1000);
			  rootView.startAnimation(anim);
			   
			  button.setImageResource(R.drawable.search_click1);
				

			   new Handler().postDelayed(new Runnable() {

			        @Override
			        public void run() {
			            // wait for the duration of the animation before switching acitivity
			            // remember to apply the overridePendingTransition to them 
			            // if you want a transition animation on this too

			            // overridePendingTransition added to both onCreate of Test and MainActivity
						
						Intent firstpage=new Intent(getActivity().getApplicationContext(),PopUp.class);
						startActivity(firstpage);
						ImageButton button = (ImageButton) getActivity().findViewById(R.id.button1);
						  button.setImageResource(R.drawable.search);
					 

			        }
			    }, 1000); // <-- notice the wait for animation to complete
			   
			   button.setImageResource(R.drawable.search_click);
				
		}
		
	};
}
	/*	try {
			
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater) GamesFragment.this
			.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.popup,
			(ViewGroup) getView().findViewById(R.id.popup_element));
			pwindo = new PopupWindow(layout, 350, 470, true);
			pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
			Button btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
			
			
			 
			btnClosePopup.setOnClickListener(cancel_button_click_listener);

			} catch (Exception e) {
			e.printStackTrace();
			}
			} 
			
	};
	
	

	public void setCurrentTab(int tab_index){
	    mTabHost = (FragmentTabHost)getActivity().findViewById(android.R.id.tabhost);
	    mTabHost.setCurrentTab(0);
	    }
	
	private OnClickListener cancel_button_click_listener = new OnClickListener() {
				public void onClick(View rootView) {
					
					EditText vidView = (EditText) rootView.findViewById(R.id.editText1);
					EditText vidVieq = (EditText)rootView.findViewById(R.id.editText2);
					String content = vidView.getText().toString();
					String contend = vidVieq.getText().toString();
					pwindo.dismiss();
					Intent firstpage=new Intent(getActivity().getApplicationContext(),CustomizedListView.class);
					//firstpage.putExtra("ura", content);
					//firstpage.putExtra("urb", contend);
					startActivity(firstpage);
					
				
			//		viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
			//		viewPager.setCurrentItem(2);
					
					//FragmentTabHost tabHost = (FragmentTabHost)  getActivity().findViewById(android.R.id.tabhost);
					//tabHost.setCurrentTab(1);
			}
			};

	}
	
	*/
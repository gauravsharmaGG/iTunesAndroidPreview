package com.besaba.srmu;

import com.besaba.srmu.R;

import android.app.Activity;
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
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.besaba.srmu.CustomizedListView;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;


public class PopUp extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		overridePendingTransition(R.anim.slide_in_top, R.anim.slide_down_bottom);
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.popup);
	        Button button = (Button) findViewById(R.id.btn_close_popup);
			 button.setOnClickListener(onClick);
			}
	
	private OnClickListener onClick = new OnClickListener() {
		public void onClick(View rootView) {
			
			TranslateAnimation anim = new TranslateAnimation(0, 2, 0, 2);
			Button button = (Button) findViewById(R.id.btn_close_popup);
			button.setText("Loading.");
			   anim.setDuration(1000);
			   rootView.startAnimation(anim);
			   button.setText("Loading..");

			   new Handler().postDelayed(new Runnable() {

			        @Override
			        public void run() {
			            // wait for the duration of the animation before switching acitivity
			            // remember to apply the overridePendingTransition to them 
			            // if you want a transition animation on this too

			            // overridePendingTransition added to both onCreate of Test and MainActivity
			        	Button button = (Button) findViewById(R.id.btn_close_popup);
						button.setText("Loading...");
						
						EditText vidView = (EditText) findViewById(R.id.editText1);
						EditText vidVieq = (EditText) findViewById(R.id.editText2);
						String content = vidView.getText().toString();
						String contend = vidVieq.getText().toString();
						
						Intent firstpage=new Intent(PopUp.this ,CustomizedListView.class);
						
						firstpage.putExtra("content", content);
						firstpage.putExtra("contend", contend);
						startActivity(firstpage);
						 
						overridePendingTransition(R.anim.rotate_out,R.anim.rotate_in);
						button.setText("Loading.");
						

			        }
			    }, 3000); // <-- notice the wait for animation to complete
			   
			
			
			   
			
			
			
		
		}
		
	};
}

	

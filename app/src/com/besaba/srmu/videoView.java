package com.besaba.srmu;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.besaba.srmu.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.besaba.srmu.CustomizedListView;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;


public class videoView extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.video);
	        ProgressDialog pd = new ProgressDialog(this);
            pd.setMessage("Buffering..");
            pd.show();
	        String uri = getIntent().getStringExtra("ura");
	        String vidAddress = uri;
	        VideoView vidView = (VideoView)findViewById(R.id.myVideo);
	        Uri vidUri = Uri.parse(vidAddress);
	        vidView.setVideoURI(vidUri);
	        MediaController vidControl = new MediaController(this);
	        vidControl.setAnchorView(vidView);
	        vidView.setMediaController(vidControl);
	        
	        vidView.start();
	        pd.dismiss();
	
	        //
	        String urb = getIntent().getStringExtra("urb");
	        Bitmap bmp;
	        Drawable dr = null;
	        URL url;
			try {
				url = new URL(urb);
				bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
				dr = new BitmapDrawable(bmp);
		    } catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        vidView.setBackgroundDrawable(dr);
	    	//
	        }
}
	

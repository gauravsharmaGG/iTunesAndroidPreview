package com.besaba.srmu;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.VideoView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CustomizedListView extends Activity {
	
	
	ConnectionDetector cd;
	
	// Alert dialog manager
	AlertDialogManager alert = new AlertDialogManager();
	
	// Progress Dialog
	private ProgressDialog pDialog;

	// All static variables
	
	// XML node keys
	static final String KEY_SONG = "results"; // parent node
	static final String KEY_ID = "trackId";
	static final String KEY_TITLE = "trackName";
	static final String KEY_ARTIST = "artistName";
	static final String KEY_DURATION = "collectionPrice";
	static final String KEY_THUMB_URL = "artworkUrl100";
	static final String KEY_MEDIA_URL = "previewUrl";
	
	ListView list;
    LazyAdapter adapter;
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
 
        return super.onCreateOptionsMenu(menu);
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
       case R.id.action_location_found:
            // location found
            LocationFound();
            return true;
       case R.id.action_search:
           // location found
           LocationFound1();
           return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
 
    /**
     * Launching new activity
     * */
    private void LocationFound() {
        Intent i = new Intent(CustomizedListView.this, MainActivity.class);
        startActivity(i);
    }

    private void LocationFound1() {
        Intent i = new Intent(CustomizedListView.this, PopUp.class);
        startActivity(i);
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		   
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		overridePendingTransition(R.anim.slide_in_top, R.anim.slide_down_bottom);
		 
		
        Intent intent = getIntent();
		String name = intent.getStringExtra("content");
		String limit = intent.getStringExtra("contend");

		setTitle(name);

		String URL = "https://query.yahooapis.com/v1/public/yql?q=SELECT%20*%20%0AFROM%20json%0AWHERE%20url%3D%27%20http%3A%2F%2Fitunes.apple.com%2Fsearch%3Fterm%3D"+name+"%26limit%3D"+limit+"%26media%3Dmusic%27&diagnostics=true";
		

		final ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL); // getting XML from URL
		Document doc = parser.getDomElement(xml); // getting DOM element
		
		NodeList nl = doc.getElementsByTagName(KEY_SONG);
		// looping through all song nodes <song>
		for (int i = 0; i < nl.getLength(); i++) {
			// creating new HashMap
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			// adding each child node to HashMap key => value
			map.put(KEY_ID, parser.getValue(e, KEY_ID));
			map.put(KEY_TITLE, parser.getValue(e, KEY_TITLE));
			map.put(KEY_ARTIST, parser.getValue(e, KEY_ARTIST));
			map.put(KEY_DURATION, parser.getValue(e, KEY_DURATION));
			map.put(KEY_THUMB_URL, parser.getValue(e, KEY_THUMB_URL));
			map.put(KEY_MEDIA_URL, parser.getValue(e, KEY_MEDIA_URL));

			// adding HashList to ArrayList
			songsList.add(map);
		}
		
		
		
		

		list=(ListView)findViewById(R.id.list);
		
		// Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(this, songsList);        
        list.setAdapter(adapter);
        

        // Click event for single list row
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
									String ura = songsList.get(position).get(KEY_MEDIA_URL);
									String urb = songsList.get(position).get(KEY_THUMB_URL);
									String urc = songsList.get(position).get(KEY_ARTIST);
									//String uri = KEY_MEDIA_URL;
									
									
									Intent firstpages=new Intent(CustomizedListView.this , videoView.class);
									firstpages.putExtra("ura", ura);
									firstpages.putExtra("urb", urb);
									firstpages.putExtra("urc", urc);
									startActivity(firstpages);

			}
		});		
	}	
}
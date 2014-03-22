package com.example.rssreader;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * display the title and description passed in from the intent extras
 * @author josh
 *
 */
public class DescriptionActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.description_layout);		
		String description = getIntent().getStringExtra("description");
		String title = getIntent().getStringExtra("title");		
		TextView tv = (TextView) findViewById(R.id.title);
		tv.setText(title);
		// we use a webview because the description contains html
		WebView wv = (WebView) findViewById(R.id.description);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setBuiltInZoomControls(false);
	    wv.getSettings().setPluginState(PluginState.ON);
		wv.loadData(description, "text/html", null);

	}

}

package com.example.rssreader;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
import utils.Adapter;
import utils.MyPullParser;
import utils.RssItem;
import com.example.rssreader.MainActivity;
import com.example.rssreader.R;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Activity goesin = this;
		final ListView lv = (ListView) findViewById(R.id.listview);	
		(new Thread(new Runnable() {
			ArrayList<RssItem> rssitem;

			@Override
			public void run() {
				try {
					this.rssitem = MyPullParser
							.parse("http://rss.cnn.com/rss/cnn_tech.rss");
					MainActivity.this.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							lv.setAdapter(new Adapter(goesin, rssitem));
						}
					});
				} catch (XmlPullParserException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		})).start();
	}
}
/**
 * set up the ui after we've downloaded and parsed the rss feed
 * 
 * @param parser
 */

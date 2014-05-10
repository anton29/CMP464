package com.example.rssreader;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
import utils.Adapter;
import utils.DatabaseHandler;
import utils.MyPullParser;
import utils.RssItem;
import com.example.rssreader.MainActivity;
import com.example.rssreader.R;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;



public class MainActivity extends Activity {
	private static final int SERVICE_CONNECTION_ACK = 1;

	private static final int MESSAGE_RECEIVED = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		// bind to the service, passing in the established service connection
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

/**
 * set up the ui after we've downloaded and parsed the rss feed
 * 
 * @param parser
 */



}

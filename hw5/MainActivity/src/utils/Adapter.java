package utils;

import java.util.ArrayList;
import com.example.rssreader.DescriptionActivity;
import com.example.rssreader.R;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class Adapter extends BaseAdapter{

	private ArrayList<RssItem> items;
	private Activity stories;

	public Adapter(Activity stories, ArrayList<RssItem> items){
		this.items = items;
		this.stories = stories;
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = null;
		if(convertView != null){
			view = convertView;
		}else{
			view = stories.getLayoutInflater().inflate(R.layout.list_items, null);
		}
		final RssItem item = (RssItem) getItem(position);
		TextView tv = (TextView) view.findViewById(R.id.story_title);
		tv.setText(item.getTitle());
		Button btn = (Button) view.findViewById(R.id.button);
		btn.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(stories,DescriptionActivity.class);
				intent.putExtra("title", item.getTitle());
				intent.putExtra("description", item.getDescription());
				intent.putExtra("pubDate", item.getpubDate());
				stories.startActivity(intent);
			}
		});
		
		return view;
	}
}
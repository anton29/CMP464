package utils;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import static utils.DatabaseHelper.*;
public class DatabaseHandler {
	

	
	private DatabaseHelper dbHelper;
	private SQLiteDatabase database;


	public DatabaseHandler(Context context) {
	    dbHelper = new DatabaseHelper(context);
	    database = dbHelper.getWritableDatabase();

	}

	public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	}



	public void clearTable(String tableName) {
	    database.delete( tableName, null, null);
	}




	public void insertRssItem(RssItem rssitem) {
		String pubDate =rssitem.getpubDate();
		String title =rssitem.getTitle();
		String description =rssitem.getDescription();

		
		
	    ContentValues cv = new ContentValues();
		for (int i = 0; i < title.length(); i++) {
			cv.put(KEY_PUBDATE, pubDate);
			cv.put(KEY_TITLE, title);
			cv.put(KEY_DESCRIPTION, description);
			database.insert(DATABASE_NAME, null, cv);
		}
		dbHelper.close();
	}


		public void close() {
		    dbHelper.close();
				
				
	}
}


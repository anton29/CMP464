package utils;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;




public class DatabaseHelper extends SQLiteOpenHelper{
	private final String TAG ="DatabaseHelper";
	public static final String DATABASE_NAME ="rsstable";
	public static final String KEY_ID ="id";
	public static final String KEY_TITLE="title";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_PUBDATE ="pubDate";
	
	public DatabaseHelper(Context context)
	{
		super(context,DATABASE_NAME,null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase)
	{
		String table ="create tabe"+DATABASE_NAME+"("+
				KEY_ID +"interger primary key autoincrement, "+
				KEY_PUBDATE +"TEXT"+
				KEY_TITLE+"TEXT"+
				KEY_DESCRIPTION+"TEXT"+")";
		sqLiteDatabase.execSQL(table);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if it exists" + DATABASE_NAME);
		onCreate(db);
		
	}

	public void dropTable() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
		onCreate(db);
		db.close();
	}
		
	}
	



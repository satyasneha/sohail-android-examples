package sohail.aziz.mycontentprovider;




import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Class to manage the creation and modification of database structure. It is
 * also used to manage connection to the SQLite database (hence the OpenHelper
 * in the name) Note that Android SDK will create DB once. Once created it's
 * structure won't change until version number is changed.
 * 
 * @author Vladimir Vivien (http://vladimirvivien.com/)
 * 
 */
/*
 * modified and updated by sohail aziz
 * http://www.sohailaziz.com
 * */
public class MyDatabase extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "munshi.db";
	private static final int DATABASE_VERSION = 2;

	// custom constructor
	public MyDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		// creating tables categories
		db.execSQL("CREATE TABLE " + MyContentDescriptor.Categories.TABLE_NAME+ " ( "+
		         MyContentDescriptor.Categories.Cols.cat_id+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
				 MyContentDescriptor.Categories.Cols.key_1_catid + " TEXT NOT NULL," + 
				 MyContentDescriptor.Categories.Cols.key_2_catname	+ " TEXT NOT NULL," +
				 MyContentDescriptor.Categories.Cols.key_3_catstatus + " TEXT," +
				"UNIQUE (" + 
				MyContentDescriptor.Categories.Cols.cat_id + 
			") ON CONFLICT REPLACE)"
				);
				

		// creating table transactions
		db.execSQL("CREATE TABLE " + MyContentDescriptor.Transactions.TABLE_NAME + "(" +
				 MyContentDescriptor.Transactions.Cols.tran_id+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
				 MyContentDescriptor.Transactions.Cols.key_1_username + " TEXT NOT NULL,"+
				 MyContentDescriptor.Transactions.Cols.key_2_password + " TEXT NOT NULL,"+
				 MyContentDescriptor.Transactions.Cols.key_3_catid + " TEXT NOT NULL,"+
				 MyContentDescriptor.Transactions.Cols.key_4_amount + " TEXT NOT NULL,"+
				 MyContentDescriptor.Transactions.Cols.key_5_type + " TEXT NOT NULL,"+
				 MyContentDescriptor.Transactions.Cols.key_6_comment + " TEXT,"+
				 "UNIQUE (" + 
				 MyContentDescriptor.Transactions.Cols.tran_id+
				 ") ON CONFLICT REPLACE)"
				);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 if(oldVersion < newVersion){
	        	db.execSQL("DROP TABLE IF EXISTS " + MyContentDescriptor.Categories.TABLE_NAME);
	        	db.execSQL("DROP TABLE IF EXISTS " + MyContentDescriptor.Transactions.TABLE_NAME);
	        	onCreate(db);
	        }

	}

}

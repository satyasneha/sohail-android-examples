package sohail.aziz.mycontentprovider;

import java.util.jar.Attributes.Name;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

/*
 @author Vladimir Vivien (http://vladimirvivien.com/)
 * 
 */
/*
 * modified and updated by sohail aziz
 * http://www.sohailaziz.com
 * */
public class MyContentDescriptor {

	public static final String AUTHORITY = "sohail.aziz.mycontentprovider";

	private static final Uri BASE_URI = Uri.parse("content://" + AUTHORITY);

	public static final UriMatcher URI_MATCHER = buildUriMatcher();

	// define content mime type for entity
	public static final String CONTENT_TYPE_DIR = "sohail.aziz.cursor.dir/sohail.aziz.munshi.app";
	public static final String CONTENT_ITEM_TYPE = "sohail.aziz.cursor.item/sohail.aziz.munshi.app";

	private static UriMatcher buildUriMatcher() {
		// TODO Auto-generated method stub
		final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

		// have to add tables uri here
		final String authority = AUTHORITY;

		// adding category Uris
		matcher.addURI(authority, Categories.CAT_PATH,
				Categories.CAT_PATH_TOKEN);
		matcher.addURI(authority, Categories.CAT_PATH_FOR_ID,
				Categories.CAT_PATH_FOR_ID_TOKEN);
		// adding transaction Uris
		matcher.addURI(authority, Transactions.TRAN_PATH,
				Transactions.TRAN_PATH_TOKEN);
		matcher.addURI(authority, Transactions.TRAN_PATH_FOR_ID,
				Transactions.TRAN_PATH_FOR_ID_TOKEN);

		return matcher;
	}

	public static class Categories {
		// an identifying name for entity
		public static final String TABLE_NAME = "categories";
		// define a URI paths to access entity
		// BASE_URI/restaurants - for list of restaurants
		// BASE_URI/restaurants/* - retreive specific restaurant by id
		// the toke value are used to register path in matcher (see above)
		public static final String CAT_PATH = "categories/";
		public static final int CAT_PATH_TOKEN = 100;

		public static final String CAT_PATH_FOR_ID = "categories/#";
		public static final int CAT_PATH_FOR_ID_TOKEN = 200;

		// creating contentUri accessible from outside
		// URI for all content stored as Restaurant entity
		// BASE_URI + PATH ==>
		// "content://com.favrestaurant.contentprovider/restaurants";
		public static final Uri CONTENT_URI = BASE_URI.buildUpon()
				.appendPath(CAT_PATH).build();

		public static class Cols {

			public static final String cat_id = BaseColumns._ID;
			public static final String key_1_catid = "id";
			public static final String key_2_catname = "name";
			public static final String key_3_catstatus = "status";

		}

	}

	public static class Transactions {

		public static final String TABLE_NAME = "transactions";

		public static final String TRAN_PATH = "transactions/";
		public static final int TRAN_PATH_TOKEN = 300;

		public static final String TRAN_PATH_FOR_ID = "transactions/#";
		public static final int TRAN_PATH_FOR_ID_TOKEN = 400;

		public static final Uri CONTENT_URI = BASE_URI.buildUpon()
				.appendPath(TRAN_PATH).build();

		// these cols should be equal to transaction's cols name key_1_...
		public static class Cols {

			public static final String tran_id = BaseColumns._ID;
			public static final String key_1_username = "username";
			public static final String key_2_password = "password";
			public static final String key_3_catid = "catid";
			public static final String key_4_amount = "amount";
			public static final String key_5_type = "type";
			public static final String key_6_comment = "comment";
		}
	}

}

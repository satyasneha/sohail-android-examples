package sohail.aziz.db4oexample;

import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class Db4oExampleActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	Button btInsert, btDisplay, btDisplayRecent, btShowChecked, btDeleteAll;
	SimpleCursorAdapter adapter;
	ListView listview;
	Cursor cur;
	EditText etID, etNAME;
	CheckBox cbStatus;
	ObjectContainer db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		etID = (EditText) findViewById(R.id.etID);
		etNAME = (EditText) findViewById(R.id.etNAME);
		cbStatus = (CheckBox) findViewById(R.id.cbStatus);

		btInsert = (Button) findViewById(R.id.btInsert);
		btDisplay = (Button) findViewById(R.id.btShow);
		btDisplayRecent = (Button) findViewById(R.id.btShowRecent);
		btShowChecked = (Button) findViewById(R.id.btShowChecked);
		btDeleteAll = (Button) findViewById(R.id.btDeleteAll);

		listview = (ListView) findViewById(R.id.lvList);

		btInsert.setOnClickListener(this);
		btDisplay.setOnClickListener(this);
		btDisplayRecent.setOnClickListener(this);
		btShowChecked.setOnClickListener(this);
		btDeleteAll.setOnClickListener(this);
		// ////////

		String path = this.getDir("data", 0) + "/" + "contactdb.db4o";
		// db= Db4oEmbedded .openFile(Db4oEmbedded.newConfiguration(),path);

		// ///////////insert,read,update, delete///////////////////////////
		DbHelperQBE dbhelper = new DbHelperQBE();
		dbhelper.OpenDb(path);
		
		//empty db
		
		dbhelper.emptyDb();
		

		// insert few contacts
		dbhelper.StoreContact(new Contact("sohail", "111", 10, true));
		dbhelper.StoreContact(new Contact("asad", "222", 20, true));
		dbhelper.StoreContact(new Contact("aslam", "333", 30, true));
		dbhelper.StoreContact(new Contact("butt", "444", 40, true));
		dbhelper.StoreContact(new Contact("aziz", "555", 50, true));

		// read all contacts
		ArrayList list = dbhelper.getAllContacts();
		Log.d("sohail", "displayign all contacts");
		for (int i = 0; i < list.size(); i++) {
			Log.d("sohail", list.get(i).toString());
		}

		// //get contact where name= butt
		Contact con = dbhelper.getContactByName("butt");
		Log.d("sohail", "contact where name=butt is:" + con.toString());

		// /get contact where age is 20
		Contact temp = new Contact();
		temp.setAge(20);

		Log.d("sohail", "contact with age=20 is:"
				+ dbhelper.getContact(temp).toString());

		// /delete contact where name=aslam
		Contact dobj = new Contact();
		dobj.setName("aslam");
		Log.d("sohail", "deleting contact where name=aslam");
		if (dbhelper.deleteObject(dobj)) {
			Log.d("sohail", "obj deleted");
		}

		// read all contacts
		ArrayList list2 = dbhelper.getAllContacts();
		Log.d("sohail", "displayign all contacts");
		for (int i = 0; i < list2.size(); i++) {
			Log.d("sohail", list2.get(i).toString());
		}

		// update contact where number=222
		Contact toObj = new Contact();
		toObj.setNumber("222");

		Log.d("sohail","updating contact where number=222");
		Contact fromObj = new Contact("khan", "222", 123456789, false);

		dbhelper.updateObject(toObj, fromObj);

		// display all again
		// read all contacts
		ArrayList list3 = dbhelper.getAllContacts();
		Log.d("sohail", "displayign all contacts");
		for (int i = 0; i < list3.size(); i++) {
			Log.d("sohail", list3.get(i).toString());
		}
		
		dbhelper.CloseDb();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btInsert:
			// InsertRecords();
			break;
		case R.id.btShow:
			// showRecords();
			break;
		case R.id.btShowRecent:
			// showRecent();
			break;
		case R.id.btDeleteAll:
			// deleteAll();
			break;
		case R.id.btShowChecked:
			// showchecked();
			break;
		}

	}

	/*
	 * private void showRecords() { // TODO Auto-generated method stub
	 * //ObjectSet<Pilot> result=db.queryByExample(Pilot.class);
	 * 
	 * List<Pilot> list= db.query(Pilot.class); ArrayList<Pilot > arraylist= new
	 * ArrayList<Pilot>();
	 * 
	 * for(Object o:list){ System.out.println(o); arraylist.add((Pilot)o); }
	 * 
	 * String[] colums=new String[]{"name","points"}; //adapter= new
	 * SimpleCursorAdapter(this,android.l) int[] to = new int[] {
	 * R.id.tvNAME,R.id.tvID };
	 * 
	 * ArrayAdapter<Pilot> ap=new ArrayAdapter<Pilot>(this, R.layout.list_item,
	 * list);
	 * 
	 * listview.setAdapter(ap);
	 * 
	 * 
	 * }
	 * 
	 * private void InsertRecords() { // TODO Auto-generated method stub
	 * 
	 * Pilot p=new Pilot(etNAME.getText().toString(),
	 * Integer.parseInt(etID.getText().toString())); db.store(p); }
	 */
}
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
		//////////
		
		String path=  this.getDir("data", 0) + "/" + "android.db4o";
		//db= Db4oEmbedded .openFile(Db4oEmbedded.newConfiguration(),path);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btInsert:
			 InsertRecords();
			break;
		case R.id.btShow:
			 showRecords();
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

	private void showRecords() {
		// TODO Auto-generated method stub
		//ObjectSet<Pilot> result=db.queryByExample(Pilot.class);
		
		List<Pilot> list= db.query(Pilot.class);
		ArrayList<Pilot > arraylist= new ArrayList<Pilot>();
		
		for(Object o:list){
			System.out.println(o);
			arraylist.add((Pilot)o);
		}
		
		String[] colums=new String[]{"name","points"};
		//adapter= new SimpleCursorAdapter(this,android.l)
		 int[] to = new int[] { R.id.tvNAME,R.id.tvID };
		 
		 ArrayAdapter<Pilot> ap=new ArrayAdapter<Pilot>(this, R.layout.list_item, list);
		 
		 listview.setAdapter(ap);
		
		  
	}

	private void InsertRecords() {
		// TODO Auto-generated method stub
		
		Pilot p=new Pilot(etNAME.getText().toString(), Integer.parseInt(etID.getText().toString()));
		db.store(p);
	}
}
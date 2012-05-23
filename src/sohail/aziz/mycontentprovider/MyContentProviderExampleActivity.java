package sohail.aziz.mycontentprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class MyContentProviderExampleActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    Button btInsert,btDisplay,btDisplayRecent,btShowChecked,btDeleteAll;
    SimpleCursorAdapter adapter;
    ListView listview;
    Cursor cur;
    Uri recent_uri;
    EditText etID,etNAME;
    CheckBox cbStatus;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        etID= (EditText)findViewById(R.id.etID);
        etNAME= (EditText)findViewById(R.id.etNAME);
        cbStatus=(CheckBox)findViewById(R.id.cbStatus);
        
        btInsert= (Button) findViewById(R.id.btInsert);
        btDisplay=(Button)findViewById(R.id.btShow);
        btDisplayRecent=(Button)findViewById(R.id.btShowRecent);
        btShowChecked=(Button)findViewById(R.id.btShowChecked);
        btDeleteAll=(Button)findViewById(R.id.btDeleteAll);
        
        listview=(ListView)findViewById(R.id.lvList);
        
        btInsert.setOnClickListener(this);
        btDisplay.setOnClickListener(this);
        btDisplayRecent.setOnClickListener(this);
        btShowChecked.setOnClickListener(this);
        btDeleteAll.setOnClickListener(this);
        
        showRecords();
        
    }
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId()){
		case R.id.btInsert:
			InsertRecords();
			break;
		case R.id.btShow:
			showRecords();
			break;
		case R.id.btShowRecent:
			showRecent();
			break;
		case R.id.btDeleteAll:
			deleteAll();
			break;
		case R.id.btShowChecked:
			showchecked();
			break;
		}
	}
	private void showchecked() {
		// TODO Auto-generated method stub
		boolean status=true;
		String colname=MyContentDescriptor.Categories.Cols.key_3_catstatus;
		Uri uri= MyContentDescriptor.Categories.CONTENT_URI;
		String selection= MyContentDescriptor.Categories.Cols.key_3_catstatus+"=?";
		Cursor cur3=getContentResolver().query(uri, null,selection, new String[]{"true"}, null);
		Log.d("sohail",cur3.toString());
		
		adapter.changeCursor(cur3);
		
		
		
	}
	private void deleteAll() {
		// TODO Auto-generated method stub
		getContentResolver().delete(MyContentDescriptor.Categories.CONTENT_URI, null, null);
	}
	private void showRecent() {
		// TODO Auto-generated method stub
		Cursor cur2= this.getContentResolver().query(recent_uri, null, null,null, null);
		adapter.changeCursor(cur2);		
		
	}
	private void showRecords() {
		// TODO Auto-generated method stub
		
		 cur= this.getContentResolver().query(MyContentDescriptor.Categories.CONTENT_URI, null, null,null, null);
		
		String[] colums=new String[]{MyContentDescriptor.Categories.Cols.key_1_catid,MyContentDescriptor.Categories.Cols.key_2_catname};
		//adapter= new SimpleCursorAdapter(this,android.l)
		 int[] to = new int[] { R.id.tvID, R.id.tvNAME };
		 
		 adapter = new SimpleCursorAdapter(this, R.layout.list_item, cur, colums, to);

		 listview.setAdapter(adapter);
		
		 
	}
	private void InsertRecords() {
		// TODO Auto-generated method stub
		ContentValues conval=new ContentValues();
		conval.put(MyContentDescriptor.Categories.Cols.key_1_catid, etID.getText().toString() );
		conval.put(MyContentDescriptor.Categories.Cols.key_2_catname, etNAME.getText().toString());
		
		String stat;
		if(cbStatus.isChecked())
			stat="true";
		else
			stat="false";
		
		conval.put(MyContentDescriptor.Categories.Cols.key_3_catstatus,stat);
		recent_uri=getContentResolver().insert(MyContentDescriptor.Categories.CONTENT_URI, conval);
		Log.d("sohail","returned uri="+recent_uri);
		//showRecords();
		
	}
}
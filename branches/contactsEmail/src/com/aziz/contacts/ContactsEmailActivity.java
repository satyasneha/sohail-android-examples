package com.aziz.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ContactsEmailActivity extends Activity implements
		OnClickListener,OnItemSelectedListener {
	/** Called when the activity is first created. */

	private String groupName;
	private Button back;
	private Button home;
	private ArrayList<Contact> list = new ArrayList<Contact>();

	private ListView contactList;
	private Spinner myspinner;
	private Button btshow,btobject;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.e("sohail", "contacts added in list");
		
		setContentView(R.layout.main);
		
		myspinner = (Spinner)findViewById(R.id.spinner);
		btshow= (Button)findViewById(R.id.btshow);
		btobject=(Button)findViewById(R.id.btobject);
		btshow.setOnClickListener(this);
		btobject.setOnClickListener(this);

		ListView mylistview= (ListView)findViewById(R.id.contactsListViewMain);
		
		list.add(new Contact("sohail", "11111"));
		list.add(new Contact("aziz", "122222"));
		list.add(new Contact("akak", "33333333"));
		list.add(new Contact("hassan", "4444444"));
		list.add(new Contact("sohail", "66666666"));
		
		Log.e("sohail", "contacts added in list");
		Log.e("sohail", "initializing contactadapter");
		
		ContactAdapter contadapter= new ContactAdapter(this, list);
	
		Log.e("sohail", "setting contactadapter");
		//mylistview.setAdapter(contadapter);
		
		myspinner.setAdapter(contadapter);
		

		//fetching contacts
		/*
		ContentResolver cr = getContentResolver();
		Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
				null, null, null);
		cur.moveToFirst();

		if (cur.getCount() > 0) {

			do {

				String id = cur.getString(cur
						.getColumnIndex(ContactsContract.Contacts._ID));

				String name = cur
						.getString(cur
								.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

				if (Integer
						.parseInt(cur.getString(cur
								.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {

					String[] fields = {
							ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
							ContactsContract.CommonDataKinds.Phone.NUMBER };

					Cursor pCur = cr.query(
							ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
							fields,
							ContactsContract.CommonDataKinds.Phone.CONTACT_ID
									+ " = ?", new String[] { id }, null);

					pCur.moveToFirst();

					do {

						String number = pCur
								.getString(pCur
										.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

						Contact c = new Contact(name, number);

						list.add(c);

					} while (pCur.moveToNext());

					pCur.close();
				}

			} while (cur.moveToNext());

		 	*/
			
		// ContactAdapter con= new ContactAdapter(this, textViewResourceId,
			// items)
			// ContactAdapter contactAdapter=new ContactAdapter(this,
			// R.layout.contactitem, list);

		
	
			

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()){
		case R.id.btshow:
			int index= myspinner.getSelectedItemPosition();
			Toast.makeText(getApplicationContext(), list.get(index).getContactName()+list.get(index).getContactNum(), Toast.LENGTH_LONG).show();
			break;
		case R.id.btobject:
			Contact cn= (Contact) myspinner.getSelectedItem();
			Toast.makeText(getApplicationContext(), cn.getContactName()+cn.getContactNum(), Toast.LENGTH_LONG).show();
			break;
		}

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
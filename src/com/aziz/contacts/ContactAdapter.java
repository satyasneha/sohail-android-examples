package com.aziz.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ContactAdapter extends BaseAdapter{

	Context mycontext;
	ArrayList<Contact> contactsList;
	LayoutInflater mInflater;
	
	 public ContactAdapter(Context context, ArrayList<Contact> list) {
		  
		 this.mycontext=context;
		 contactsList = list;
		 mInflater = LayoutInflater.from(context);
		 
	 }
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
	//	return super.getView(position, convertView, parent);
		ContactViewHolder viewHolder;
		
		if(convertView==null){
		
			convertView= mInflater.inflate(R.layout.contactitem, parent,false);
			
			viewHolder= new ContactViewHolder();
			viewHolder.name= (TextView) convertView.findViewById(R.id.contactname);
			viewHolder.number=(TextView)convertView.findViewById(R.id.contactnum);
			convertView.setTag(viewHolder);
		}
		else
		{
			viewHolder=(ContactViewHolder) convertView.getTag();
		}
		
		Contact cont=(Contact) contactsList.get(position);
		
		viewHolder.name.setText(cont.getContactName());
		viewHolder.number.setText(cont.getContactNum());
		
		return convertView; //temporary-should be removed
		
	}

	
static class ContactViewHolder{
	
	TextView name;
	TextView number;
}


@Override
public int getCount() {
	// TODO Auto-generated method stub
	//return 0;
	
	return contactsList.size();
}


@Override
public Object getItem(int position) {
	// TODO Auto-generated method stub
	//return null;
	return contactsList.get(position);
}


@Override
public long getItemId(int position) {
	// TODO Auto-generated method stub
	return position;
}
	
	
}
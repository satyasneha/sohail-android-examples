package com.aziz.contacts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.opengl.Visibility;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ContactAdapter extends BaseAdapter {

	Context mycontext;
	ArrayList<Contact> contactsList;
	LayoutInflater mInflater;
	int Pos;

	public ContactAdapter(Context context, ArrayList<Contact> list) {

		this.mycontext = context;
		contactsList = list;
		mInflater = LayoutInflater.from(context);
		Pos = 0;

	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// return super.getView(position, convertView, parent);
		ContactViewHolder viewHolder;
		Pos = position;

		if (convertView == null) {

			convertView = mInflater
					.inflate(R.layout.contactitem, parent, false);

			viewHolder = new ContactViewHolder();
			viewHolder.name = (TextView) convertView
					.findViewById(R.id.contactname);

			viewHolder.mobileIcon = (ImageView) convertView
					.findViewById(R.id.ivMobilePhone);
			viewHolder.mobileIcon.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					Toast.makeText(mycontext,
							contactsList.get(position).getMobileNo(),
							Toast.LENGTH_SHORT).show();
				}
			});
			

			viewHolder.officeIcon = (ImageView) convertView
					.findViewById(R.id.ivOfficePhone);

			viewHolder.officeIcon.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					Log.d("sohail", "position" + position);

					Toast.makeText(mycontext,
							contactsList.get(position).getOfficeNo(),
							Toast.LENGTH_SHORT).show();
				}
			});

			viewHolder.pstnIcon = (ImageView) convertView
					.findViewById(R.id.ivPstnPhone);
			viewHolder.pstnIcon.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					Toast.makeText(mycontext,
							contactsList.get(position).getPstnNo(),
							Toast.LENGTH_SHORT).show();
				}
			});

			convertView.setTag(viewHolder);

		} else {

			viewHolder = (ContactViewHolder) convertView.getTag();
		}

		Contact cont = (Contact) contactsList.get(position);

		viewHolder.name.setText(cont.getContactName());

		if (cont.getMobileNo() != null) {

			viewHolder.mobileIcon.setVisibility(View.VISIBLE);
		}
		if (cont.getOfficeNo() != null) {

			viewHolder.officeIcon.setVisibility(View.VISIBLE);
		}
		if (cont.getPstnNo() != null) {

			viewHolder.pstnIcon.setVisibility(View.VISIBLE);
		}

		return convertView; // temporary-should be removed

	}

	static class ContactViewHolder {

		TextView name;

		ImageView mobileIcon;
		ImageView officeIcon;
		ImageView pstnIcon;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		// return 0;

		return contactsList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		// return null;
		return contactsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

}
package sohail.aziz.parcelableservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class LoginIntentService extends IntentService{

	public static final String PARAM_IN_MSG="inmsg";		//for defining extra tag
	public static final String PARAM_OUT_MSG="outmsg";
	
	public LoginIntentService() {
		super("LoginIntentService");
		// TODO Auto-generated constructor stub
		Log.d("sohail","LoginIntentService constructor");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
		Log.d("sohail","onHandleIntent");
		User obj= intent.getParcelableExtra(PARAM_IN_MSG);
		
		Log.d("Sohail","inside service:onHandleIntent, username="+ obj.getUserName());
		Log.d("Sohail","inside service:onHandleIntent, password="+ obj.getPassword());
		 
		
		
	}

}

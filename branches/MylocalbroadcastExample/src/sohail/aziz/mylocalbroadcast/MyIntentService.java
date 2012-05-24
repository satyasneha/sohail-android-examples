package sohail.aziz.mylocalbroadcast;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MyIntentService extends IntentService{

	public static final String ACTION="mycustomactionstring";
	
	public MyIntentService() {
		super("MyIntentService");
		// TODO Auto-generated constructor stub
	   Log.d("sohail","service started");
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		
		Log.d("sohail","onHandleIntent called");
		
		Intent in=new Intent(ACTION);
		Log.d("sohail","sending broadcast");
		LocalBroadcastManager.getInstance(this).sendBroadcast(in);
		
		
	}

}

package sohail.aziz.broadcastExample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService{

	public MyIntentService() {
		super("MyIntentService");
		// TODO Auto-generated constructor stub
		
		Log.d("sohail","Myintentservice constructor");
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		
		Log.d("sohail", "onHandle intent called");
		
		Intent in= new Intent();
		in.setAction("sohail.aziz");
		Log.d("sohail", "onHandleIntent: sending broadcast");
		sendBroadcast(in);
		
		
	}

}

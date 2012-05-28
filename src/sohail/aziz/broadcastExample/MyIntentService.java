package sohail.aziz.broadcastExample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

	
	public MyIntentService() {
		super("MyIntentService");
		// TODO Auto-generated constructor stub

		Log.d("sohail", "Myintentservice constructor");
		
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub

		Log.d("sohail", "onHandle intent called");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean ind = arg0.getBooleanExtra("independent", false);

		if (ind == true) { // send broadcast to independent receiver
			
			Intent in = new Intent();
			in.setAction("sohail.aziz.r2");
			in.putExtra("counter", 202);
			Log.d("sohail", "onHandleIntent: sending broadcast");
			sendBroadcast(in);

		} else {

			Intent in = new Intent();
			in.setAction("sohail.aziz");
			in.putExtra("counter", 101);
			Log.d("sohail", "onHandleIntent: sending broadcast");
			sendBroadcast(in);

		}
	}

}

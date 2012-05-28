package sohail.aziz.broadcastExample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

	int i;

	public MyIntentService() {
		super("MyIntentService");
		// TODO Auto-generated constructor stub

		Log.d("sohail", "Myintentservice constructor");
		i = 0;
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub

		Log.d("sohail", "onHandle intent called");

		while (i < 10) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Intent in = new Intent();
			in.setAction("sohail.aziz");
			in.putExtra("counter", i);
			Log.d("sohail", "onHandleIntent: sending broadcast");
			sendBroadcast(in);
			i++;
		}

	}

}

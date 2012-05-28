package sohail.aziz.broadcastExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class IndependentReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		int recval = intent.getIntExtra("counter", 0);
		Log.d("sohail", "independentreceiver: broadcast received with counter="+recval);
		
	}

}

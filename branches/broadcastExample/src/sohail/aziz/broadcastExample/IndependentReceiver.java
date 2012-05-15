package sohail.aziz.broadcastExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class IndependentReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.d("sohail","IndependentReceiver:onReceive Broadcast Received" );
	}

}

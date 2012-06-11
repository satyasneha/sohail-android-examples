package sohail.aziz.myalarmmanager;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyAlarmService extends IntentService{

	public MyAlarmService() {
		super("MyAlarmService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		
		Log.d("sohail","My alarm service called");
		
	}

}

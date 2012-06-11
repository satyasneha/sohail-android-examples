package sohail.aziz.myalarmmanager;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyAlarmanagerExampleActivity extends Activity implements
		OnClickListener {
	/** Called when the activity is first created. */
	Button  btstop;
	Button btstarts, btstarta, btstartb;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		

	
		btstop = (Button) findViewById(R.id.btStop);

		btstarta = (Button) findViewById(R.id.btStartActivity);
		btstartb = (Button) findViewById(R.id.btStartbroadcast);
		btstarts = (Button) findViewById(R.id.btStartService);

		btstarta.setOnClickListener(this);
		btstartb.setOnClickListener(this);
		btstarts.setOnClickListener(this);
		// ///////

		btstop.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.btStop:
			break;
		case R.id.btStartActivity:
			Log.d("sohail","calling startmyActivity");
			startmyActivity();
			break;
		case R.id.btStartbroadcast:
			sendmyBroadcast();
			break;
		case R.id.btStartService:
			startmyService();
			break;
		}

	}

	private void sendmyBroadcast() {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		// cal.add(Calendar.SECOND, 5);

		Intent i = new Intent(getApplicationContext(), MyBroadcastReceiver.class);
		i.setAction("my.broadcast.action");

		PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(),
				1111, i, PendingIntent.FLAG_CANCEL_CURRENT);

		AlarmManager am = (AlarmManager) getSystemService(this.ALARM_SERVICE);

		// am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
		//send broadcast  every 10 (approx) seconds
		am.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 10000, pi);

		Log.d("sohail", "alarm set will be called in 5 seconds");
		
	}

	private void startmyService() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		Calendar cal = Calendar.getInstance();
		// cal.add(Calendar.SECOND, 5);

		Intent i = new Intent(getApplicationContext(), MyAlarmService.class);

		PendingIntent pi = PendingIntent.getService(getApplicationContext(),
				2222, i, PendingIntent.FLAG_CANCEL_CURRENT);

		AlarmManager am = (AlarmManager) getSystemService(this.ALARM_SERVICE);

		// am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
		//start service every 10 seconds
		am.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 10000,
				pi);

		Log.d("sohail", "alarm set will be called in 5 seconds");

	}

	private void startmyActivity() {
		// TODO Auto-generated method stub

	
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 5);

		Intent i = new Intent(getApplicationContext(), SecondActivity.class);
		PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 3333, i,
				0);
		
		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		//start activity after 5 seconds, just once
		am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(), pi);
		Log.d("sohail", "activity will be started in 5 seconds");

	}

}
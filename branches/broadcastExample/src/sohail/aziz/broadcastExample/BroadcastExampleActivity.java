package sohail.aziz.broadcastExample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BroadcastExampleActivity extends Activity implements
		OnClickListener {
	/** Called when the activity is first created. */
	private Myreceiver reMyreceive;
	private IntentFilter filter;
	TextView tvMessage;
	Button btPause,btIpause;

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		//comment this inorder to verify receiver running in pause state
		unregisterReceiver(reMyreceive);
		Log.d("sohail","BroadcastExampleActivity onpause called");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		//comment this inorder to verify receiver running in pause state
		 registerReceiver(reMyreceive, filter);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Log.d("sohail", "onCreate called");

		btPause = (Button) findViewById(R.id.btPause);
		btIpause=(Button)findViewById(R.id.btIpause);
		tvMessage = (TextView) findViewById(R.id.tvBroadcast);
		
		btPause.setOnClickListener(this);
		btIpause.setOnClickListener(this);

		reMyreceive = new Myreceiver();
		filter = new IntentFilter("sohail.aziz");
	//	registerReceiver(reMyreceive, filter);

	

	}

	public class Myreceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub


			int recval = intent.getIntExtra("counter", 0);
			Log.d("sohail", "MyReceiver running inside activity: broadcast received with counter="+recval);
		//	tvMessage.setText(recval);

		}

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.btPause:
			
			Intent i = new Intent(this, MyIntentService.class);
			//send broadcast to activity's receiver
			i.putExtra("independent", false);
			Log.d("sohail", "starting MyIntentservice");
			startService(i);

			//just to pause  current activity
			Intent ii = new Intent(getApplicationContext(),
					receiverActivity.class);
			startActivity(ii);
			break;
			
		case R.id.btIpause:
			
			Intent j=new Intent(this,MyIntentService.class);
			//send broadcast to independent receiver
			j.putExtra("independent",true);
			startService(j);
			
			break;
		}

	}
}
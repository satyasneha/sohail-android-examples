package sohail.aziz.mylocalbroadcast;

import java.util.Date;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MylocalbroadcastExampleActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
   	
	TextView tv;
	Button bt;
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		LocalBroadcastManager.getInstance(this).unregisterReceiver(onNotice);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		IntentFilter iff= new IntentFilter(MyIntentService.ACTION);
		LocalBroadcastManager.getInstance(this).registerReceiver(onNotice, iff);
	}
	
	private BroadcastReceiver onNotice= new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Log.d("sohail","onReceive called");
			tv.setText(new Date().toString());
			
		}
	};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tv=(TextView)findViewById(R.id.tvResults);
        
        bt= (Button)findViewById(R.id.btStart);
        bt.setOnClickListener(this);
        
        
        
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v.getId()==R.id.btStart){
			
			Log.d("sohail","starting service");
			Intent i= new Intent(this, MyIntentService.class);
			startService(i);
		}
	}
}
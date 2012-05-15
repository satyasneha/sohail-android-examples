package sohail.aziz.broadcastExample;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class BroadcastExampleActivity extends Activity {
    /** Called when the activity is first created. */
    private Myreceiver reMyreceive;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.d("sohail", "onCreate called");
       
        reMyreceive=new Myreceiver();
        IntentFilter filter=new IntentFilter("sohail.aziz");
        
        registerReceiver(reMyreceive, filter);
        
        Intent i= new Intent(this,MyIntentService.class);
        Log.d("sohail", "starting MyIntentservice");
        startService(i);
    }
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	unregisterReceiver(reMyreceive);
    };
    
    public class Myreceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			Log.d("sohail", "MyReceiver: broadcast received");
		}
    	
    }
}
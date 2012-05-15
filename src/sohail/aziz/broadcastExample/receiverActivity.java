package sohail.aziz.broadcastExample;

import android.Manifest.permission;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class receiverActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		Log.d("sohail","receiverAtivity :oncreate");
		Intent intnt=new Intent();
		intnt.setAction("sohail.aziz.r2");
		Log.d("sohail","receiverAtivity :Sending Broadcast");
		sendBroadcast(intnt,"MYPERMISSION");
		
		
		
	}
	
	
}

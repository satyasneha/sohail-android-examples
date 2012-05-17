package sohail.aziz.singletonapplicationexample;

import android.app.Application;
import android.util.Log;

public class MyApplication extends Application {

	
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		Log.d("sohail","MyApplication terminated");
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		Log.d("sohail","MyApplication created, calling initSingleton");
		initSingleton();
	}

	private void initSingleton() {
		// TODO Auto-generated method stub
		MySingleton.initInstance();
		
	}

	
}

package sohail.aziz.singletonapplicationexample;

import android.util.Log;

public class MySingleton {

	private static MySingleton instance;
	private static String name;
	
	private MySingleton(){
				name=null;
				Log.d("sohail","MySingleton constructor called");
	}
	public static void initInstance(){
		
		Log.d("sohail","initInstance called");
		if(instance==null){
			instance=new MySingleton();
			Log.d("sohail","initInstance called: new instance created");
		}
	}
	
	public static MySingleton getInstance(){
		return instance;
	}
	
	public String getAppName(){
		return name;
	}
	
	public void setAppName(String nam){
		name=nam;
	}
	
	
}

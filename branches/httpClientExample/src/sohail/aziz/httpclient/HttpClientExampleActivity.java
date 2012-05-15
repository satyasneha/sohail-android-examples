package sohail.aziz.httpclient;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class HttpClientExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		
		
		
		String url="http://....";
		String username="abc";
		String password="def";
		
		RestClient client = new RestClient(url);
		client.AddParam("username", username);
		client.AddParam("password", password);
		
		try{
			client.Execute(RequestMethod.GET);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String response= client.getResponse();
		Log.d("sohail",response); //jason response
		
		
    }
}
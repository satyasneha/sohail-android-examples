package sohail.aziz.parcelableservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginServiceExampleActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	   EditText etUname;
	   EditText etPassword;
	   Button btLogin;
	   
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EditText etUname=(EditText)findViewById(R.id.etEmail);
        EditText etPassword=(EditText)findViewById(R.id.etPassword);
       
        Button btLogin=(Button)findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);
               
        
       
              
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		
		case R.id.btLogin:
			Log.d("sohail", "inside on click");
		
		//	String strUname=etUname.getText().toString();
		//	String strPass= etPassword.getText().toString();
			
			User uObj= new User("sohail", "pass");
			Log.d("sohail", "inside on click:before creating new intent");
			
			
			Intent in = new Intent(this,LoginIntentService.class);
			
			Log.d("sohail", "inside on click:before putting in.putextra");
			in.putExtra(LoginIntentService.PARAM_IN_MSG, uObj);
			
			Log.d("sohail", "inside on click:before starting service");
			startService(in);
			finish();
			
			break;
		}
		
	}
}
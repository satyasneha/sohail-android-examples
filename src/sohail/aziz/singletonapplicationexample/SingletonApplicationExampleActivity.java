package sohail.aziz.singletonapplicationexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SingletonApplicationExampleActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    Button bt;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        bt=(Button)findViewById(R.id.btClickme);
        bt.setOnClickListener(this);
        
        Log.d("sohail","calling mysingleton.setname");
        MySingleton.getInstance().setAppName("sohail application");
        
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId()){
		case R.id.btClickme:
			Log.d("sohail",MySingleton.getInstance().getAppName());
			break;
		}
		
	}
}
package sohail.aziz.progressexample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProgressExampleActivity extends Activity implements
		OnClickListener {
	/** Called when the activity is first created. */
	Button btProgress;
	ProgressDialog progressBar;
	private Handler progressBarhandler = new Handler();
	private int progressBarstatus = 0;
	private long fileSize = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btProgress = (Button) findViewById(R.id.bProgress);
		btProgress.setOnClickListener(this);
		
	
	}

	private int doSomeTasks() {
		// TODO Auto-generated method stub

		while (fileSize <= 1000000) {

			fileSize++;

			if (fileSize == 100000) {
				return 10;
			} else if (fileSize == 200000) {
				return 20;
			} else if (fileSize == 300000) {
				return 30;
			}
			// ...add your own

		}

		return 100;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {

		case R.id.bProgress:

			progressBar = new ProgressDialog(arg0.getContext());
			progressBar.setCancelable(false);
			progressBar.setMessage("Loading...");
			progressBar.setProgress(0);
			progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			// progressBar.setMax(100);
			progressBar.show();

			progressBarstatus = 0;

			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while (progressBarstatus < 100) {

						progressBarstatus = doSomeTasks();

						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						progressBarhandler.post(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub

								progressBar.setProgress(progressBarstatus);

							}
						});
					}

					if (progressBarstatus >= 100) {

						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						progressBar.dismiss();
					}

				}

			}).start();

			break;
		}

	}
}
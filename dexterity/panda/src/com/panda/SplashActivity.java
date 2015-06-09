package com.panda;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity implements Runnable {
	static int score1;
	long levelStartMillis1,currentTimeMillis;
	Thread t;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		 t = new Thread(this);
		Calendar cal = Calendar.getInstance();
		levelStartMillis1 = cal.getTime().getTime();
		t.start();
	}

	public void run() {
		System.out.println(currentTimeMillis);
		System.out.println(levelStartMillis1);
		while((currentTimeMillis-levelStartMillis1)<5000){
			System.out.println(currentTimeMillis);
			System.out.println(levelStartMillis1);
			Calendar c = Calendar.getInstance();
			 currentTimeMillis = c.getTime().getTime();
			 
			
		}
		startActivity(new Intent(this, panda.class));
		
	}
}


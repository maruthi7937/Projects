package com.panda;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;

public class panda extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
 Button b,b1,b2,b3;
MediaPlayer bgmusic;
    static int counter=0;
    String sound;
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.mainn2);
        bgmusic=MediaPlayer.create(this, R.raw.back);
        
        bgmusic.start();
        bgmusic.setLooping(true);
        b=(Button)findViewById(R.id.Button01); 
        b.setOnClickListener(this);
        b1=(Button)findViewById(R.id.Button02); 
        b1.setOnClickListener(this);
       b2=(Button)findViewById(R.id.Button03); 
        b2.setOnClickListener(this);
        b3=(Button)findViewById(R.id.Button04); 
        b3.setOnClickListener(this);
        
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
    		counter++;
    	    Panda2.c=counter;
    		Panda2.startRing = true;
    		System.out.println("In key down;;;;;;;;;;;;;;;;;;;;");
    	}
    	if(keyCode == KeyEvent.KEYCODE_DPAD_DOWN){
    		GameThread.isGameRunning = false;
    		counter=0;
    		Panda2.c=counter;
    		System.out.println("Game ended;;;;;;;;;;;;;;;;;;;");
    		setContentView(R.layout.mainn2);
    		
    		 b=(Button)findViewById(R.id.Button01); 
    	        b.setOnClickListener(this);
    	        b1=(Button)findViewById(R.id.Button02); 
    	        b1.setOnClickListener(this);
    	        b2=(Button)findViewById(R.id.Button03); 
    	        b2.setOnClickListener(this);
    	        b3=(Button)findViewById(R.id.Button04); 
    	        b3.setOnClickListener(this);      
    	}
    	return super.onKeyDown(keyCode, event);  
    	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 
		if(b==v){
		
		GameThread.isGameRunning = true;
		setContentView(new Panda2(this));
		}
		else if(b1==v){
			
			setContentView(R.layout.instruction);
		}
		else if(b2==v){
			
			setContentView(R.layout.about);
		}
		else if(b3==v){
		sound=(String)b3.getText();
		if(sound.equals("Mute")){
		bgmusic.pause();
		b3.setText("Unmute");
		}
		else{
			bgmusic.start();
			b3.setText("Mute");
			
		
		}
		}
	
	
	
	}



}

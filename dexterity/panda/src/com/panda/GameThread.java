package com.panda;


import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	Panda2 gameview;
	SurfaceHolder surfaceholder;
	static boolean isGameRunning=true;
    public GameThread(Panda2 view,SurfaceHolder holder){
    gameview=view;
    surfaceholder=holder;
}
	
	public void run(){
		while(isGameRunning){
		Canvas c= surfaceholder.lockCanvas();
		gameview.onDraw(c);
		surfaceholder.unlockCanvasAndPost(c);
		try{
			Thread.sleep(1000/20);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	}
}



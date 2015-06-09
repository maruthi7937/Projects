package com.panda;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class Sprite {

	private Bitmap image;
	private int framewidth;
	private int frameheight;
	int fnu;
	private int x=10;
	private int y=100;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setFrameNumber(int fnum){
		this.fnu=fnum;
	}
	public Sprite(Bitmap image,int framewidth,int frameheight){
		this.framewidth=framewidth;
		this.frameheight=frameheight;
		this.image=image;
	}
	public void draw(Canvas canvas)
	{
		Paint paint=new Paint();
		Rect srcRect=new Rect((framewidth*fnu),0,((framewidth*fnu)+framewidth),frameheight);
		RectF destRect=new RectF(x,y,x+framewidth,y+frameheight);
		canvas.drawBitmap(image,srcRect,destRect,paint);
		System.out.println("in draw sprite......");
	}
}

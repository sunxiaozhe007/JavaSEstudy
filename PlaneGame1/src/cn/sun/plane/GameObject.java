package cn.sun.plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {

	Image plane ;
	double x,y;
	int speed = 10;
	int width,height;
	
	public Rectangle getRect() {
		return  new Rectangle((int)x,(int)y,width,height);
	
	}

	public GameObject(Image plane, double x, double y, int width, int height) {
		super();
		this.plane = plane;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public GameObject() {
		
	}
	
	
	
}

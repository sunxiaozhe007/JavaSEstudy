package cn.sun.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
	private boolean left,up,right,down;
	private int speed = 30;
	private boolean live = true;
	private Image img;

	public void draw(Graphics g) {
		if(live){
			
		g.drawImage(img,(int) x,(int) y, null);
		move();
		
		}
	}
	
	
	public void move() {
		if(left) {
			x -= speed;
		}
		if(right) {
			x += speed;
		}
		if(up) {
			y -= speed;
		}
		if(down) {
			y += speed;
		}
		/*switch (e.getKeyCode()) {
		
		case 37 :
			x -=30;
			break;
		case 38 :
			y -=30;
			break;
		case 39 :
			x +=30;
			break;
		case 40 :
			y +=30;
			break;
		}*/
	}
	public void addDir(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37 :
			left = true;
			break;
		case 38 :
			up = true;
			break;
		case 39 :
			right = true;
			break;
		case 40 :
			down = true;
			break;
		default :
			break;
		}
		
	}
	public void min(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37 :
			left = false;
			break;
		case 38 :
			up = false;
			break;
		case 39 :
			right = false;
			break;
		case 40 :
			down = false;
			break;
		default :
			break;
		}
	}


	
	public Plane(String imgpath, double x, double y, Image img) {

		this.img = GameUtil.getImage(imgpath);
		this.width = img.getWidth(null);
		this.width = 30;
		this.height = 30;
		this.x = x;
		this.y = y;

	}
	public Plane() {
		
	}


	public boolean isLive() {
		return live;
	}


	public void setLive(boolean live) {
		this.live = live;
	}
}

package cn.sun.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;



public class Bullet extends GameObject {

	double degree;
	int speed = 5;
	
	public Bullet() {
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_HEIGHT/2;
		y = Constant.GAME_WIDTH/2;
		width = 10;
		height = 10;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		
		g.fillOval((int)x,(int) y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y>Constant.GAME_HEIGHT-height||y<30) {
			degree = -degree;
		}
		if(x<0||x>Constant.GAME_WIDTH-width) {
			degree = Math.PI-degree;
		}
		
		
		g.setColor(c);
          		
	}

}

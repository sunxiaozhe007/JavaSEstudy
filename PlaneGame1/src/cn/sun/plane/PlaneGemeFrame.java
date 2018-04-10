package cn.sun.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.print.attribute.standard.PrinterInfo;
import javax.print.attribute.standard.PrinterMoreInfo;

public class PlaneGemeFrame extends MyGameFrame{
	
	/**
	 * 
	 */
	Image bg = GameUtil.getImage("images/bg.png");
	Plane p = new Plane("images/我的飞机1.jpg", 50, 50, bg);
	ArrayList bulletList = new ArrayList();
	
	Date startTime;
	Date endTime;
	
	Explode baozha;
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		
		for(int i = 0;i<bulletList.size();i++) {
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//检测碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng) {
				p.setLive(false);
				if(endTime==null){
					endTime = new Date();
					if(baozha==null) {
					
					 baozha = new Explode(p	.x, p.y);
					}
					baozha.draw(g);
					break;
					}
				}
		}
		if(!p.isLive()) {
		  
			int period = (int) ((endTime.getTime() - startTime.getTime())/1000);
			  Gameover(g, "时间:"+period+"秒", 40, 320, 450, Color.black);
			  
			  switch (period/10) {
			case 0:
				Gameover(g,"智障",200,200,350,Color.BLACK);
				break;
			case 1:
				Gameover(g,"手残",100,397,200,Color.BLACK);
				break;
			case 2:
				Gameover(g,"大神",100,397,200,Color.BLACK);
				break;

			default:
				Gameover(g,"超神",100,397,200,Color.BLACK);
				break;
			}
		}
		
		 // Gameover(g,"分数100",10,50,50,Color.BLACK);
	}
	/**
	 * 死亡信息
	 * @param g
	 * @param str
	 * @param size
	 */
	public void Gameover(Graphics g,String str,int size,int x,int y,Color color) {
		
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("仿宋",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str, x,y);
		g.setColor(c);
	}
	
	public static void main(String[] args) {
		new PlaneGemeFrame().launchFrame();
	
	}
	public void launchFrame() {
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());

		//生成一堆子弹
		for(int i = 0; i<30;i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
	}
	//定义为内部类，可以方便使用外部类的普通属性
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("按下："+e.getKeyCode());
			p.addDir(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("释放："+e.getKeyCode());
			p.min(e);
			}
		
		}
		
	}


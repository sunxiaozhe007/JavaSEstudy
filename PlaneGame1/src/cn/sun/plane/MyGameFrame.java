package cn.sun.plane;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 窗口界面
 * @author Administrator
 *
 */
public class MyGameFrame extends Frame {//GUI编程：AWT,swing等。
	
	Image img = GameUtil.getImage("images/datou.jpg");
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(100, 100);
		setVisible(true);
		
		
		new PaintThread().start();//启动线程
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		
		});
	}
	private double x=100,y=100;
	private double degree=3.14/3;
	@Override
	public void paint(Graphics arg0) {
		arg0.drawImage(img,(int) x,(int) y, null);
       

		x =100 + 100*Math.cos(degree);
		y =200 + 50*Math.sin(degree); 

		degree += 0.1;
	}
	//双缓冲
	private Image iBuffer;  
	private Graphics gBuffer;
	public void update(Graphics scr)  
	{  
	    if(iBuffer==null)  
	    {  
	       iBuffer=createImage(this.getSize().width,this.getSize().height);  
	       gBuffer=iBuffer.getGraphics();  
	    }  
	       gBuffer.setColor(getBackground());  
	       gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);  
	       paint(gBuffer);  
	       scr.drawImage(iBuffer,0,0,this);  
	}  
	
	
	/**
	 * 定义一个重划窗口的线程类，内部类
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		MyGameFrame gf = new MyGameFrame();
		gf.launchFrame();
	}
}


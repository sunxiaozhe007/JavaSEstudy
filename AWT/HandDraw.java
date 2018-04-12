package AWT;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;


/**
 * 简单的画图板
 * @author Administrator
 *
 */
public class HandDraw {
	//画板的高度和宽度
	private final int AREA_WIDTH = 500;
	private final int AREA_HEIGHT = 500;
	private int preX = -1;
	private int preY = -1;
	//定义一个鼠标右键菜单用于改变颜色
	PopupMenu pop = new PopupMenu();
	MenuItem redItme = new MenuItem("红色");
	MenuItem greenItme = new MenuItem("绿色");
	MenuItem blueItme = new MenuItem("蓝色");
	BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_BGR);
	Graphics g = image.getGraphics();
	private Frame f = new Frame("画板");
    private DrawCanvas drawArea = new DrawCanvas();
    //保存笔画颜色
	private Color foreColor = new Color(255, 0, 0);
	public void init() {
		//右键自定义事件监听器
		ActionListener menuListener = e ->{
			if (e.getActionCommand().equals("绿色")) {
				foreColor = new Color(0 , 255 , 0);
			}
			if (e.getActionCommand().equals("红色")) {
				 foreColor = new Color(255 , 0 , 0);
			}
			if (e.getActionCommand().equals("蓝色")) {
				foreColor  = new Color(0 , 0 , 255);
			}
		};
		//给三个菜单添加事件监听器
		redItme.addActionListener(menuListener);
		greenItme.addActionListener(menuListener);
		blueItme.addActionListener(menuListener);
		//整合到右键菜单上
		pop.add(redItme);
		pop.add(greenItme);
		pop.add(blueItme);
		//将菜单添加到drawArea对象中
		drawArea.add(pop);
		//将背景设为白色
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
		//监听鼠标移动动作
		drawArea.addMouseMotionListener(new MouseMotionAdapter() {
			//实现按下鼠标并拖动的事件处理器
			public void mouseDragged(MouseEvent e) {
				if (preX > 0 && preY > 0) {
					//设置当前颜色
					g.setColor(foreColor);
					//绘制两次鼠标动作之间的线
					g.drawLine(preX, preY, e.getX(), e.getY());
				}
				//保存当前鼠标动作的坐标
				preX = e.getX();
				preY = e.getY();
				//重划
				drawArea.repaint();
			}
		});
		//监听鼠标事件
		drawArea.addMouseListener(new MouseAdapter() {
			//实现鼠标松开的事件处理器
			public void mouseReleased(MouseEvent e) {
				//弹出右键菜单
				if(e.isPopupTrigger()) {
					pop.show(drawArea, e.getX(), e.getY());
				}
				//松开鼠标时把上次动作设为-1
				preX = -1;
				preY = -1;
			}
		});
		f.add(drawArea);
		f.pack();
		f.setVisible(true);
	}
	
	class DrawCanvas extends Canvas{
		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, null);
			
		}
	}
	
	public static void main(String[] args) {
		new HandDraw().init();
	}
	
}
	

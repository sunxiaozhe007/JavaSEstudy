package AWT;
/**
 * 简单的弹球游戏
 * @author Administrator
 *
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.Timer;

public class BallGameTest {
	//桌子的宽和高
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	//球拍的初始高度
	private final int RACKET_Y = 340;
	//球拍的宽和高
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 60;
	//球的大小（正方形内切）
	private final int BALL_SIZE = 16;
	private final Frame f = new Frame("弹球游戏");
	Random rand = new Random();
	//小球Y轴速度
	private int ySpeed = 20;
	//返回-0.5--0.5的比率控制小球方向
	private double xyRate = rand.nextDouble() - 0.5;
	//小球X轴速度
	private int xSpeed = (int) (ySpeed*xyRate*2);
	//小球坐标
	private int ballY = rand.nextInt(200) + 20;
	private int ballX = rand.nextInt(10) + 20;
	//球拍X轴位置
	private int racketX = rand.nextInt(200);
	private MyCanvas tableArea = new MyCanvas();
	Timer timer;
	//判断游戏是否结束
	private boolean isLose = false;
	public void init() {
		//设置桌面大小
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		f.add(tableArea);
		//键盘监听
		KeyAdapter keyProcessor = new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				//按下键盘左右键时对应的球拍X轴坐标的变化
				if(ke.getKeyCode()==KeyEvent.VK_LEFT) {
					if(racketX > 0)
						racketX-= 30;
				}
				if (ke.getKeyCode()==KeyEvent.VK_RIGHT) {
					if(racketX < TABLE_WIDTH - RACKET_WIDTH)
						racketX+=30;
				}
			}
		};
		//窗口和桌面增加键盘监听
		f.addKeyListener(keyProcessor);
		//每0.1秒执行一次事件监听器
		tableArea.addKeyListener(keyProcessor);
		ActionListener taskPerformer = evt ->
		{
			//小球碰到左面边框弹回
			if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
				xSpeed = -xSpeed;
			}
			//Y轴坐标超出球拍Y轴坐标位置，且X轴不在球拍范围内，结束游戏
			if (ballY >= RACKET_Y - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
				 timer.stop();
				 isLose = true;
				 tableArea.repaint();
			}
			//如果小球Y轴坐标没有超出球拍Y轴坐标位置，且X轴在球拍范围内，小球反弹
			else if (ballY <= 0 || (ballY >= RACKET_Y - BALL_SIZE && ballX > racketX && ballX <= racketX + RACKET_WIDTH)) {
				ySpeed = -ySpeed;
			}
			//小球坐标增加
			ballY += ySpeed;
			ballX += xSpeed;
			tableArea.repaint();
		};
		//
		timer = new Timer(100, taskPerformer);
		timer.start();
		f.pack();
		f.setVisible(true);
	}
	
	
	class MyCanvas extends Canvas{
		public void paint(Graphics g){
			//游戏结束打印提示
			if(isLose) {
				//设置字体颜色和位置
				g.setColor(new Color(255, 0, 0 ));
				g.setFont(new Font("Times", Font.BOLD, 30));
				g.drawString("GAME  OVER", 50, 200);
			}
			//如果游戏未结束
			else
			{
				//设置颜色绘制小球
				g.setColor(new Color(240, 240, 80));
				g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
				//绘制球拍
				g.setColor(new Color(80, 80, 200));
				g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new BallGameTest().init();
	}
	
	
}

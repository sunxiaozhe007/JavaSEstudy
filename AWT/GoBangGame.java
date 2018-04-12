package AWT;
/**
 * 五子棋游戏
 * @author Administrator
 *
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.datatransfer.Clipboard;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GoBangGame {
	BufferedImage table;
	BufferedImage black;
	BufferedImage white;
	BufferedImage selected;
	private static int BOARD_SIZE = 15;
	private final int TABLE_WIDTH = 800;
	private final int TABLE_HEIGHT = 800;
	private final int RATE = TABLE_WIDTH / BOARD_SIZE;
	private final int X_OFFSET = 5;
	private final int Y_OFFSET = 6;
	private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
	JFrame f = new JFrame("五子棋游戏");
	ChessBoard chessBoard = new ChessBoard();
	private int selectedX = -1;
	private int selectedY = -1;
	
	
	public void init() throws Exception {
		table = ImageIO.read(new File("D:\\JAVA文件\\AWT\\src\\AWT\\image\\timg1.png"));
		black = ImageIO.read(new File("D:\\JAVA文件\\AWT\\src\\AWT\\image\\black1.png"));
		white = ImageIO.read(new File("D:\\JAVA文件\\AWT\\src\\AWT\\image\\white1.png"));
		selected = ImageIO.read(new File("D:\\JAVA文件\\AWT\\src\\AWT\\image\\timg1.png"));
		for(int i = 0; i < BOARD_SIZE ; i++) {
			for(int j = 0; j < BOARD_SIZE ; j++) {
				board[i][j] = "┼";
			}
		}
		chessBoard.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		chessBoard.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int xPos = (int) ((e.getX() - X_OFFSET) / RATE);
				int yPos = (int) ((e.getY() - Y_OFFSET) / RATE);
				board[xPos][yPos] = "●";
				chessBoard.repaint();
			}
			public void mouseExited(MouseEvent e) {
				selectedX = -1;
				selectedY = -1;
				chessBoard.repaint();
			}
		});
		chessBoard.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				selectedX = ((e.getX() - X_OFFSET) / RATE);
				selectedX = ((e.getY() - Y_OFFSET) / RATE);
				chessBoard.repaint();
			}
		});
		
		f.add(chessBoard);
		f.pack();
		f.setVisible(true);
	}
	class ChessBoard extends JPanel{
		public void paint (Graphics g) {
			g.drawImage(table, 0, 0, null);
			if (selectedX >= 0 && selectedY >=0) 
				g.drawImage(selected, selectedX * RATE + X_OFFSET, selectedY * RATE + Y_OFFSET, null);
				
				for(int i = 0; i < BOARD_SIZE ; i++) {
					for(int j = 0; j < BOARD_SIZE ; j++) {

					if(board[i][j].equals("●")) {
						g.drawImage(black, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
					}
					if (board[i][j].equals("○")) {
						g.drawImage(white, i * RATE + X_OFFSET, j * RATE + Y_OFFSET, null);
						
					}
				}
				
			}
		}
	}
	public static void main(String[] args) throws Exception {
		GoBangGame gb = new GoBangGame();
		gb.init();
		
	}
}

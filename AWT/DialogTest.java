package AWT;
/**
 * 模式对话框和非模式对话框
 */
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;

import javax.swing.JButton;

public class DialogTest {
	Frame f = new Frame();
	Dialog d1 = new Dialog(f,"模式对话框",true);
	Dialog d2 = new Dialog(f,"非对话框模式",false);
	JButton b1 = new JButton("打开对话框模式");
	JButton b2 = new JButton("打开非对话框模式");
	public void init() {
		d1.setBounds(100,100,500,500);
		d2.setBounds(20,30,500,500);
		b1.addActionListener(e -> d1.setVisible(true));
		b2.addActionListener(e -> d2.setVisible(true));
		f.add(b1);
		f.add(b2,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new DialogTest().init();
	}

}

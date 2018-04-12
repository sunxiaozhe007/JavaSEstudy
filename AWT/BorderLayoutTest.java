package AWT;
/**
 * BorderLayoutTest布局管理器
 */
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;

public class BorderLayoutTest {
	public static void main(String[] args) {
		Frame f = new Frame("测试");
		Panel p = new Panel();
		p.add(new TextField(20));
		p.add(new JButton("单击"));
		//设置Frame容器使用BorderLayoutTest布局管理器
		f.setLayout(new BorderLayout(200,200));
		f.add(new JButton("南"),BorderLayout.SOUTH);
		f.add(new JButton("北"),BorderLayout.NORTH);
		f.add(p);
		f.add(new JButton("东"),BorderLayout.EAST);
		f.add(new JButton("西"),BorderLayout.WEST);
		//窗口最佳
		f.pack();
		f.setVisible(true);
	}


}

package AWT;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;

/*
 * FlowLayout布局管理器
 */
public class FlowLayoutTest {
	public static void main(String[] args) {
		Frame f = new Frame("测试窗口");
		//设置Frame容器使用FlowLayout布局管理器
		f.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		//窗口中添加10个按钮
		for (int i = 0; i < 10; i++) {
			f.add(new JButton("按钮"+i));
		}
		f.pack();
		f.setVisible(true);
	}

}

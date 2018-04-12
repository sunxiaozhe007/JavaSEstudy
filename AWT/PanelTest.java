package AWT;
/**
 * 添加Panel组件
 */
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;

public class PanelTest {
	public static void main(String[] args) {
		Frame f = new Frame("测试窗口");
		//创建Panel容器
		Panel p = new Panel();
		//添加组件
		p.add(new TextField(20));
		p.add(new JButton("单机此处"));
		//将Panel容器添加到窗口
		f.add(p);
		f.setBounds(50, 50, 200, 200);
		f.setVisible(true);
		
	}

}

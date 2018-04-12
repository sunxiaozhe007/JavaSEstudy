package AWT;
/**
 * 设置滚动条
 */
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.TextField;

import javax.swing.JButton;


public class ScrollPaneTest {
	public static void main(String[] args) {
		Frame f = new Frame("测试窗口");
		ScrollPane p = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		p.add(new JButton("单击"));
		p.add(new TextField(20));
		f.add(p);
		f.setBounds(50, 50, 200, 200);
		f.setVisible(true);
	}

}

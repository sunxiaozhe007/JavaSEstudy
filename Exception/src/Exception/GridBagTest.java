package Exception;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;

public class GridBagTest {
	private Frame f = new Frame("测试");
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gb1 = new GridBagConstraints();
	private JButton[] bs = new JButton[10];
	public void init() {
		f.setLayout(gb);
		for(int i = 0; i < bs.length; i++) {
			bs[i] = new JButton("按钮"+i);
		}
		gb1.fill = GridBagConstraints.BOTH;
		gb1.weightx = 1;
		
	}

}

package Swing;
/**
 * Panel容器添加边框
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class BorderTest {
	private JFrame jf = new JFrame("测试边框");
	public void init() {
		jf.setLayout(new GridLayout(2, 4));
		//使用静态工厂方法创建BevelBorder
		Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED , Color.RED , Color.GREEN , Color.BLUE, Color.GRAY);
		jf.add(getPanelWithBorder(bb, "BevelBorder"));
		Border lb = BorderFactory.createLineBorder(Color.orange , 10);
		//使用静态工厂方法创建LineBorder
		jf.add(getPanelWithBorder(lb, "LineBorder"));
		Border eb = BorderFactory.createEmptyBorder(20, 5, 10, 30);
		//使用静态工厂方法创建EmptyBorder
		jf.add(getPanelWithBorder(eb, "EmptyBorder"));
		Border etb = BorderFactory.createEtchedBorder(EtchedBorder.RAISED , Color.RED , Color.GREEN);
		//使用静态工厂方法创建EtchedBorder
		jf.add(getPanelWithBorder(etb, "EtchedBorder"));
		TitledBorder tb = new TitledBorder(lb , "测试标题"  , TitledBorder.LEFT , TitledBorder.BOTTOM , new Font("StSong", Font.BOLD, 18) , Color.BLUE);
		jf.add(getPanelWithBorder(tb, "TitledBorder"));
		MatteBorder mb = new MatteBorder(20, 5 , 10 , 30 , Color.GREEN);
		jf.add(getPanelWithBorder(mb, "MatteBorder"));
		CompoundBorder cb = new CompoundBorder(new LineBorder(Color.RED , 8), tb);
		jf.add(getPanelWithBorder(cb, "CompoundBorder"));
		jf.pack();
		jf.setVisible(true);
	}
	
	public JPanel getPanelWithBorder(Border b , String BorderName) {
		JPanel p = new JPanel();
		p.add(new JLabel(BorderName));
		//为Panel组件设置边框
		p.setBorder(b);
		return p;
	}
	public static void main(String[] args) {
		new BorderTest().init();
	}
	

}

package AWT;
/**
 * 鼠标右键菜单实现
 * @author Administrator
 *
 */

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PopupMenuTest {
	private TextArea ta = new TextArea(4,30);
	private Frame f = new Frame();
	PopupMenu pop = new PopupMenu();
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
	MenuItem copyItem = new MenuItem("复制");
	MenuItem pasteItem = new MenuItem("粘贴");
	Menu format = new Menu("格式");
	MenuItem commenItem = new MenuItem("注释",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem cancelItem = new MenuItem("取消注释");
	public void init() {
		ActionListener menuListener = e ->{
			String cmd = e.getActionCommand();
			ta.append("单击"+cmd+"菜单"+"\n");
			if (cmd.equals("退出")) {
				System.exit(0);
			}
		};
		
		commenItem.addActionListener(menuListener);
		pop.add(autoWrap);
		pop.add(copyItem);
		pop.add(pasteItem);
		format.add(commenItem);
		format.add(cancelItem);
		pop.add(new MenuItem("-"));
		pop.add(format);
		final Panel p = new Panel();
		p.setPreferredSize(new Dimension(300, 160));
		p.add(pop);
		p.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()) {
					pop.show(p, e.getX(),e.getY() );
				}
			}
		});
		f.add(p);
		f.add(ta,BorderLayout.NORTH);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new PopupMenuTest().init();
	}
	
	

}

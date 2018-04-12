package AWT;
/**
 * 为窗口添加菜单
 * @author Administrator
 *
 */

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class SimpleMenu {
	private Frame f = new Frame("test");
	private MenuBar mb = new java.awt.MenuBar();
	Menu file = new Menu("文件");
	Menu edit = new Menu("编辑");
	MenuItem newItem = new MenuItem("新建");
	MenuItem saveItem = new MenuItem("保存");
	MenuItem exitItem = new MenuItem("退出");
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
	MenuItem copyItem = new MenuItem("复制");
	MenuItem pasteItem = new MenuItem("粘贴");
	Menu format = new Menu("格式");
	MenuItem commenItem = new MenuItem("注释");
	MenuItem cancelItem = new MenuItem("取消注释");
	private TextArea ta = new TextArea(6,40);
	public void init() {
		ActionListener menuListener = e ->{
			String cmd = e.getActionCommand();
			ta.append("单击"+cmd+"菜单"+"\n");
			if (cmd.equals("退出")) {
				System.exit(0);
			}
		};
		
		commenItem.addActionListener(menuListener);
		 exitItem.addActionListener(menuListener);
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		edit.add(autoWrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		format.add(commenItem);
		format.add(cancelItem);
		edit.add(new MenuItem("-"));
		edit.add(format);
		edit.add(file);
		edit.add(edit);
		mb.add(file);
		mb.add(edit);
		f.setMenuBar(mb);
		f.addWindowFocusListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new SimpleMenu().init();
	}
}

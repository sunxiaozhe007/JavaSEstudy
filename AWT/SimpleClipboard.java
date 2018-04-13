package AWT;
/**
 * 简单的粘贴复制板
 */
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 * 
 * @author Administrator
 *
 */


public class SimpleClipboard {
	private Frame f = new Frame();
	//获取系统剪贴板
	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	//创建本地剪贴板
	Clipboard clipboard1 = new Clipboard("cb");
	//复制文本的文本框
	private TextArea jtaCopyTo = new TextArea(5,20);
	//粘贴文本的文本框
	private TextArea jtaPaste = new TextArea(5,20);
	private JButton btCopy = new JButton("复制");
	private JButton btPaste = new JButton("粘贴");
	public void init() {
		Panel p = new Panel();
		p.add(btCopy);
		p.add(btPaste);
		btCopy.addActionListener(event ->{
			//将一个多行文本域里的字符串封装成StringSelection对象
			StringSelection contents = new StringSelection(jtaCopyTo.getText());
			//将StringSelection对象放入剪贴板
			clipboard.setContents(contents, null);
		});
		btPaste.addActionListener(event ->{
			try
			{
				//如果剪贴板中包含stringFlavor内容
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				//取出剪贴板中的stringFlavor内容
				String content = (String)clipboard.getData(DataFlavor.stringFlavor);
				jtaPaste.append(content);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});
		//创建一个水平排列的Box容器
		Box box = new Box(BoxLayout.X_AXIS);
		//将两个多行文本域放在Box容器中
		box.add(jtaCopyTo);
		box.add(jtaPaste);
		//将按钮所在的Panel Box容器添加到Frame窗口中
		f.add(p , BorderLayout.SOUTH);
		f.add(box , BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new SimpleClipboard().init();
	}

}

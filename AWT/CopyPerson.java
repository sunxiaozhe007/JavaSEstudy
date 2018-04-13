package AWT;
/**
 * 复制粘贴对象
 * @author Administrator
 *
 */

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import javax.swing.JButton;

public class CopyPerson {
	Frame f = new Frame("复制对象");
	JButton copy = new JButton("复制");
	JButton paste = new JButton("粘贴");
	TextField name = new TextField(15);
	TextField age = new TextField(15);
	TextArea ta = new TextArea(3 , 30);
	Clipboard clipboard = new Clipboard("cp");
	public void init () {
		Panel p = new Panel();
		p.add(new Label("姓名"));
		p.add(name);
		p.add(new Label("年龄"));
		p.add(age);
		f.add(p , BorderLayout.NORTH);
		f.add(ta);
		Panel bp = new Panel();
		copy.addActionListener(e -> copyPerson());
			paste.addActionListener(e ->{
				try {
					readPerson();
				}
				catch (Exception ee)
				{
					ee.printStackTrace();
				}
			});
			bp.add(copy);
			bp.add(paste);
			f.add(bp , BorderLayout.SOUTH);
			f.pack();
			f.setVisible(true);
	}
	
	public void copyPerson() {
		CopyPerson p = new CopyPerson();
		LocalObjectSelection ls = new LocalObjectSelection(p);
		clipboard.setContents(ls, null);
	}
	public  void readPerson()throws Exception {
		DataFlavor peronFlavor = new DataFlavor("application/x-java-local-objectref;class=Person");
		if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			Object p = clipboard.getData(peronFlavor);
			ta.setText(p.toString());
		}
	}
	
	public static void main(String[] args) {
		new CopyPerson().init();
}
}

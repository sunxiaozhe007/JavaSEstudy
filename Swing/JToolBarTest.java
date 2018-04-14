package Swing;
/**
 * 
 * @author Administrator
 *
 */

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

import javax.print.attribute.standard.MediaName;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class JToolBarTest {
	JFrame jf = new JFrame("测试工具条");
	JTextArea jta = new JTextArea(6 , 35);
	JToolBar jtb = new JToolBar();
	JMenuBar jmb = new JMenuBar();
	JMenu edit = new JMenu("编辑");
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	Action pasteAction = new AbstractAction("粘贴" , new ImageIcon("image/paste.png")) {
		public void actionPerformed(ActionEvent e) {
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				try
				{
					String content = (String) clipboard.getData(DataFlavor.stringFlavor);
					jta.replaceRange(content, jta.getSelectionStart(), jta.getSelectionEnd());
				}
				catch(Exception ee) {
					ee.printStackTrace();
					
				}
				
			}
		}
	}; 
	Action copyAction = new AbstractAction("复制" , new ImageIcon("image/copy.png")) {
		public void actionPerformed(ActionEvent e) {
			StringSelection contents = new StringSelection(jta.getSelectedText());
			clipboard.setContents(contents, null);
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
				pasteAction.setEnabled(true);
				
			}
		} 

	};
	public void init() {
		pasteAction.setEnabled(false);
		jf.add(new JScrollPane(jta));
		JButton copyBn = new JButton(copyAction);
		JButton pasteBn = new JButton(pasteAction);
		JPanel jp = new JPanel();
		jp.add(copyBn);
		jp.add(pasteBn);
		jf.add(jp , BorderLayout.SOUTH);
		jtb.add(copyAction);
		jtb.addSeparator();
		jtb.add(pasteAction);
		edit.add(copyAction);
		edit.add(pasteAction);
		jmb.add(edit);
		jf.setJMenuBar(jmb);
		jtb.add(jtb , BorderLayout.NORTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
		
	}
	public static void main(String[] args) {
		new JToolBarTest().init();
	}

}
